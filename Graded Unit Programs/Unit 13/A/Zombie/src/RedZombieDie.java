
public class RedZombieDie extends ZombieDie {
    private int i;
    public RedZombieDie(int dieColor) {super(dieColor);}
    public void roll()
    {
        i=((int)(Math.random()*6));
        if(i==0)
        {
            super.setValue(ZombieDie.BRAIN);
        }
        else if(i==1||i==2)
        {
            super.setValue(ZombieDie.RUNNER);
        }
        else
        {
            super.setValue(ZombieDie.SHOT);
        }
    }

}
