import java.util.ArrayList;

public class CarLane extends Lane{
    public CarLane(int direction, double speed, double y){
        super(y,direction,speed);
    }
    @Override
    public void update() {
        super.update();
        ArrayList<FroggerItem> cars = getLaneItems();
        if(getDirection()==RIGHT) {
            //startup
            if(cars.size()==0) {
                cars.add(new Car((int)(Math.random()*4),0,getY(),getDirection(),getSpeed()));
                Car c = (Car) cars.get(cars.size()-1);
                c.setX(0-c.getWidth()-(int)((Math.random()*90)+120));
            }
            //remove
            if(cars.size()>0 && cars.get(0).getX()>FroggerGame.WIDTH) {
                cars.remove(0);
            }
            //add
            if(cars.size()>0&&cars.get(cars.size()-1).getX()+cars.get(cars.size()-1).getWidth()>0) {
                cars.add(new Car((int)(Math.random()*4),0,getY(),getDirection(),getSpeed()));
                Car c = (Car) cars.get(cars.size()-1);
                c.setX(0-c.getWidth()-(int)((Math.random()*90)+120));
            }
        }
        if(getDirection()==LEFT) {
            //startup
            if(cars.size()==0){
                cars.add(new Car((int)(Math.random()*4),800,getY(),getDirection(),getSpeed()));
                Car c = (Car) cars.get(cars.size()-1);
                c.setX(800+c.getWidth()+(int)((Math.random()*90)+120));
            }
            //remove
            if(cars.size()>0 && cars.get(0).getX()<-120) {
                cars.remove(0);
            }
            //add
            if(cars.size()>0&&cars.get(cars.size()-1).getX()+cars.get(cars.size()-1).getWidth()<750) {
                cars.add(new Car((int)(Math.random()*4),800,getY(),getDirection(),getSpeed()));
                Car c = (Car) cars.get(cars.size()-1);
                c.setX(800+c.getWidth()+(int)((Math.random()*90)+120));
            }
        }
    }
}
