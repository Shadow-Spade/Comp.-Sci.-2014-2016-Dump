import java.util.Scanner;
import java.awt.Color;

public class MainFile
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		DrawingWindow dw = new DrawingWindow();
		int x,x1,y,y1,x2,y2,w,h,c;
		Color color=null;
		do
		{
			System.out.println("---Menu----");
			System.out.println("1. Add Line");
			System.out.println("2. Add Rectangle");
			System.out.println("3. Add Oval");
			System.out.println("4. Clear");
			System.out.println("0. Exit");
			System.out.println("Enter selection: ");
			int selection= kb.nextInt();
			if(selection ==1)
			{
				System.out.println("Enter the x1 value of your line: ");
				x1=kb.nextInt();
				System.out.println("Enter the y1 value of your line: ");
				y1=kb.nextInt();
				System.out.println("Enter the x2 value of your line: ");
				x2=kb.nextInt();
				System.out.println("Enter the y2 value of your line: ");
				y2=kb.nextInt();
				do {
					System.out.println("Enter a color (1=Red 2=Blue 3=Green 4=Random color): ");
					c=kb.nextInt();
					if(c<1||c>4)
                    {
                        System.out.print("Invalid Input");
						continue;
                    }
					break;
				} while (true);
				switch (c)
				{
					case 1:
						color= Color.red;
						break;
					case 2:
						color= Color.blue;
						break;
					case 3:
						color= Color.green;
						break;
					case 4:
						int z= (int)(Math.random()*3)+1;
						switch (z)
						{
							case 1:
								color= Color.red;
								break;
							case 2:
								color= Color.blue;
								break;
							case 3:
								color= Color.green;
								break;
							default:
								break;
						}
						break;
					default:
						break;
				}
				DrawingLine line =new DrawingLine( x1, x2, y1, y2, color);
				dw.addShape(line);
			}
			else if(selection ==2)
			{
				System.out.println("Enter the x value of your Rectangle: ");
				x=kb.nextInt();
				System.out.println("Enter the y value of your Rectangle: ");
				y=kb.nextInt();
				System.out.println("Enter the width of your Rectangle: ");
				w=kb.nextInt();
				System.out.println("Enter the height of your Rectangle: ");
				h=kb.nextInt();
				do {
					System.out.println("Enter a color (1=Red 2=Blue 3=Green 4=Random color): ");
					c=kb.nextInt();
					if(c<1||c>4)
					{
						System.out.print("Invalid Input");
						continue;
					}
					break;
				} while (true);
				switch (c)
				{
					case 1:
						color= Color.red;
						break;
					case 2:
						color= Color.blue;
						break;
					case 3:
						color= Color.green;
						break;
					case 4:
						int z= (int)(Math.random()*3)+1;
						switch (z)
						{
							case 1:
								color= Color.red;
								break;
							case 2:
								color= Color.blue;
								break;
							case 3:
								color= Color.green;
								break;
							default:
								break;
						}
						break;
					default:
						break;
				}
				DrawingRectangle rect = new DrawingRectangle(x,y,w,h,color);
				dw.addShape(rect);
			}
			else if(selection ==3)
			{
				System.out.println("Enter the x value of your Oval: ");
				x=kb.nextInt();
				System.out.println("Enter the y value of your Oval: ");
				y=kb.nextInt();
				System.out.println("Enter the width of your Oval: ");
				w=kb.nextInt();
				System.out.println("Enter the height of your Oval: ");
				h=kb.nextInt();
				do {
					System.out.println("Enter a color (1=Red 2=Blue 3=Green 4=Random color): ");
					c=kb.nextInt();
					if(c<1||c>4)
					{
						System.out.print("Invalid Input");
						continue;
					}
					break;
				} while (true);
				switch (c)
				{
					case 1:
						color= Color.red;
						break;
					case 2:
						color= Color.blue;
						break;
					case 3:
						color= Color.green;
						break;
					case 4:
						int z= (int)(Math.random()*3)+1;
						switch (z)
						{
							case 1:
								color= Color.red;
								break;
							case 2:
								color= Color.blue;
								break;
							case 3:
								color= Color.green;
								break;
							default:
								break;
						}
						break;
					default:
						break;
				}
				DrawingOval oval = new DrawingOval(x,y,w,h,color);
				dw.addShape(oval);
			}
			else if(selection ==4)
			{
				dw.clear();
			}
			else if(selection == 0)
			{
				System.exit(0);
			}
		}while(true);
	}
}