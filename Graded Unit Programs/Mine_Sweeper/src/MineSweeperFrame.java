import javax.swing.*;
import java.awt.*;
public class MineSweeperFrame extends JFrame{
    public MineSweeperFrame(int w, int h, int m){
        super("Mine Sweeper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        MineSweeperPanel p=new MineSweeperPanel(w,h,m);
        Insets in=getInsets();
        int frameWidth=p.getWidth()+in.left+in.right;
        int frameHeight=p.getHeight()+in.top+in.bottom;
        setPreferredSize(new Dimension(frameWidth,frameHeight));
        setLayout(null);
        add(p);
        pack();
        setVisible(true);
    }
}
