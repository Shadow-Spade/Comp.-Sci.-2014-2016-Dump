public class Log extends FroggerItem {
    public static final int SHORT=0,MEDIUM=1,LONG=2;
    public Log(int type,double x, double y, int direction, double speed) {super(x,y,direction,speed,type);}
    public int getWidth() {
        if(getType()==SHORT) {return 80;}
        else if(getType()==MEDIUM) {return 120;}
        else {return 200;}
    }
}
