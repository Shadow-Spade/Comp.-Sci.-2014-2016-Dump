import java.awt.Color;
public class DrawingRectangle
{
    int x,y,w,h;
    Color color;
    public DrawingRectangle(int x, int y, int w,int h, Color color) {
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
        this.color=color;
    }
    public int getX() {return x;}
    public int getY() {return y;}
    public int getH() {return h;}
    public int getW() {return w;}
    public Color getColor() {return color;}
    public void setColor(Color color)
    {
        this.color=color;
    }
}