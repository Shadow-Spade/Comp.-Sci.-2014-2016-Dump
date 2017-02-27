import java.awt.*;

public class Frog extends FroggerItem{
    public static final int UP=0,DOWN=1;
    private Rectangle waterRect;
    Frog(double x, double y) {super(x,y,UP,40,0);}
    @Override
    public void updateRectangle() {
        waterRect= new Rectangle((int)x,(int)y,getWidth(),getHeight());
        super.updateRectangle();
    }
    public Rectangle getWaterRect() {
        return waterRect;
    }
    @Override
    public int getWidth() {
        return 40;
    }
}
