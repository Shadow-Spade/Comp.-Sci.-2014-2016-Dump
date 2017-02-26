import java.util.ArrayList;

public class ZombieDiceBucket {
    ArrayList<ZombieDie> dice;
    public ZombieDiceBucket() {
        dice = new ArrayList<ZombieDie>();
    }
    public void loadBucket() {
        dice.clear();
        dice.add(new RedZombieDie(ZombieDie.RED));
        dice.add(new RedZombieDie(ZombieDie.RED));
        dice.add(new RedZombieDie(ZombieDie.RED));
        dice.add(new YellowZombieDie(ZombieDie.YELLOW));
        dice.add(new YellowZombieDie(ZombieDie.YELLOW));
        dice.add(new YellowZombieDie(ZombieDie.YELLOW));
        dice.add(new YellowZombieDie(ZombieDie.YELLOW));
        dice.add(new GreenZombieDie(ZombieDie.GREEN));
        dice.add(new GreenZombieDie(ZombieDie.GREEN));
        dice.add(new GreenZombieDie(ZombieDie.GREEN));
        dice.add(new GreenZombieDie(ZombieDie.GREEN));
        dice.add(new GreenZombieDie(ZombieDie.GREEN));
        dice.add(new GreenZombieDie(ZombieDie.GREEN));
    }
    public ZombieDie draw() {
        if(dice.size()==0) {
            return null;
        }
        return dice.remove((int)(Math.random()*dice.size()));
    }
}
