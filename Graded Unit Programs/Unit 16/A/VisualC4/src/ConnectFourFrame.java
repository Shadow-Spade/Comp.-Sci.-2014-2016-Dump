import javax.swing.*;
import java.awt.*;
class ConnectFourFrame extends JFrame {
    ConnectFourFrame(int players, String frameName) {
        super(frameName);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        ConnectFourPanel p = new ConnectFourPanel(players);
        Insets frameInsets = getInsets();
        int frameWidth = p.getWidth()
                + (frameInsets.left + frameInsets.right);
        int frameHeight = p.getHeight()
                + (frameInsets.top + frameInsets.bottom);
        setPreferredSize(new Dimension(frameWidth, frameHeight));
        setLayout(null);
        add(p);
        pack();
        setVisible(true);
    }
}
