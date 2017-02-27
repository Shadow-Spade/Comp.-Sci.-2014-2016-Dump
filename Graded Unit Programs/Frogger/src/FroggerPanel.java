import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class FroggerPanel extends JPanel implements KeyListener, Runnable{
    private FroggerGame game;
    private long startTime;
    private int updatesPerSecond=25, updateCount;
    private BufferedImage buffer, car1Left, car2Left, car1Right, car2Right,frogUp, frogDown, frogLeft, frogRight, logS, logM, logL, turtleS, turtleM, turtleL, limoLeft, limoRight, lillypad, turtleHS, turtleHM, turtleHL, frogLife, leftSemi, rightSemi;
    public FroggerPanel() {
        setSize(800,600);
        addKeyListener(this);
        try {
            frogDown=ImageIO.read(new File("Images\\Frog Down.png"));
            frogUp=ImageIO.read(new File("Images\\Frog Up.png"));
            frogLeft=ImageIO.read(new File("Images\\Frog Left.png"));
            frogRight=ImageIO.read(new File("Images\\Frog Right.png"));
            frogLife=ImageIO.read(new File("Images\\Frog Life.png"));
            car1Left=ImageIO.read(new File("Images\\Car 1 - Left.png"));
            car1Right=ImageIO.read(new File("Images\\Car 1 - Right.png"));
            car2Left=ImageIO.read(new File("Images\\Car 2 - Left.png"));
            car2Right=ImageIO.read(new File("Images\\Car 2 - RIGHT.png"));
            logL=ImageIO.read(new File("Images\\L-Log.png"));
            logM=ImageIO.read(new File("Images\\M-Log.png"));
            logS=ImageIO.read(new File("Images\\S-Log.png"));
            lillypad=ImageIO.read(new File("Images\\lilyPad.png"));
            limoLeft=ImageIO.read(new File("Images\\Limo - Left.png"));
            limoRight=ImageIO.read(new File("Images\\Limo - Right.png"));
            turtleS=ImageIO.read(new File("Images\\S-Turtle.png"));
            turtleM=ImageIO.read(new File("Images\\M-Turtle.png"));
            turtleL=ImageIO.read(new File("Images\\L-Turtle.png"));
            turtleHS=ImageIO.read(new File("Images\\HS-Turtle.png"));
            turtleHM=ImageIO.read(new File("Images\\HM-Turtle.png"));
            turtleHL=ImageIO.read(new File("Images\\HL-Turtle.png"));
            leftSemi=ImageIO.read(new File("Images\\Semi - Left.png"));
            rightSemi=ImageIO.read(new File("Images\\Semi - Right.png"));
        }
        catch(Exception e) {
            System.out.println("Image Loading Problem: ");
            e.printStackTrace();
        }
        buffer = new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_4BYTE_ABGR);
        reset();
    }
    public void reset() {
        game=new FroggerGame();
    }
    public void paint(Graphics g) {
        Graphics bg = buffer.getGraphics();
        //Base screen
        bg.setColor(Color.GREEN);
        bg.fillRect(0, 0, getWidth(), getHeight());
        bg.setColor(Color.BLUE);
        bg.fillRect(0, 80, getWidth(), 200);
        bg.fillRect(112,40,60,40);
        bg.fillRect(284,40,60,40);
        bg.fillRect(456,40,60,40);
        bg.fillRect(628,40,60,40);
        bg.setColor(Color.WHITE);
        bg.fillRect(0, 320, getWidth(), 200);
        bg.setColor(Color.GRAY);
        bg.fillRect(0, 322, getWidth(), 196);
        bg.setColor(Color.YELLOW);
        for(int x=0;x<4;x++) {
            for(int y=0;y<10;y++) {
                if(y==0) {
                    bg.fillRect((y*70)+10,(x*40)+358,60,4);
                    continue;
                }
                if(y>=2) {
                    bg.fillRect((y*(70+y))+(28-y),(x*40)+358,60,4);
                    continue;
                }
                bg.fillRect((y*(70+y))+(20-y),(x*40)+358,60,4);
            }
        }
        bg.setColor(Color.BLACK);
        bg.fillRect(0,560,getWidth(),40);
        //Lillypad Paint
        for(int x=0; x<4;x++){
            bg.drawImage(lillypad,122+(x*172),45,null);
        }
        //Lifebar Paint
        bg.setColor(Color.GRAY);
        bg.setFont(new Font("Arial",Font.BOLD,20));
        bg.drawString("Lives:",20,585);
        for(int x=1; x<=game.getLives();x++) {
            bg.drawImage(frogLife,50+(x*40),570,null);
        }
        //Print Player
        if(game.getPlayer().getDirection()==Frog.UP) {
            bg.drawImage(frogUp,(int)game.getPlayer().getX(),(int)game.getPlayer().getY(),null);
        }
        if(game.getPlayer().getDirection()==FroggerItem.LEFT) {
            bg.drawImage(frogLeft,(int)game.getPlayer().getX(),(int)game.getPlayer().getY(),null);
        }
        if(game.getPlayer().getDirection()==FroggerItem.RIGHT) {
            bg.drawImage(frogRight,(int)game.getPlayer().getX(),(int)game.getPlayer().getY(),null);
        }
        if(game.getPlayer().getDirection()==Frog.DOWN) {
            bg.drawImage(frogDown,(int)game.getPlayer().getX(),(int)game.getPlayer().getY(),null);
        }
        //Draw Cars
        for(CarLane cl: game.getCarLanes()) {
            for(FroggerItem fi: cl.getLaneItems()) {
                Car c=(Car)fi;
                if(c.getDirection()==Car.LEFT&&c.getType()==Car.SEMI) {
                    bg.drawImage(leftSemi,(int)c.getX(),(int)c.getY(),null);
                }
                if(c.getDirection()==Car.RIGHT&&c.getType()==Car.SEMI) {
                    bg.drawImage(rightSemi,(int)c.getX(),(int)c.getY(),null);
                }
                if(c.getDirection()==Car.LEFT&&c.getType()==Car.LIMO) {
                    bg.drawImage(limoLeft,(int)c.getX(),(int)c.getY(),null);
                }
                if(c.getDirection()==Car.RIGHT&&c.getType()==Car.LIMO) {
                    bg.drawImage(limoRight,(int)c.getX(),(int)c.getY(),null);
                }
                if(c.getDirection()==Car.LEFT&&c.getType()==Car.CAR_1) {
                    bg.drawImage(car1Left,(int)c.getX(),(int)c.getY(),null);
                }
                if(c.getDirection()==Car.RIGHT&&c.getType()==Car.CAR_1) {
                    bg.drawImage(car1Right,(int)c.getX(),(int)c.getY(),null);
                }
                if(c.getDirection()==Car.LEFT&&c.getType()==Car.CAR_2) {
                    bg.drawImage(car2Left,(int)c.getX(),(int)c.getY(),null);
                }
                if(c.getDirection()==Car.RIGHT&&c.getType()==Car.CAR_2) {
                    bg.drawImage(car2Right,(int)c.getX(),(int)c.getY(),null);
                }
            }
        }







        //Place frog on won spaces
        for(int x=0; x<4; x++) {
            if(game.getLillyPads()[x].isFrog()) {
                bg.drawImage(frogDown,122+(x*172),40,null);
            }
        }
        //if(game.getPlayer().)
        if(game.getStatus()==FroggerGame.PLAYER_WINS) {
            bg.setColor(Color.black);
            bg.fillRect(getWidth() / 4, getHeight() / 4, getWidth() / 2, getHeight() / 2);
            bg.setColor(Color.pink);
            bg.setFont(new Font("Arial",Font.BOLD,60));
            bg.drawString("You Win!",275,300);
        }
        if(game.getStatus()==FroggerGame.DEAD) {
            bg.setColor(Color.black);
            bg.fillRect(getWidth() / 4, getHeight() / 4, getWidth() / 2, getHeight() / 2);
            bg.setColor(Color.pink);
            bg.setFont(new Font("Arial",Font.BOLD,60));
            bg.drawString("You're Dead!",275,300);
        }
        g.drawImage(buffer,0,0,null);
    }
    public void update() {
        game.update();
    }
    public void keyPressed(KeyEvent e) {

    }
    public void keyReleased(KeyEvent e){

    }
    public void keyTyped(KeyEvent e){
        char k = e.getKeyChar();
        if(game.getStatus()==FroggerGame.PLAYING){
            if(k=='w') {
                game.getPlayer().setDirection(Frog.UP);
                if(game.getPlayer().getY()>0)
                    game.getPlayer().setY(game.getPlayer().getY()-40);
            }
            if(k=='a') {
                game.getPlayer().setDirection(FroggerItem.LEFT);
                if(game.getPlayer().getX()>0)
                    game.getPlayer().setX(game.getPlayer().getX()-40);
            }
            if(k=='s') {
                game.getPlayer().setDirection(Frog.DOWN);
                if(game.getPlayer().getY()<520)
                    game.getPlayer().setY(game.getPlayer().getY()+40);
            }
            if(k=='d') {
                game.getPlayer().setDirection(FroggerItem.RIGHT);
                if(game.getPlayer().getX()<760)
                    game.getPlayer().setX(game.getPlayer().getX()+40);
            }
        }
        if(game.getStatus()!=FroggerGame.PLAYING) {
            if(k=='n') {
                reset();
            }
        }
        game.getPlayer().updateRectangle();
        //System.out.println(game.getPlayer().getY());
        repaint();
    }
    public void addNotify() {
        super.addNotify();
        requestFocus();
        Thread t = new Thread(this);
        t.start();
    }
    public void run() {
        int waitToUpdate=(1000/updatesPerSecond);
        long startTime = System.nanoTime();

        while (true) {
            boolean shouldRepaint=false;
            long currentTime = System.nanoTime();
            long updateNeeded = (((currentTime-startTime)/1000000)/waitToUpdate);
            for(long x=updateCount; x<updateNeeded;x++) {
                update();
                shouldRepaint=true;
                updateCount++;
            }
            if(shouldRepaint) {
                repaint();
            }
            try {
                Thread.sleep(5);
            } catch(Exception e) {
                System.out.println("Error sleep run time");
            }
        }
    }

}
