public class ComputerPlayer extends CF_Player {
	public ComputerPlayer(String name, int color)
	{
		super(name,color);
	}
	
	public int getMove(ConnectFourGame cfg) {
		System.out.print("Thinking");
		for(int i=0; i<3;i++) {
			try {
				Thread.sleep(800);
				System.out.print(".");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		System.out.println();
		
		int col;
		do {
			col = (int)(Math.random()*7);
		}while(col <0 || col>6 || cfg.columnFull(col));
		
		return col;
	}
}