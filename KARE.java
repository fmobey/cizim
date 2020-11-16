

import java.awt.Color;
import java.awt.Graphics;


public class KARE extends MyBoundedShape
{ 
    public KARE() {
        super();
    }

    public KARE(int startX, int startY, int endX, int endY, Color color, boolean fill) {
        super(startX, startY, endX, endY, color, fill);
    }
    
    @Override
    public void draw( Graphics g ) {
        g.setColor(getColor());
        if (getFill()) {
            g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        }
        else {
            g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        }
    }
}
