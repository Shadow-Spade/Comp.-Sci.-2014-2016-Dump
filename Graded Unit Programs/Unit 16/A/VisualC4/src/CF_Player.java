abstract class CF_Player {
	private String name;
	private int color;
	CF_Player(String name, int color) {
		this.name 	= name;
		this.color 	= color;
	}
	String getName()
	{
		return name;
	}
	public int getColor()
	{
		return color;
	}
	public abstract int getMove(ConnectFourGame cfg);
}