
public class GreenZombieDie extends ZombieDie{
    private int i;
    public GreenZombieDie(int dieColor) {super(dieColor);}
    public void roll(){
        i=((int)(Math.random()*6));
        if(i%2==0)
        {
            super.setValue(ZombieDie.BRAIN);
        }
        else if(i==3)
        {
            super.setValue(ZombieDie.SHOT);
        }
        else
        {
            super.setValue(ZombieDie.RUNNER);
        }
    }
}
