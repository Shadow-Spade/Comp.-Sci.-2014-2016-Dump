public class Car extends FroggerItem{
    public static final int SEMI=0,LIMO=1,CAR_1=2,CAR_2=3;
    public Car(int type,double x, double y, int direction, double speed)
    {super(x,y,direction,speed,type);}
    public int getWidth() {
        if(getType()==SEMI) {return 120;}
        else if(getType()==LIMO) {return 80;}
        else {return 40;}
    }
}
