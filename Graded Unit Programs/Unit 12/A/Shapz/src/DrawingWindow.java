import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class DrawingWindow extends JFrame
{
	ArrayList<Object> shapes;
	
	public DrawingWindow()
	{
		super("Drawing Window");
		
		shapes = new ArrayList<Object>();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(500,500);
		setResizable(false);
		setVisible(true);
		repaint();
	}
	
	public void addShape(Object o)
	{
		shapes.add(o);
		repaint();
	}

	public void clear()
	{
		shapes.clear();
		repaint();
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0,0,500,500);
		
		for(Object o: shapes)
		{
			if(o instanceof DrawingLine)
			{
				DrawingLine line = (DrawingLine) o;
				g.setColor(line.getColor());
				g.drawLine(line.getX1(),line.getY1(),line.getX2(),line.getY2());
			}
			else if(o instanceof DrawingOval)
			{
				DrawingOval oval = (DrawingOval) o;
				g.setColor(oval.getColor());
				g.fillOval(oval.getX(),oval.getY(),oval.getW(),oval.getH());
			}
			else if(o instanceof DrawingRectangle)
			{
				DrawingRectangle rect = (DrawingRectangle) o;
				g.setColor(rect.getColor());
				g.fillRect(rect.getX(),rect.getY(),rect.getW(),rect.getH());
			}
		}
	}
}