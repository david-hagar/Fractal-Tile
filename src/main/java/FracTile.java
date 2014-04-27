
/**
 * Title:        <p>
 * Description:  <p>
 * Copyright:    Copyright (c) <p>
 * Company:      <p>
 * @author
 * @version 1.0
 */
import java.awt.Canvas;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import java.awt.print.*;

public class FracTile extends Canvas implements Printable {

  int level = 3;
  public AffineTransform transforms[] = new AffineTransform[4];
  public Shape shape = new GeneralPath();
  double xtrans[] = new double[] { -1.0 , 1.0 , -1.0,  1.0};
  double ytrans[] = new double[] { -1.0 , -1.0 , 1.0,  1.0};
  private Graphics2D g = null;

  public FracTile()
  {
  for(int i =0 ;i<4;i++)
    {
    transforms[i] = new AffineTransform();
    transforms[i].scale(0.5,0.5);
    transforms[i].translate(xtrans[i],ytrans[i]);
    }

  GeneralPath p = new GeneralPath();
  p.moveTo(  1.0f, 1.0f );
  p.lineTo(  1.0f, -1.0f );
  p.lineTo(  1/3.0f, -1.0f );
  p.lineTo(  1/3.0f, 1/3.0f );
  p.lineTo(  -1.0f, 1/3.0f );
  p.lineTo(  -1.0f, 1.0f );
  shape = p;

  }

  public void reset()
  {
    for(int i =0 ;i<4;i++)
      {
      transforms[i] = new AffineTransform();
      transforms[i].scale(0.5,0.5);
      transforms[i].translate(xtrans[i],ytrans[i]);
      }

    level = 3;
  }



  public void paint(Graphics g1d)
  {
    Dimension size = getSize();
    paint( g1d, size );
  }

  public void paint(Graphics g1d, Dimension size )
  {
    g = (Graphics2D) g1d;

    g.setColor(Color.white);
    g.fill(new Rectangle(0, 0, size.width, size.height));

    g.setColor(Color.black);
    g.setStroke(new BasicStroke(0));
    g.setRenderingHint(
        RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);

    AffineTransform defaultTransform = g.getTransform();

    defaultTransform.translate(size.width / 2.0, size.height / 2.0);
    double scale = Math.min(size.width, size.height) / 2.0;
    defaultTransform.scale(scale, scale);
    recurse(defaultTransform, level);
  }

void recurse( AffineTransform t, int level )
{
  if( --level == 0 )
  {
    g.setTransform(t);
    g.fill(shape);
    return;
  }

  for(int i =0 ;i<4;i++)
    {
    AffineTransform nt = new AffineTransform( t );
    nt.concatenate(transforms[i]);
    recurse( nt, level );
    }

}



public void update()
{
  repaint();
}


public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws
    PrinterException
{
  if (pageIndex >= 1)
    return Printable.NO_SUCH_PAGE;

  Graphics2D g2d = (Graphics2D) graphics;

  double h = pageFormat.getImageableHeight();
  double w = pageFormat.getImageableWidth();
  double x = pageFormat.getImageableX();
  double y = pageFormat.getImageableY();

  g2d.translate(x, y);
  Dimension size = new Dimension( (int) w, (int) h);

  paint( graphics, size);

  return Printable.PAGE_EXISTS;
}



}
