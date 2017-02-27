import java.util.ArrayList;

public class Lane {
    public static final int LEFT=2, RIGHT=3;
    private int y, direction;
    private double speed;
    private ArrayList<FroggerItem> laneItems= new ArrayList<FroggerItem>();
    public Lane(double y, int direction, double speed) {
        this.y=(int)y;
        this.direction=direction;
        this.speed=speed;
    }

    public int getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    public double getSpeed() {
        return speed;
    }

    public ArrayList<FroggerItem> getLaneItems() {
        return laneItems;
    }
    public void update() {
        for(FroggerItem a: laneItems) {
            a.update();
        }
    }
}
