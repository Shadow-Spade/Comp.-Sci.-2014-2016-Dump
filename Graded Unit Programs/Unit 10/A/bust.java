import java.util.Scanner;
public class bust
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		int s1,s2,q=0,p,w,e=0;
		String m,d;
		//Input amt. of plrs.
		do
		{
			System.out.print("Enter how many players are playing (2-5): ");
			p=kb.nextInt();
			if(p<2||p>5)
			{
				System.out.print("Invalid Input\n");
				continue;
			}
			break;
		}while(true);
		//Storage for names
		String[]plrs=new String[p];
		//Storage for scores
		int[] scrs=new int[p];
		for(int x=0;x<p;x++)
		{
			System.out.print("Input a player name: ");
			m=kb.next();
			plrs[x]=m;
		}
		shuf(plrs);
		game:
		do //Game
		{
			for(int x=0;x<plrs.length;x++)
			{
				System.out.printf("\n%s has %d Points",plrs[x],scrs[x]);
			}
			System.out.printf("\nIt is %s's turn.\n",plrs[e]);
			do //Turns
			{
				System.out.println("\nWhat would you like to do?");
				System.out.println("1. Roll the Dice");
				System.out.println("2. Store Recieved Points");
				System.out.print("Enter Selection: ");
				w=kb.nextInt();
				if(w>2||w<1)
				{
					System.out.println("Invalid input");
					continue;
				}
				if(w==1)
				{
					s1=roll();
					s2=roll();
					q+=s1+s2;
					System.out.printf("You rolled a %d and a %d.",s1,s2);
					if(s1==s2)
					{
						q=0;
						System.out.println("\nYou bust");
						break;
					}
					else
					{
						System.out.printf("\nYou have %d points.",q);
						continue;
					}
				}
				if(w==2)
				{
					if(q==0)
					{
						System.out.print("You skiped your turn...");
						break;
					}
					System.out.printf("Storing %d points to your bank",q);
					scrs[e]+=q;
					d=win(plrs,scrs);
					q=0;
					if(d==null)
					{
						break;
					}
					else
					{
						System.out.printf("\nPlayer %s is the Winner.",d);
						break game;
					}
				}
			}while(true);
			e++;
			//reset to first player
			if(e==p)
			{
				e=0;
			}
		}while(true);
		
	}
	//Rolls dice//
	public static int roll()
	{
		return (int)(Math.random()*6)+1;
	}
	//Checks for winner//
	public static String win(String[]plrs, int[] scrs)
	{
		String e=null;
		for(int x=0;x<plrs.length;x++)
		{
			if(scrs[x]>=100)
			{
				e=plrs[x];
				break;
			}
		}
		return e;
	}
	//Shuffles names//
	public static void shuf(String[] plrs)
	{
		String ph1,ph2;
		int t1,t2;
		for(int x=0; x<40;x++)
		{
			t1=(int)(Math.random()*plrs.length);
			t2=(int)(Math.random()*plrs.length);
			ph1=plrs[t1];
			ph2=plrs[t2];
			plrs[t2]=ph1;
			plrs[t1]=ph2;
		}
	}
}