public class Turtle extends FroggerItem{
    public static final int ONE_TURTLE=0,TWO_TURTLE=1,THREE_TURTLE=2,UP=0,HALF_UP=1,DOWN=2,HALF_DOWN=3,ALWAYS_UP=4;
    private int timer, mode;
    public Turtle(int type, double x, double y, int direction, double speed) {
        super(x,y,direction,speed,type);
    }
    public int getMode() {
        return mode;
    }
    @Override
    public void update() {
        super.update();
    }
    @Override
    public int getWidth() {
        if(getType()==ONE_TURTLE) {return 40;}
        else if(getType()==TWO_TURTLE) {return 80;}
        else if(getType()==THREE_TURTLE) {return 120;}
        else {return 0;}
    }
}
