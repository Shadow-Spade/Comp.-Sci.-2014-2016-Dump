import javax.swing.*;
import java.awt.*;

public class TrashFrame extends JFrame{
    public TrashFrame(){
        //creates the frame with the given title
        super("Pick Up Trash");
        //makes the 'x' kill the program
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //makes window unable to be resizeable
        setResizable(false);
        //creates frame
        pack();
        //created, but invisible
        //creates the panel
        TrashPanel p = new TrashPanel();
        //gets the frames insets
        //size of title bar and frame
        Insets in = getInsets();
        //calculates size needed for frame and panel
        int frameWidth = p.getWidth() + in.left + in.right;
        int frameHeight = p.getHeight() + in.top + in.bottom;
        //sets the desired size
        setPreferredSize(new Dimension(frameWidth, frameHeight));
        //turns off layout option
        setLayout(null);
        //add panel to frame
        add(p);
        //adjust the size of frame to preferred
        pack();
        //make visible
        setVisible(true);
    }
}
