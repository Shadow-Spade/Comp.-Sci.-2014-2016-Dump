import java.awt.Color;
public class DrawingLine
{
	int x1,x2,y1,y2;
	Color color;
    public DrawingLine(int x1, int x2, int y1, int y2, Color color) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.color = color;
    }
    public int getX1()
    {
     return x1;
    }
    public int getX2()
    {
        return x2;
    }
    public int getY1() {
        return y1;
    }
    public int getY2() {
        return y2;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color)
    {
        this.color=color;
    }
}