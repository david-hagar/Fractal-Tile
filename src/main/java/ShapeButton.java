
/**
 * Title:        <p>
 * Description:  <p>
 * Copyright:    Copyright (c) <p>
 * Company:      <p>
 * @author 
 * @version 1.0
 */
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class ShapeButton extends Panel {
  Shape shape = new GeneralPath();
  public ShapeButton() {
    super();
      this.setPreferredSize(new Dimension(75,75));
  }
  
public void paint(Graphics g1d)
{
  super.paint(g1d);
  Graphics2D g = (Graphics2D)g1d;
  g.setColor(Color.black);
  g.setStroke(new BasicStroke(0));

  Dimension size = getSize();
  //int edge = Math.min(size.width,size.height);
  int offset = (int) (size.width * 0.1);
  g.draw3DRect( offset, offset, size.width-offset*2, size.height-offset*2 ,false );
  
  AffineTransform defaultTransform = g.getTransform();
  g.translate( size.width/2.0 , size.height/2.0);
  double scale = Math.min(size.width,size.height) / 3.0;
  g.scale( scale, scale  );
  
  g.fill( shape );
  g.setTransform(defaultTransform);
}  
  
  public Dimension getMinimumSize() {
    return new Dimension(20, 20);
  }

  public Dimension getPreferredSize() {
    return new Dimension(30, 30);
  }
  public void setShape( Shape shape ) { this.shape=shape; }
  public Shape getShape(  ) { return shape; }
}
