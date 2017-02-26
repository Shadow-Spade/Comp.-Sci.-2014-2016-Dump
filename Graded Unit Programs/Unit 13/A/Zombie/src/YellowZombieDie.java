
public class YellowZombieDie extends ZombieDie{
    private int i;
    public YellowZombieDie(int dieColor) {super(dieColor);}
    public void roll(){
        i=((int)(Math.random()*3));
        if(i==0)
        {
            super.setValue(ZombieDie.BRAIN);
        }
        else if(i==1)
        {
            super.setValue(ZombieDie.RUNNER);
        }
        else
        {
            super.setValue(ZombieDie.SHOT);
        }
    }
}
