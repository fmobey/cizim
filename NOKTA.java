
import java.awt.Color;
import java.awt.Graphics;



public class NOKTA extends MyBoundedShape
{ 
    public NOKTA() {
        super();
    }
    
    public NOKTA(int startX, int startY, int endX, int endY, Color color, boolean fill) {
        super(startX, startY, endX, endY, color, fill);
    }

    @Override
    public void draw( Graphics g ) {
        g.setColor(getColor());
        if (getFill()) {
            g.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        }
        else {
            g.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        }
    }
}
