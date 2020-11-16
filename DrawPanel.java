
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.nio.file.FileAlreadyExistsException;

public class DrawPanel extends JPanel 
{
  private LinkedList<MyShape> myShapes;
  private LinkedList<MyShape> clearedShapes;

  // current shape variables
  private String currentShapeType;
  private MyShape currentShapeObject;
  private Color currentShapeColor;
  private boolean currentShapeFilled;
  private JLabel statusLabel;

  public DrawPanel() 
  {
    myShapes = new LinkedList<MyShape>();
    clearedShapes = new LinkedList<MyShape>();

    // Initialize default Shape variables
    currentShapeType = "CİZGİ";
    currentShapeObject = null;
    currentShapeColor = Color.BLACK;
    currentShapeFilled = false;

    statusLabel = new JLabel("");

    setLayout(new BorderLayout());
    setBackground(Color.WHITE);
    add(statusLabel, BorderLayout.SOUTH);

    MouseHandler handler = new MouseHandler();                             
    addMouseListener(handler);
    addMouseMotionListener(handler);
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    int width = getWidth(), height = getHeight();

    ArrayList<MyShape> shapeArr = myShapes.getArray();
    for (int counter = shapeArr.size() - 1; counter >= 0; counter --) {
      shapeArr.get(counter).draw(g);
    }

    if (currentShapeObject != null) {
      currentShapeObject.draw(g);
    }
  }
  public void clearLastShape() {
    if (!myShapes.isEmpty()) {
        clearedShapes.addFront(myShapes.removeFront());
        repaint();
    }
  }
  public void redoLastShape() {
    if (!clearedShapes.isEmpty()) {
        myShapes.addFront(clearedShapes.removeFront());
        repaint();
    }
  }






  public void setCurrentShapeType(String type) {
    currentShapeType = type;
  }

  public void setCurrentShapeColor(Color color) {
      currentShapeColor = color;
  }

  public void setCurrentShapeFilled(boolean filled) {
      currentShapeFilled = filled;
  }

  private class MouseHandler extends MouseAdapter
  {
    public void mousePressed(MouseEvent event)
    {
      switch (currentShapeType) {
          case "CİZGİ":
              currentShapeObject = new CIZGI( event.getX(), event.getY(),
                                             event.getX(), event.getY(), currentShapeColor);
              break;
          case "KARE":
              currentShapeObject = new KARE( event.getX(), event.getY(),
                                                  event.getX(), event.getY(), currentShapeColor, currentShapeFilled);
              break;
          case "NOKTA":
              currentShapeObject = new NOKTA( event.getX(), event.getY(),
                                             event.getX(), event.getY(), currentShapeColor, currentShapeFilled);
              break;
      }
    }

    public void mouseReleased(MouseEvent event)
    {
        currentShapeObject.setEndX(event.getX());
        currentShapeObject.setEndY(event.getY());
        
        myShapes.addFront(currentShapeObject);
        
        currentShapeObject = null;
        clearedShapes.makeEmpty();
        repaint();
    }

    public void mouseMoved(MouseEvent event)
    {
        statusLabel.setText(String.format("KORDİNATLAR X: %d Y: %d", event.getX(), event.getY()));
    }

    public void mouseDragged(MouseEvent event)
    {
        currentShapeObject.setEndX(event.getX());
        currentShapeObject.setEndY(event.getY());
        
        statusLabel.setText(String.format("KORDİNATLAR X: %d Y: %d", event.getX(), event.getY()));
        
        repaint();
    }
  }
}
