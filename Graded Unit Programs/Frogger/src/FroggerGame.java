public class FroggerGame {
    public static final int PLAYING=0,DEAD=1,PLAYER_WINS=2,MAX_LIFE_TIME=80,WIDTH=800;
    private int status, startLifeTime,lives;
    private Frog player;
    private boolean reachedMiddle;
    private LillyPad[] lillyPads=new LillyPad[4];
    private LogLane[] logLanes=new LogLane[3];
    private CarLane[] carLanes=new CarLane[5];
    private TurtleLane[] turtleLanes=new TurtleLane[2];
    public FroggerGame() {
        status=PLAYING;
        player=new Frog(400,520);
        reachedMiddle=false;
        lives=3;
        //lillys
        lillyPads[0]=new LillyPad(122,40);
        lillyPads[1]=new LillyPad(122+172,40);
        lillyPads[2]=new LillyPad(122+(2*172),40);
        lillyPads[3]=new LillyPad(122+(3*172),40);
        //Cars
        carLanes[0]=new CarLane(Car.LEFT,6,480);
        carLanes[1]=new CarLane(Car.RIGHT,9,440);
        carLanes[2]=new CarLane(Car.LEFT,6,400);
        carLanes[3]=new CarLane(Car.RIGHT,3,360);
        carLanes[4]=new CarLane(Car.LEFT,6,320);
        //TODO add other stuff
    }
    public void update() {
        for(Lane cl: carLanes) {
            cl.update();
        }
        runChecks();
    }
    public int getStatus() {
        return status;
    }
    public int getLives() {
        return lives;
    }
    public LillyPad[] getLillyPads() {
        return lillyPads;
    }
    public Frog getPlayer() {
        return player;
    }
    public LogLane[] getLogLanes() {
        return logLanes;
    }
    public CarLane[] getCarLanes() {
        return carLanes;
    }
    public TurtleLane[] getTurtleLanes() {
        return turtleLanes;
    }
    public void carCheck() {
        for(int x=0; x<carLanes.length; x++) {
            for (int y = 0; y < carLanes[x].getLaneItems().size(); y++){
                if (player.getRect().intersects(carLanes[x].getLaneItems().get(y).getRect())) {
                    playerDeath();
                }
            }
        }
    }
    public void logCheck() {
        //TODO
    }
    public void turtleCheck() {
        //TODO
    }
    public void lilyCheck() {
        for(int x=0; x<lillyPads.length; x++) {
            if(player.getRect().intersects(lillyPads[x].getRect())&&!lillyPads[x].isFrog()){
                lillyPads[x].setFrog(true);
                player.setX(400);
                player.setY(520);
                player.setDirection(Frog.UP);
            }
        }
        int count=0;
        for(int x=0;x<lillyPads.length;x++) {
            if(lillyPads[x].isFrog()){
                count++;
            }
            if(count==4) {
                status=PLAYER_WINS;
            }
        }
        count=0;
    }
    public void runChecks() {
        carCheck();
        lilyCheck();
        logCheck();
        turtleCheck();
    }
    public void playerDeath() {
        lives--;
        if(reachedMiddle){
            player.setY(280);
        }
        else{
            player.setY(520);
        }
        player.setX(400);
        player.updateRectangle();
        if(lives<1){
            status=DEAD;
        }
    }
}
