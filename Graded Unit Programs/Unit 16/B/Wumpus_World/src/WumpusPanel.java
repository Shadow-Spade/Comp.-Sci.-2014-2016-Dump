import java.awt.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;
import java.util.HashMap;

class WumpusPanel extends JPanel implements KeyListener {
	private static final int PLAYING=0, DEAD=1, WON=2;
	private HashMap<String ,BufferedImage> images = new HashMap<String, BufferedImage>();
	private int status, flavorCount;
	private WumpusPlayer player;
	private WumpusMap map;
	private boolean cheat, killWumpus=false, tog=false;
	private Clip clip;
	WumpusPanel() {
		setSize(500,600);
		addKeyListener(this);
		try {
			images.put("buffer",new BufferedImage(500,600,BufferedImage.TYPE_4BYTE_ABGR));
			images.put("floor",ImageIO.read((new File("Images\\floor.gif"))));
			images.put("arrow",ImageIO.read((new File("Images\\arrow.gif"))));
			images.put("black",ImageIO.read((new File("Images\\black.gif"))));
			images.put("breeze",ImageIO.read((new File("Images\\breeze.gif"))));
			images.put("deadWumpus",ImageIO.read((new File("Images\\deadWumpus.gif"))));
			images.put("gold",ImageIO.read((new File("Images\\gold.gif"))));
			images.put("ladder",ImageIO.read((new File("Images\\ladder.gif"))));
			images.put("pit",ImageIO.read((new File("Images\\pit.gif"))));
			images.put("playerDown",ImageIO.read((new File("Images\\playerDown.png"))));
			images.put("playerUp",ImageIO.read((new File("Images\\playerUp.png"))));
			images.put("playerLeft",ImageIO.read((new File("Images\\playerLeft.png"))));
			images.put("playerRight",ImageIO.read((new File("Images\\playerRight.png"))));
			images.put("stench",ImageIO.read((new File("Images\\stench.gif"))));
			images.put("wumpus",ImageIO.read((new File("Images\\wumpus.gif"))));
			File bgm= new File("Music\\Dogsong.wav");
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(bgm));
		}
		catch (Exception e) {
			System.out.println("Error Loading Images: ");
			e.printStackTrace();
		}
		//Audio
		reset();
	}
	private void reset() {
		status=PLAYING;
		map=new WumpusMap();
		player = new WumpusPlayer();
		cheat=false;
		flavorCount=0;
		//System.out.println(map.toString());
		player.setRowPosition(map.getLadderRow());
		player.setColPosition(map.getLadderCol());
		map.getSquare(player.getRowPosition(),player.getColPosition()).setVisited(true);
	}
	public void paint(Graphics g) {
		//creates buffer
		Graphics bg = images.get("buffer").getGraphics();
		//test for dead
		if(map.getSquare(player.getRowPosition(),player.getColPosition()).isPit()||map.getSquare(player.getRowPosition(),player.getColPosition()).isWumpus()) {
			status=DEAD;
		}
		//sets buffer
		bg.setColor(Color.BLACK);
		bg.fillRect(0,0,getWidth(),getHeight());
		for(int y=0;y<10;y++) {
			for(int x=0; x<10;x++) {
				bg.drawImage(images.get("floor"),x*50,y*50,null);
				if(map.getSquare(x,y).isBreeze()){
					bg.drawImage(images.get("breeze"),x*50,y*50,null);
				}
				if(map.getSquare(x,y).isStench()){
					bg.drawImage(images.get("stench"),x*50,y*50,null);
				}
				if(map.getSquare(x,y).isWumpus()) {
					bg.drawImage(images.get("wumpus"),x*50,y*50,null);
				}
				if(map.getSquare(x,y).isDeadWumpus()) {
					bg.drawImage(images.get("deadWumpus"),x*50,y*50,null);
				}
				if(map.getSquare(x,y).isPit()) {
					bg.drawImage(images.get("pit"),x*50,y*50,null);
				}
				if(map.getSquare(x,y).isLadder()) {
					bg.drawImage(images.get("ladder"),x*50,y*50,null);
				}
				if(map.getSquare(x,y).isGold()){
					bg.drawImage(images.get("gold"),x*50,y*50,null);
				}
				if(!map.getSquare(x,y).isVisited()&&!cheat) {
					bg.drawImage(images.get("black"), x * 50, y * 50, null);
				}
			}
		}

		//sets direction
		if(player.getDirection()==WumpusPlayer.NORTH) {
			bg.drawImage(images.get("playerUp"),player.getRowPosition()*50,player.getColPosition()*50,null);
		}
		else if(player.getDirection()==WumpusPlayer.EAST) {
			bg.drawImage(images.get("playerRight"),player.getRowPosition()*50,player.getColPosition()*50,null);
		}
		else if(player.getDirection()==WumpusPlayer.SOUTH) {
			bg.drawImage(images.get("playerDown"),player.getRowPosition()*50,player.getColPosition()*50,null);
		}
		else if(player.getDirection()==WumpusPlayer.WEST) {
			bg.drawImage(images.get("playerLeft"),player.getRowPosition()*50,player.getColPosition()*50,null);
		}
		bg.setColor(Color.PINK);
		bg.fillRect(0, 500, 500, 100);
		bg.setColor(Color.GRAY);
		bg.fillRect(5, 505, 150, 90);
		bg.fillRect(160,505,335,90);
		bg.setColor(Color.BLACK);
		bg.setFont(new Font("Arial",Font.BOLD,20));
		bg.drawString("Inventory",10,525);
		if(player.isGold()) {
			bg.drawImage(images.get("gold"),80,535,null);
		}
		if(player.isArrow()) {
			bg.drawImage(images.get("arrow"),20,535,null);
		}
		if(status==WON) {
			bg.setColor(Color.PINK);
			bg.setFont(new Font("Arial",Font.BOLD,40));
			bg.drawString("YOU WIN!",150,250);
			bg.drawString("Press 'n' to play again",50,350);
		}
		if(status==DEAD) {
			bg.setColor(Color.PINK);
			bg.setFont(new Font("Arial",Font.BOLD,40));
			bg.drawString("YOU DIED!",150,250);
			bg.drawString("Press 'n' to retry",100,350);
		}
		bg.setFont(new Font("Arial",Font.BOLD,20));
		bg.setColor(Color.black);
		if(map.getSquare(player.getRowPosition(),player.getColPosition()).isWumpus()) {
			bg.drawString("You are eaten by the Wumpus",180,20*flavorCount+535);
			flavorCount++;
		}
		if(map.getSquare(player.getRowPosition(),player.getColPosition()).isGold()) {
			bg.drawString("You see a glimmer",180,20*flavorCount+535);
			flavorCount++;
		}
		if(map.getSquare(player.getRowPosition(),player.getColPosition()).isPit()) {
			bg.drawString("You fell down a pit to your death",180,20*flavorCount+535);
			flavorCount++;
		}
		if(map.getSquare(player.getRowPosition(),player.getColPosition()).isBreeze()) {
			bg.drawString("You feel a breeze",180,20*flavorCount+535);
			flavorCount++;
		}
		if(map.getSquare(player.getRowPosition(),player.getColPosition()).isStench()||map.getSquare(player.getRowPosition(),player.getColPosition()).isDeadWumpus()) {
			bg.drawString("You smell a stench",180,20*flavorCount+535);
			flavorCount++;
		}
		if(map.getSquare(player.getRowPosition(),player.getColPosition()).isLadder()) {
			bg.drawString("You bump into a ladder",180,20*flavorCount+535);
			flavorCount++;
		}
		if(killWumpus) {
			bg.drawString("You hear a screams",180,20*flavorCount+535);
			flavorCount++;
			killWumpus=false;
		}
		flavorCount=0;
		//pastes image for no lag
		g.drawImage(images.get("buffer"),0,0,null);
	}
	//Occurs when ANY key goes down
	public void keyPressed(KeyEvent e) {}
	//Occurs when ANY key goes up
	public void keyReleased(KeyEvent e) {}
	//occurs when characters would appear on screen
	public void keyTyped(KeyEvent e) {
		char key = e.getKeyChar();
		//Move Left
		if(key=='m'){
			if(!tog){
				clip.loop(100);
				tog=true;
			}
			else{
				clip.stop();
				tog=false;
			}
		}
		if(key=='a'){
			if(status==PLAYING){
				if(player.getRowPosition()==0) {return;}
				else{player.setRowPosition(player.getRowPosition()-1);}
				player.setDirection(WumpusPlayer.WEST);
				map.getSquare(player.getRowPosition(),player.getColPosition()).setVisited(true);
			}
		}
		//Move Up
		else if(key=='w'){
			if(status==PLAYING){
				if(player.getColPosition()==0) {return;}
				else{player.setColPosition(player.getColPosition()-1);}
				player.setDirection(WumpusPlayer.NORTH);
				map.getSquare(player.getRowPosition(),player.getColPosition()).setVisited(true);
			}
		}
		// Move Right
		else if(key=='d'){
			if(status==PLAYING){
				if(player.getRowPosition()==9) {return;}
				else{player.setRowPosition(player.getRowPosition()+1);}
				player.setDirection(WumpusPlayer.EAST);
				map.getSquare(player.getRowPosition(),player.getColPosition()).setVisited(true);
			}
		}
		//Move Down
		else if(key=='s'){
			if(status==PLAYING){
				if(player.getColPosition()==9) {return;}
				else{player.setColPosition(player.getColPosition()+1);}
				player.setDirection(WumpusPlayer.SOUTH);
				map.getSquare(player.getRowPosition(),player.getColPosition()).setVisited(true);
			}
		}
		//fog be gone (cheat mode)
		else if(key=='*'&&status==PLAYING) {
			if(!cheat) {
				cheat=true;
			}
			else{
				cheat=false;
			}

		}
		//shoot right
		else if(key=='j'&&player.isArrow()&&status==PLAYING) {
			for(int r=player.getRowPosition();r>=0;r--) {
				if(map.getSquare(r,player.getColPosition()).isWumpus()) {
					map.getSquare(r,player.getColPosition()).setWumpus(false);
					map.getSquare(r,player.getColPosition()).setDeadWumpus(true);
					killWumpus=true;
				}
			}
			player.setArrow(false);
		}
		//shoot up
		else if(key=='i'&&player.isArrow()&&status==PLAYING) {
			for(int c=player.getColPosition();c>=0;c--) {
				if(map.getSquare(player.getRowPosition(),c).isWumpus()) {
					map.getSquare(player.getRowPosition(),c).setWumpus(false);
					map.getSquare(player.getRowPosition(),c).setDeadWumpus(true);
					killWumpus=true;
				}
			}
			player.setArrow(false);
		}
		//shoot left
		else if(key=='l'&&player.isArrow()&&status==PLAYING) {
			for(int r=player.getRowPosition();r<10;r++) {
				if(map.getSquare(r,player.getColPosition()).isWumpus()) {
					map.getSquare(r,player.getColPosition()).setWumpus(false);
					map.getSquare(r,player.getColPosition()).setDeadWumpus(true);
					killWumpus=true;
				}
			}
			player.setArrow(false);
		}
		//shoot down
		else if(key=='k'&&player.isArrow()&&status==PLAYING) {
			for(int c=player.getColPosition();c<10;c++) {
				if(map.getSquare(player.getRowPosition(),c).isWumpus()) {
					map.getSquare(player.getRowPosition(),c).setWumpus(false);
					map.getSquare(player.getRowPosition(),c).setDeadWumpus(true);
					killWumpus=true;
				}
			}
			player.setArrow(false);
		}
		//reset
		else if(key=='r') {
			reset();
		}
		//new game
		else if(key=='n') {
			if(status!=PLAYING) {
				reset();
			}
		}
		//pick up gold
		else if(key=='p'&&status==PLAYING) {
			if(map.getSquare(player.getRowPosition(),player.getColPosition()).isGold()) {
				map.getSquare(player.getRowPosition(),player.getColPosition()).setGold(false);
				player.setGold(true);
			}
		}
		//climb ladder
		else if(key=='c'&&status==PLAYING) {
			if(player.isGold()&&player.getColPosition()==map.getLadderCol()&&player.getRowPosition()==map.getLadderRow()) {
				status=WON;
			}
		}

		//update board
		repaint();
	}
	public void addNotify() {
		super.addNotify();
		requestFocus();
	}
}