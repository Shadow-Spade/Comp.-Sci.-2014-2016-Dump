import java.util.Scanner;
import java.util.ArrayList;
public class VarMethod
{
	public static void main(String[] args)
	{
		int a,q,w,e,r,t;
		char ch1,ch2;
		Scanner kb = new Scanner(System.in);
		do
		{
			System.out.println("\nMenu");
			System.out.println("1. Letter range");
			System.out.println("2. Number range");
			System.out.println("3. Time to minutes");
			System.out.println("4. Number to Text");
			System.out.println("5. Maker's Favorites");
			System.out.println("0. Exit");
			System.out.print("Enter selection: ");
			a=kb.nextInt();
			switch(a)
			{
				case 1:
					do
					{
						System.out.print("Enter starting character for range: ");
						ch1=kb.next().charAt(0);
						System.out.print("Enter ending character for range: ");
						ch2=kb.next().charAt(0);
						if(ch1>ch2)
						{
							System.out.print("You cant start with a value less than the starting value");
							continue;
						}
						else if(ch1<ch2)
						{
							System.out.print(letterrange(ch1,ch2));
							break;
						}
					}while(true);
					break;
				case 2:
					System.out.print("Enter starting number: ");
					e=kb.nextInt();
					System.out.print("Enter ending number:");
					r=kb.nextInt();
					System.out.printf("The range of the numbers from %d to %d is: %s",e,r,numberrange(e,r));
					break;
				case 3:
					do
					{
						System.out.print("How many hours in your time: ");
						q=kb.nextInt();
						System.out.print("How many minutes in your time: ");
						w=kb.nextInt();
						if(q<0||w<0)
						{
							System.out.println("\nOne of the times is negative.\nYou cannot have negative numbers.\nTry again\n");
							continue;
						}
						break;
					}while(true);
					System.out.printf("The number of minutes in %d hours and %d minutes is %d minutes.",q,w,time2min(q,w));
					break;
				case 4:
					do	
					{
						System.out.print("Please enter single diget number: ");
						t=kb.nextInt();
						if(t>9||t<-9)
						{
							System.out.print("\nNumber is not a single diget.\nTry again.\n");
							continue;
						}
						break;
					}while(true);
					System.out.printf("%d as text is %s.",t,num2txt(t));
					break;
				case 5:
					myfavs();
					break;
				case 0:
					System.out.print("Good Bye.\n");
					System.exit(0);
				default:
					System.out.print("Invalid Input. Try again./n");
					break;
			}		
		}while(true);
	}
	public static String letterrange(char b,char e)
	{
		String s="";
		for(;b<=e; b++)
		{
			s+=b+", ";
		}
		return s;
	}
	public static String numberrange(int x,int y)
	{
		String f="";
		for(;x<=y;x++)
		{
			f+=x;
			if(x==y)
			{
				break;
			}
			f+=",";
		}
		return f;
	}
	public static int time2min(int th, int tm)
	{
		th*=60;
		return th+tm;
	}
	public static String num2txt(int z)
	{
		String nt="";
		if(z<0)
		{
			nt+="Negative ";
		}
		switch(z)
		{
			case 0:
				nt+="Zero";
				break;
			case 1:
				nt+="One";
				break;
			case -1:
				nt+="One";
				break;
			case 2:
				nt+="Two";
				break;
			case -2:
				nt+="Two";
				break;
			case 3:
				nt+="Three";
				break;
			case -3:
				nt+="Three";
				break;
			case 4:
				nt+="Four";
				break;
			case -4:
				nt+="Four";
				break;
			case 5:
				nt+="Five";
				break;
			case -5:
				nt+="Five";
				break;
			case 6:
				nt+="Six";
				break;
			case -6:
				nt+="Six";
				break;
			case 7:
				nt+="Seven";
				break;
			case -7:
				nt+="Seven";
				break;
			case 8:
				nt+="Eight";
				break;
			case -8:
				nt+="Eight";
				break;
			case 9:
				nt+="Nine";
				break;
			case -9:
				nt+="Nine";
				break;
		}
		return nt;
	}
	public static void myfavs()
	{
		System.out.println("\nMy favorite food is Pizza");
		System.out.println("My favorite game is TF2");
		System.out.println("My favorite movie is Big Hero 6");
		System.out.println("My favorite song is TheFatRat - Windfall");
		System.out.println("My favorite sport is Gaming");
	}
}