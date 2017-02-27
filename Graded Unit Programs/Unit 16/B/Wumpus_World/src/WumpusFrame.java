import java.awt.*;
import javax.swing.*;

class WumpusFrame extends JFrame {
    WumpusFrame() {
    	//creates the frame with the given title
    	super("Wumpus World");
    	//makes the 'x' kill the program
    	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	//makes window unable to be resizeable
    	setResizable(false);
    	//creates frame
    	pack();
    	//created, but invisible
    	//creates the panel
    	WumpusPanel p = new WumpusPanel();
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