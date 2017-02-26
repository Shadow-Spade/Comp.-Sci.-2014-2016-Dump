import java.util.Scanner;
public class TTTv2
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		int r1,c1,r2,c2;
		boolean win=false,tie=false;
		//Tic Tac Toe Board
		char[][]tttB={	{' ','|',' ','|',' '},
						{'-','-','-','-','-'},
						{' ','|',' ','|',' '},
						{'-','-','-','-','-'},
						{' ','|',' ','|',' '}};
		//Tic Tac Toe Variables
		char[][]tttV={	{' ',' ',' '},
						{' ',' ',','},
						{' ',' ',' '}};
		do
		{
			display(tttB);
			do
			{
				System.out.print("X Enter the column of your choice:");
				c1=kb.nextInt();
				if(c1<0||c1>2)
				{
					System.out.print("Enter a different column number\n");
					continue;
				}
				System.out.print("X Enter the row of your choice: ");
				r1=kb.nextInt();
				if(r1<0||r1>2)
				{
					System.out.print("Enter a different row number\n");
					continue;
				}
				//Checks if spot is valid
				if(tttV[r1][c1]=='X'||tttV[r1][c1]=='O')
				{
					System.out.print("Invalid Input. Choose another location.\n");
					continue;
				}
				tttV[r1][c1]='X';
				tttB[r1*2][c1*2]=tttV[r1][c1];
				System.out.print("\n");
				break;
			}while(true);
			display(tttB);
			if(wins(tttV,tttB,win)==true)
			{
				break;
			}
			else if(ties(tttV,tttB,tie)==true)
			{
				System.out.print("CAT game.");
				break;
			}
			do
			{
				System.out.print("O Enter the colomn of your choice:");
				c2=kb.nextInt();
				if(c2<0||c2>2)
				{
					System.out.print("Enter a different colomn number\n");
					continue;
				}
				System.out.print("O Enter the row of your choice: ");
				r2=kb.nextInt();
				if(r2<0||r2>2)
				{
					System.out.print("Enter a different row number\n");
					continue;
				}
				//Checks if spot is valid
				if(tttV[r2][c2]!=' ')
				{
					System.out.print("Invalid Input. Choose another locatin.\n");
					continue;
				}
				tttV[r2][c2]='O';
				tttB[r2*2][c2*2]=tttV[r2][c2];
				System.out.print("\n");
				break;
			}while(true);
			if(wins(tttV,tttB,win)==true)
			{
				break;
			}
			else if(ties(tttV,tttB,tie)==true)
			{
				System.out.print("\nCAT game.");
				break;
			}
		}while(true);
	}
	public static void display(char[][]tttB)
	{
			for(int r=0;r<tttB.length;r++)
			{
				for(int c=0;c<tttB.length;c++)
				{
					System.out.print(tttB[r][c]+" ");
				}
				System.out.print("\n");
			}
	}
	public static boolean wins(char[][]tttV,char[][]tttB,boolean win)
	{
		if((tttV[0][0]=='X'&&tttV[0][1]=='X'&&tttV[0][2]=='X')||(tttV[0][0]=='X'&&tttV[1][0]=='X'&&tttV[2][0]=='X')||
				(tttV[0][0]=='X'&&tttV[1][1]=='X'&&tttV[2][2]=='X')||(tttV[0][1]=='X'&&tttV[1][1]=='X'&&tttV[2][1]=='X')||
					(tttV[1][0]=='X'&&tttV[1][1]=='X'&&tttV[1][2]=='X')||(tttV[2][0]=='X'&&tttV[2][1]=='X'&&tttV[2][2]=='X')||
						(tttV[0][2]=='X'&&tttV[1][2]=='X'&&tttV[2][2]=='X')||(tttV[0][2]=='X'&&tttV[1][1]=='X'&&tttV[2][0]=='X'))
			{
				display(tttB);
				System.out.print("\nPlayer X wins.");
				win=true;
			}
			else if((tttV[0][0]=='O'&&tttV[0][1]=='O'&&tttV[0][2]=='O')||(tttV[0][0]=='O'&&tttV[1][0]=='O'&&tttV[2][0]=='O')||
				(tttV[0][0]=='O'&&tttV[1][1]=='O'&&tttV[2][2]=='O')||(tttV[0][1]=='O'&&tttV[1][1]=='O'&&tttV[2][1]=='O')||(tttV[1][0]=='O'&&
					tttV[1][1]=='O'&&tttV[1][2]=='O')||(tttV[2][0]=='O'&&tttV[2][1]=='O'&&tttV[2][2]=='O')||(tttV[0][2]=='O'&&tttV[1][2]=='O'&&tttV[2][2]=='O')||
						(tttV[0][2]=='O'&&tttV[1][1]=='O'&&tttV[2][0]=='O'))
			{
				display(tttB);
				System.out.print("\nPlayer O wins.");
				win=true;
			}
		return win;
	}
	public static boolean ties(char[][]tttV,char[][]tttB,boolean tie)
	{
		if(tttV[0][0]!=' '&&tttV[0][1]!=' '&&tttV[0][2]!=' '&&tttV[1][0]!=' '&&tttV[1][1]!=' '&&tttV[1][2]!=' '&&tttV[2][0]!=' '&&tttV[2][1]!=' '&&tttV[2][2]!=' ')
			{
				display(tttB);
				tie=true;
			}
		return tie;
	}
}