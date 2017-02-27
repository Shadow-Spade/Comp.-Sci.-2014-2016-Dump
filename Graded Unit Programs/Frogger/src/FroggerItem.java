import java.awt.*;

public abstract class FroggerItem {
    public static final int LEFT=2,RIGHT=3;
    double x,y,speed;
    int direction, type;
    Rectangle rect;
    public FroggerItem(double x,double y,int direction, double speed, int type) {
        this.x=x;
        this.y=y;
        this.direction=direction;
        this.speed=speed;
        this.type=type;
        update();
    }
    public abstract int getWidth();
    public int getHeight(){
        return 40;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getSpeed() {
        return speed;
    }
    public int getDirection() {
        return direction;
    }
    public int getType() {
        return type;
    }
    public Rectangle getRect() {
        return rect;
    }
    public void setX(double x) {
        this.x = x;
        updateRectangle();
    }
    public void setY(double y) {
        this.y = y;
        updateRectangle();
    }
    public void setRect(Rectangle rect) {
        this.rect = rect;
    }
    public void setDirection(int direction) {
        this.direction = direction;
    }
    public void update() {
        if(direction==LEFT) {
            x-=speed;
        }
        else if(direction==RIGHT) {
            x+=speed;
        }
        updateRectangle();
    }
    public void updateRectangle() {
        rect = new Rectangle((int)x,(int)y,getWidth(),getHeight());
    }
}
