import javax.swing.*;
import java.awt.*;
public class FroggerFrame extends JFrame{
    public FroggerFrame() {
        super("Frogger");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        FroggerPanel p = new FroggerPanel();
        Insets in= getInsets();
        int frameWidth=p.getWidth()+in.left+in.right;
        int frameHeight=p.getHeight()+in.top+in.bottom;
        setPreferredSize(new Dimension(frameWidth,frameHeight));
        setLayout(null);
        add(p);
        pack();
        setVisible(true);
    }
}
