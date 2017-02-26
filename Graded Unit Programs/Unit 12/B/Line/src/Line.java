public class Line {
    private double slope, xInt, yInt;
    private Mypoint p1, p2;
    public Line(Mypoint p1, Mypoint p2) {
        this.p2 = p2;
        this.p1 = p1;
        slope=(p2.getY()-p1.getY())/(p2.getX()-p1.getX());

    }
    public double getxInt() {
        xInt=(p1.getX()-(p1.getY()/slope));
        yInt=((slope*(0-p1.getX()))+p1.getY());
        slope=(p2.getY()-p1.getY())/(p2.getX()-p1.getX());
        return xInt;
    }
    public double getyInt() {
        xInt=(p1.getX()-(p1.getY()/slope));
        yInt=((slope*(0-p1.getX()))+p1.getY());
        slope=(p2.getY()-p1.getY())/(p2.getX()-p1.getX());
        return yInt;
    }
    public Mypoint getP1() {
        xInt=(p1.getX()-(p1.getY()/slope));
        yInt=((slope*(0-p1.getX()))+p1.getY());
        slope=(p2.getY()-p1.getY())/(p2.getX()-p1.getX());
        return p1;
    }
    public Mypoint getP2() {
        xInt=(p1.getX()-(p1.getY()/slope));
        yInt=((slope*(0-p1.getX()))+p1.getY());
        slope=(p2.getY()-p1.getY())/(p2.getX()-p1.getX());
        return p2;
    }
    public double getSlope() {
        xInt=(p1.getX()-(p1.getY()/slope));
        yInt=((slope*(0-p1.getX()))+p1.getY());
        slope=(p2.getY()-p1.getY())/(p2.getX()-p1.getX());
        return slope;
    }
    public void setP1(Mypoint p1) {
        this.p1 = p1;
    }
    public void setP2(Mypoint p2) {
        this.p2 = p2;
    }
    public String toString() {
        return "Line{" +
                "\nslope=" + slope +
                "\nxInt=" + xInt +
                "\nyInt=" + yInt +
                "\np1=" + p1 +
                "\np2=" + p2 +
                "\nEquation= y="+slope+"x"+yInt+
                "\n}";
    }
}
