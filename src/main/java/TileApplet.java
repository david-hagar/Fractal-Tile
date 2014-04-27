import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.applet.*;
import java.awt.print.*;
import javax.swing.*;

public class TileApplet extends Applet {
  static GeneralPath shape0 = new GeneralPath();
  static GeneralPath shape1 = new GeneralPath();
  static GeneralPath shape2 = new GeneralPath();
  static GeneralPath shape3 = new GeneralPath();
  static GeneralPath shape4 = new GeneralPath();
  static GeneralPath shape5 = new GeneralPath();
  static GeneralPath shape6 = new GeneralPath();
  static GeneralPath shape7 = new GeneralPath();
  static GeneralPath shape8 = new GeneralPath();
  static GeneralPath shape9 = new GeneralPath();
  static GeneralPath shape10 = new GeneralPath();
  static GeneralPath shape11 = new GeneralPath();

  static
  {
  shape0.moveTo( -1.0f, 0.0f );
  shape0.lineTo(  1.0f, -1.0f );
  shape0.lineTo(  1.0f, 1.0f );

  shape1.moveTo(  1.0f, 1.0f );
  shape1.lineTo(  1.0f, -1.0f );
  shape1.lineTo(  1/3.0f, -1.0f );
  shape1.lineTo(  1/3.0f, 1/3.0f );
  shape1.lineTo(  -1.0f, 1/3.0f );
  shape1.lineTo(  -1.0f, 1.0f );

  shape2.moveTo(  1.0f, 1/3.0f );
  shape2.lineTo(  1.0f, -1/3.0f );
  shape2.lineTo(  -1/3.0f, 1.0f );
  shape2.lineTo(   1/3.0f, 1.0f );

  shape2.moveTo(  -1.0f, -1/3.0f );
  shape2.lineTo(  -1.0f,  1/3.0f );
  shape2.lineTo(   1/3.0f, -1.0f );
  shape2.lineTo(  -1/3.0f, -1.0f );

  shape3.moveTo(  -1.0f, -1/3.0f );
  shape3.lineTo(  -1.0f,  1/3.0f );
  shape3.lineTo(   1.0f,  1/3.0f );
  shape3.lineTo(   1.0f, -1/3.0f );

  shape4.moveTo(  -1.0f, -1/3.0f );
  shape4.lineTo(  -1.0f,  1/3.0f );
  shape4.lineTo( -1/3.0f,  1/3.0f );
  shape4.lineTo(  -1.0f,  1.0f );
  shape4.lineTo(   1.0f,  1.0f );
  shape4.lineTo( 1/3.0f,  1/3.0f );
  shape4.lineTo(   1.0f,  1/3.0f );
  shape4.lineTo(   1.0f, -1/3.0f );

  shape5.moveTo(  -1.0f, -1/3.0f );
  shape5.lineTo(  -1.0f,  1/3.0f );
  shape5.lineTo( -1/3.0f,  1/3.0f );
  shape5.lineTo(  -1/3.0f,  1.0f );
  shape5.lineTo(  1/3.0f,  1.0f );
  shape5.lineTo( 1/3.0f,  1/3.0f );
  shape5.lineTo(   1.0f,  1/3.0f );
  shape5.lineTo(   1.0f, -1/3.0f );

  shape6.moveTo(  1.0f, -1/3.0f );
  shape6.lineTo(  1.0f,  1/3.0f );
  shape6.lineTo(  -1.0f,  1/3.0f );
  shape6.lineTo(  -1.0f,  -1/3.0f );
  shape6.lineTo(  -1.0f,  -1.0f );

  shape7.moveTo(  0.0f, 1.0f );
  shape7.lineTo(  1.0f,  1.0f );
  shape7.lineTo(  1.0f,  -1.0f );
  shape7.lineTo(  0.0f,  -1.0f );

  shape8.moveTo(  1.0f, 1.0f );
  shape8.lineTo(  1.0f,  -1.0f );
  shape8.lineTo(  -1.0f,  -1.0f );

  shape9.moveTo(  -1.0f, -0.5f );
  shape9.lineTo(  -1.0f,  0.5f );
  shape9.lineTo(  -0.5f,  1.0f );
  shape9.lineTo(  0.5f,  1.0f );

  shape9.lineTo(  -0.5f,  -1.0f );
  shape9.lineTo(  0.5f,  -1.0f );
  shape9.lineTo(  1.0f,  -0.5f );
  shape9.lineTo(  1.0f,  0.5f );

  shape10.moveTo(  1.0f, 1.0f );
  shape10.lineTo(  1.0f,  0.0f );
  shape10.lineTo(  0.0f,  -1.0f );
  shape10.lineTo(  -1.0f,  -1.0f );
  shape10.lineTo(  -1.0f,  0.0f );
  shape10.lineTo(  0.0f,  1.0f );

  shape11.moveTo(  -1.0f, -0.5f );
  shape11.lineTo(  -1.0f,  0.5f );
  shape11.lineTo(  -0.5f,  1.0f );
  shape11.lineTo(  0.5f,  1.0f );

  shape11.moveTo(  -0.5f,  -1.0f );
  shape11.lineTo(  0.5f,  -1.0f );
  shape11.lineTo(  1.0f,  -0.5f );
  shape11.lineTo(  1.0f,  0.5f );
  }

  FracTile fracTile = new FracTile();
  int currentQuadrant = 0;

  boolean isStandalone = false;
  Panel homePanel = new Panel();
  BorderLayout borderLayout1 = new BorderLayout();
  Panel panel1 = new Panel();
  BorderLayout borderLayout2 = new BorderLayout();
  BorderLayout borderLayout3 = new BorderLayout();
  Panel panel2 = new Panel();
  TextField IndexTextField = new TextField();
  Button PrevLevel = new Button();
  GridLayout gridLayout1 = new GridLayout();
  Button NextLevel = new Button();
  Panel panel4 = new Panel();
  Button buttonQ4 = new Button();
  Button buttonQ3 = new Button();
  Button buttonQ2 = new Button();
  Button buttonQ1 = new Button();
  GridLayout gridLayout2 = new GridLayout();
  Panel panel3 = new Panel();
  BorderLayout borderLayout4 = new BorderLayout();
  Panel panel5 = new Panel();
  Button RotPlus90 = new Button();
  GridLayout gridLayout3 = new GridLayout();
  Button FlipY = new Button();
  Button FlipX = new Button();
  Button RotMinus90 = new Button();
  Label label1 = new Label();
  Panel panel7 = new Panel();
  GridLayout gridLayout4 = new GridLayout();
  Panel panel6 = new Panel();
  ShapeButton imageButton3 = new ShapeButton();
  ShapeButton imageButton2 = new ShapeButton();
  ShapeButton imageButton1 = new ShapeButton();
  ShapeButton imageButton0 = new ShapeButton();
  BorderLayout borderLayout5 = new BorderLayout();
  ShapeButton imageButton4 = new ShapeButton();
  ShapeButton imageButton5 = new ShapeButton();
  ShapeButton imageButton6 = new ShapeButton();
  ShapeButton imageButton7 = new ShapeButton();
  ShapeButton imageButton8 = new ShapeButton();
  ShapeButton imageButton9 = new ShapeButton();
  ShapeButton imageButton10 = new ShapeButton();
  ShapeButton imageButton11 = new ShapeButton();
  Button PrintButton = new Button();
  Button ResetButton = new Button();

  //Get a parameter value
  public String getParameter(String key, String def) {
    return isStandalone ? System.getProperty(key, def) :
      (getParameter(key) != null ? getParameter(key) : def);
  }

  //Construct the applet
  public TileApplet() {
  }

  //Initialize the applet
  public void init() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  //Component initialization
  private void jbInit() throws Exception {
    this.setLayout(borderLayout1);
    homePanel.setLayout(borderLayout2);
    panel1.setLayout(borderLayout3);
    IndexTextField.setText("1");
    IndexTextField.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        IndexTextField_actionPerformed(e);
      }
    });
    IndexTextField.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        IndexTextField_actionPerformed(e);
      }
    });
    PrevLevel.setLabel("Prev Level");
    PrevLevel.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        PrevLevel_actionPerformed(e);
      }
    });
    panel2.setLayout(gridLayout1);
    gridLayout1.setColumns(1);
    gridLayout1.setRows(5);
    NextLevel.setLabel("Next Level");
    NextLevel.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        NextLevel_actionPerformed(e);
      }
    });
    buttonQ4.setLabel("4");
    buttonQ4.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        buttonQ4_actionPerformed(e);
      }
    });
    buttonQ3.setLabel("3");
    buttonQ3.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        buttonQ3_actionPerformed(e);
      }
    });
    buttonQ2.setLabel("2");
    buttonQ2.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        buttonQ2_actionPerformed(e);
      }
    });
    buttonQ1.setLabel("1");
    buttonQ1.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        buttonQ1_actionPerformed(e);
      }
    });
    gridLayout2.setColumns(2);
    gridLayout2.setRows(2);
    panel3.setLayout(gridLayout2);
    panel4.setLayout(borderLayout4);
    RotPlus90.setLabel("Rot + 90");
    RotPlus90.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        RotPlus90_actionPerformed(e);
      }
    });
    panel5.setLayout(gridLayout3);
    gridLayout3.setColumns(1);
    gridLayout3.setRows(4);
    FlipY.setLabel("Flip Y");
    FlipY.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        FlipY_actionPerformed(e);
      }
    });
    FlipX.setLabel("Flip X");
    FlipX.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        FlipX_actionPerformed(e);
      }
    });
    RotMinus90.setLabel("Rot -90");
    RotMinus90.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        RotMinus90_actionPerformed(e);
      }
    });
    label1.setText("Operations");
    gridLayout4.setColumns(2);
    gridLayout4.setRows(6);
    panel6.setLayout(gridLayout4);
      panel6.setPreferredSize(new Dimension(100,300));
    imageButton3.setShape(shape3);
    imageButton3.addMouseListener(new java.awt.event.MouseAdapter() {

      public void mousePressed(MouseEvent e) {
        imageButton3_mousePressed(e);
      }
    });
    imageButton2.setShape(shape2);
    imageButton2.addMouseListener(new java.awt.event.MouseAdapter() {

      public void mousePressed(MouseEvent e) {
        imageButton2_mousePressed(e);
      }
    });
    imageButton1.setShape(shape1);
    imageButton1.addMouseListener(new java.awt.event.MouseAdapter() {

      public void mousePressed(MouseEvent e) {
        imageButton1_mousePressed(e);
      }
    });
    imageButton0.setShape(shape0);
    imageButton0.addMouseListener(new java.awt.event.MouseAdapter() {

      public void mousePressed(MouseEvent e) {
        imageButton0_mousePressed(e);
      }
    });
    panel7.setLayout(borderLayout5);
    imageButton4.setShape(shape4);
    imageButton4.addMouseListener(new java.awt.event.MouseAdapter() {

      public void mousePressed(MouseEvent e) {
        imageButton4_mousePressed(e);
      }
    });
    imageButton5.setShape(shape5);
    imageButton5.addMouseListener(new java.awt.event.MouseAdapter() {

      public void mousePressed(MouseEvent e) {
        imageButton5_mousePressed(e);
      }
    });
    imageButton6.setShape(shape6);
    imageButton6.addMouseListener(new java.awt.event.MouseAdapter() {

      public void mousePressed(MouseEvent e) {
        imageButton6_mousePressed(e);
      }
    });
    imageButton7.setShape(shape7);
    imageButton7.addMouseListener(new java.awt.event.MouseAdapter() {

      public void mousePressed(MouseEvent e) {
        imageButton7_mousePressed(e);
      }
    });
    imageButton8.addMouseListener(new java.awt.event.MouseAdapter() {

      public void mousePressed(MouseEvent e) {
        imageButton8_mousePressed(e);
      }
    });
    imageButton8.setShape(shape8);
    imageButton9.setShape(shape9);
    imageButton9.addMouseListener(new java.awt.event.MouseAdapter() {

      public void mousePressed(MouseEvent e) {
        imageButton9_mousePressed(e);
      }
    });
    imageButton10.setShape(shape10);
    imageButton10.addMouseListener(new java.awt.event.MouseAdapter() {

      public void mousePressed(MouseEvent e) {
        imageButton10_mousePressed(e);
      }
    });
    imageButton11.addMouseListener(new java.awt.event.MouseAdapter() {

      public void mousePressed(MouseEvent e) {
        imageButton11_mousePressed(e);
      }
    });
    imageButton11.setShape(shape11);
    PrintButton.setLabel("Print");
    PrintButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        PrintButton_actionPerformed(e);
      }
    });
    ResetButton.setLabel("Reset");
    ResetButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ResetButton_actionPerformed(e);
      }
    });
    this.add(homePanel, BorderLayout.CENTER);
    homePanel.add(panel1, BorderLayout.EAST);
    panel1.add(panel2, BorderLayout.SOUTH);
    panel2.add(IndexTextField, null);
    panel2.add(NextLevel, null);
    panel2.add(PrevLevel, null);
    panel2.add(PrintButton, null);
    panel2.add(ResetButton, null);
    panel1.add(panel4, BorderLayout.NORTH);
    panel4.add(panel3, BorderLayout.NORTH);
    panel3.add(buttonQ1, null);
    panel3.add(buttonQ2, null);
    panel3.add(buttonQ3, null);
    panel3.add(buttonQ4, null);
    panel4.add(panel5, BorderLayout.SOUTH);
    panel5.add(RotPlus90, null);
    panel5.add(RotMinus90, null);
    panel5.add(FlipX, null);
    panel5.add(FlipY, null);
    panel4.add(label1, BorderLayout.CENTER);
    panel1.add(panel7, BorderLayout.CENTER);
    panel7.add(panel6, BorderLayout.NORTH);
    panel6.add(imageButton4, null);
    panel6.add(imageButton11, null);
    panel6.add(imageButton10, null);
    panel6.add(imageButton9, null);
    panel6.add(imageButton8, null);
    panel6.add(imageButton7, null);
    panel6.add(imageButton6, null);
    panel6.add(imageButton3, null);
    panel6.add(imageButton2, null);
    panel6.add(imageButton1, null);
    panel6.add(imageButton0, null);
    panel6.add(imageButton5, null);

    homePanel.add(fracTile, BorderLayout.CENTER);
    updateGUI();
  }

  //Start the applet
  public void start() {
  }

  //Stop the applet
  public void stop() {
  }

  //Destroy the applet
  public void destroy() {
  }

  //Get Applet information
  public String getAppletInfo() {
    return "Applet Information";
  }

  //Get parameter info
  public String[][] getParameterInfo() {
    return null;
  }

  //Main method
  public static void main(String[] args) {
    TileApplet applet = new TileApplet();
    applet.isStandalone = true;
    Frame frame;
    frame = new Frame() {

      protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
          System.exit(0);
        }
      }

      public synchronized void setTitle(String title) {
        super.setTitle(title);
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
      }
    };
    frame.setTitle("Applet Frame");
    frame.add(applet, BorderLayout.CENTER);
    applet.init();
    applet.start();
    frame.setSize(900,700);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height) / 2);
    frame.setVisible(true);
  }

  void updateGUI()
  {
  IndexTextField.setText( Integer.toString(fracTile.level) );
  }

  void PrevLevel_actionPerformed(ActionEvent e) {
  fracTile.level--;

  if(fracTile.level <= 0)
    fracTile.level = 1;
  updateGUI();
  fracTile.update();
  }

  void IndexTextField_actionPerformed(ActionEvent e) {
  fracTile.level = Integer.parseInt( (( TextField ) e.getSource() ).getText() );
  fracTile.update();
  }

  void NextLevel_actionPerformed(ActionEvent e) {
  fracTile.level++;
  updateGUI();
  fracTile.update();
  }

  void buttonQ1_actionPerformed(ActionEvent e) {
  currentQuadrant = 0;
  }

  void buttonQ2_actionPerformed(ActionEvent e) {
  currentQuadrant = 1;
  }

  void buttonQ3_actionPerformed(ActionEvent e) {
  currentQuadrant = 2;
  }

  void buttonQ4_actionPerformed(ActionEvent e) {
  currentQuadrant = 3;
  }

  void RotPlus90_actionPerformed(ActionEvent e) {
  fracTile.transforms[currentQuadrant].rotate(Math.toRadians(90.0));
  fracTile.update();
  }

  void RotMinus90_actionPerformed(ActionEvent e) {
  fracTile.transforms[currentQuadrant].rotate(Math.toRadians(-90.0));
  fracTile.update();
  }

  void FlipX_actionPerformed(ActionEvent e) {
  fracTile.transforms[currentQuadrant].scale(-1.0,1.0);
  fracTile.update();
  }

  void FlipY_actionPerformed(ActionEvent e) {
  fracTile.transforms[currentQuadrant].scale(1.0,-1.0);
  fracTile.update();
  }

  void imageButton0_actionPerformed(ActionEvent e) {
  fracTile.shape = (( ShapeButton ) e.getSource() ).getShape();
  fracTile.update();
  }

  void imageButton5_actionPerformed(ActionEvent e) {
  fracTile.shape = (( ShapeButton ) e.getSource() ).getShape();
  fracTile.update();
  }

  void imageButton4_mousePressed(MouseEvent e) {
  fracTile.shape = (( ShapeButton ) e.getSource() ).getShape();
  fracTile.update();
  }

  void imageButton5_mousePressed(MouseEvent e) {
  fracTile.shape = (( ShapeButton ) e.getSource() ).getShape();
  fracTile.update();
  }

  void imageButton0_mousePressed(MouseEvent e) {
  fracTile.shape = (( ShapeButton ) e.getSource() ).getShape();
  fracTile.update();
  }

  void imageButton2_mousePressed(MouseEvent e) {
  fracTile.shape = (( ShapeButton ) e.getSource() ).getShape();
  fracTile.update();
  }

  void imageButton3_mousePressed(MouseEvent e) {
  fracTile.shape = (( ShapeButton ) e.getSource() ).getShape();
  fracTile.update();
  }

  void imageButton1_mousePressed(MouseEvent e) {
  fracTile.shape = (( ShapeButton ) e.getSource() ).getShape();
  fracTile.update();
  }

  void imageButton6_mousePressed(MouseEvent e) {
  fracTile.shape = (( ShapeButton ) e.getSource() ).getShape();
  fracTile.update();
  }

  void imageButton7_mousePressed(MouseEvent e) {
  fracTile.shape = (( ShapeButton ) e.getSource() ).getShape();
  fracTile.update();
  }

  void imageButton8_mousePressed(MouseEvent e) {
  fracTile.shape = (( ShapeButton ) e.getSource() ).getShape();
  fracTile.update();
  }

  void imageButton9_mousePressed(MouseEvent e) {
  fracTile.shape = (( ShapeButton ) e.getSource() ).getShape();
  fracTile.update();
  }


  void imageButton10_mousePressed(MouseEvent e) {
  fracTile.shape = (( ShapeButton ) e.getSource() ).getShape();
  fracTile.update();
  }


  void imageButton11_mousePressed(MouseEvent e) {
  fracTile.shape = (( ShapeButton ) e.getSource() ).getShape();
  fracTile.update();
  }

  void PrintButton_actionPerformed(ActionEvent e) {
    try
    {
    PrinterJob printJob = PrinterJob.getPrinterJob();

    boolean pDialogState = printJob.printDialog();
    if ( ! pDialogState )
      return;

    Book book = new Book();
    PageFormat pageFormat = printJob.defaultPage();

    Paper paper = new Paper();
    paper.setImageableArea(0.0 , 0.0 , 8 *72, 10.3*72);

    pageFormat.setPaper(paper);
    book.append( fracTile, pageFormat );

    if( pageFormat.getOrientation() == pageFormat.LANDSCAPE )
      System.out.println("pageFormat.LANDSCAPE");
    if( pageFormat.getOrientation() == pageFormat.PORTRAIT )
      System.out.println("pageFormat.PORTRAIT");

    printJob.setPageable( book );


    if (pDialogState)
      printJob.print();

    }
    catch (java.security.AccessControlException ace) {
    String errmsg = "Applet access control exception; to allow " +
                            "access to printer, run policytool and set\n" +
                            "permission for \"queuePrintJob\" in " +
                            "RuntimePermission.";
    JOptionPane.showMessageDialog(this, errmsg, "Printer Access Error",
    JOptionPane.ERROR_MESSAGE);
    }
    catch (Exception ex)
      { ex.printStackTrace(); }


  }

  void ResetButton_actionPerformed(ActionEvent e) {

    fracTile.reset();
    fracTile.repaint();
  }




}
