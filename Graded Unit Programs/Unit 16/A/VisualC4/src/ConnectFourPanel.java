import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
class ConnectFourPanel extends JPanel implements MouseListener{
    static final int ONE_PLAYER=1,TWO_PLAYER=2;
    private int turn, mode;
    private ConnectFourGame game;
    ConnectFourPanel(int players) {
        setSize(700,600);
        mode=players;
        reset();
        addMouseListener(this);
    }
    private void reset() {
        this.game=new ConnectFourGame();
        turn=ConnectFourGame.RED;
        repaint();
    }
    public void paint(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.WHITE);
        for(int r=0;r<6;r++)
        {
            for(int c=0;c<7;c++)
            {
                g.fillOval(c*100+5,r*100+5,90,90);
            }
        }
        for(int r=0;r<6;r++)
        {
            for(int c=0;c<7;c++)
            {
                if(game.getSpot(c,r)==ConnectFourGame.RED)
                {
                    g.setColor(Color.RED);
                    g.fillOval(c * 100 + 5, r * 100 + 5, 90, 90);
                }
                else if(game.getSpot(c,r)==ConnectFourGame.BLACK)
                {
                    g.setColor(Color.BLACK);
                    g.fillOval(c * 100 + 5, r * 100 + 5, 90, 90);
                }
            }
        }
        if(game.status()==ConnectFourGame.RED_WINS)
        {
            g.setColor(Color.MAGENTA);
            g.setFont(new Font("Arial", Font.BOLD,100));
            g.drawString("Red Wins!",125,getHeight()/2);

        }
        else if(game.status()==ConnectFourGame.BLACK_WINS)
        {
            g.setColor(Color.MAGENTA);
            g.setFont(new Font("Arial", Font.BOLD,100));
            g.drawString("Black Wins!",125,getHeight()/2);
        }
        else if(game.status()==ConnectFourGame.DRAW)
        {
            g.setColor(Color.MAGENTA);
            g.setFont(new Font("Arial", Font.BOLD,100));
            g.drawString("Tie Game",125,getHeight()/2);
        }
    }
    public void mousePressed(MouseEvent e) {
        int x=e.getX();
        int column=0,robotCol;
        if(game.status()==ConnectFourGame.PLAYING&&e.getButton()==MouseEvent.BUTTON1) {
            if(x>=0&&x<100) {
                column=0;
            }
            else if(x>=100&&x<200) {
                column=1;
            }
            else if(x>=200&&x<300) {
                column=2;
            }
            else if(x>=300&&x<400) {
                column=3;
            }
            else if(x>=400&&x<500) {
                column=4;
            }
            else if(x>=500&&x<600) {
                column=5;
            }
            else if(x>=600&&x<700) {
                column=6;
            }
            if(game.columnFull(column)) {
                return;
            }
            game.dropPiece(column,turn);
            if(mode==ONE_PLAYER) {
                robotCol=(int)(Math.random()*7);
                game.dropPiece(robotCol,ConnectFourGame.BLACK);
            }
            else {
                if(turn==ConnectFourGame.RED) {
                    turn=ConnectFourGame.BLACK;
                }
                else if(turn==ConnectFourGame.BLACK) {
                    turn=ConnectFourGame.RED;
                }
            }
            repaint();
        }

        if (game.status()!=ConnectFourGame.PLAYING&&e.getButton()==MouseEvent.BUTTON3) {
            reset();
            repaint();
        }
    }
    // Unused
    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
