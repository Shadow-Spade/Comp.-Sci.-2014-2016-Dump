public class LogLane extends Lane {
    public LogLane(int direction, double speed, double y){
        super(y,direction,speed);
    }
    @Override
    public void update() {
        super.update();
        //TODO remove Log
    }
}
