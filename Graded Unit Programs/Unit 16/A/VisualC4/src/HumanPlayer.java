import java.util.Scanner;

public class HumanPlayer extends CF_Player {
	public HumanPlayer(String name, int color)
	{
		super(name,color);
	}
	public int getMove(ConnectFourGame cfg) {
		Scanner keyboard = new Scanner(System.in);
		int col;
		do {
			System.out.print(getName()+" enter a column for your move (0-6): ");	
			col = keyboard.nextInt();
		}while(col<0 || col>6 || cfg.columnFull(col));
		return col;
	}
}