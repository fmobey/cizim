

import java.awt.Color;
import java.awt.Graphics;


abstract class MyBoundedShape extends MyShape
{
    private boolean fill;
    
    public MyBoundedShape() {
        super();
        fill = false;
    }
    
    public MyBoundedShape(int startX, int startY, int endX, int endY, Color color, boolean fill) {
        super(startX, startY, endX, endY, color);
        this.fill = fill;
    }
    

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public int getUpperLeftX() {
        return Math.min(getStartX(), getEndX());
    }

    public int getUpperLeftY() {
        return Math.min(getStartY(), getEndY());
    }
    
    public int getWidth() {
        return Math.abs(getStartX() - getEndX());
    }
  
    public int getHeight() {
        return Math.abs(getStartY() - getEndY());
    }
    
    public boolean getFill() {
        return fill;
    }
    
    abstract public void draw( Graphics g );
}
