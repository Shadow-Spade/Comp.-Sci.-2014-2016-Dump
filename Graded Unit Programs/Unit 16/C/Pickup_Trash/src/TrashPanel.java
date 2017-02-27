import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TrashPanel extends JPanel implements MouseListener{
    private boolean[][] trash;
    public static final int NUMCOL=20,NUMROW=20;
    public int z;
    public TrashPanel() {
        setSize(400,400);
        addMouseListener(this);
        trash=new boolean[20][20];
        for(int x=0;x<20;x++) {
            for(int y=0; y<20; y++) {
                z=(int)(Math.random()*2);
                if(z==0) {
                    trash[x][y]=true;
                }
            }
        }

    }
    public void paint(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.BLACK);
        //create grid
        for(int x=0;x<20;x++) {
            for(int y=0; y<20; y++) {
                g.drawRect(40+(x*15),40+(y*15),10,10);
            }
        }
        //Set Trash
        for(int x=0;x<20;x++) {
            for(int y=0; y<20; y++) {
                if(!trash[x][y]) {g.setColor(Color.WHITE);}
                else {g.setColor(Color.BLACK);}
                g.fillRect(38+((x)*15),38+((y)*15),10,10);
            }
        }
        //TODO Make complete Paint Code
        win:
        for(int x=0;x<20;x++) {
            for(int y=0; y<20; y++) {
                if(trash[x][y])
                    break win;
                else if(x==19&&y==19&&!trash[x][y]) {
                    g.setFont(new Font("Arial",Font.BOLD,15));
                    g.setColor(Color.PINK);
                    g.drawString("You wasted your time to pick up some trash! ",25,365);
                    g.drawString("Congratulations!",125,385);
                }
            }
        }
    }
    public void mousePressed(MouseEvent e){}
    public void mouseClicked(MouseEvent e) {
        if(e.getX()>=40&&e.getX()<=40+(15*20)&&e.getY()>=40&&e.getY()<=40+(15*20)) {
            pickUpTrash((e.getX()-40)/15,(e.getY()-40)/15);
        }
        repaint();
    }
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }
    public void pickUpTrash(int x, int y) {
        if(x<0||y<0||x>=NUMCOL||y>=NUMROW||!trash[x][y])
            return;
        trash[x][y]=false;
        pickUpTrash(x+1,y);
        pickUpTrash(x-1,y);
        pickUpTrash(x,y+1);
        pickUpTrash(x,y-1);
    }
}
