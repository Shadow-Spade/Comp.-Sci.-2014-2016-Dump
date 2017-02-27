public class LillyPad extends FroggerItem {
    boolean frog;
    public LillyPad(double x, double y) {
        super(x,y,0,0,0);
    }
    public boolean isFrog() {
        return frog;
    }
    public void setFrog(boolean frog) {
        this.frog = frog;
    }
    @Override
    public int getWidth() {
        return 40;
    }
}
