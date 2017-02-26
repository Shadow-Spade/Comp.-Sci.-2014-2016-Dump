import java.util.Scanner;
public class Recurs
{
	public static void main(String[] args)
	{
		Scanner kb= new Scanner(System.in);
		int u1=0,u2=1,u3,w1,w2,x1,y1,y2,z1,z2=1,c;
		String q="";
		menu:
		do
		{
			System.out.print("\nMenu\n1. Summation\n2. Factorial\n3. Power\n4. Factors\n5. Fibonacci\n0. Exit\nEnter Selection: ");
			c=kb.nextInt();
			if(c>5||c<0)
			{
				System.out.print("Invalid Input.\n");
				continue;
			}
			switch(c)
			{
				case 1:
					System.out.print("Enter starting value(1 or more): ");
					y1=kb.nextInt();
					if(y1<1)
					{
						System.out.print("\nInvalid Input.\n");
						continue;
					}
					do
					{
						System.out.print("Enter an ending value: ");
						y2=kb.nextInt();
						if(y2<=y1)
						{
							System.out.print("\nThis value must be larger than inital value.\n");
							continue;
						}
						break;
					}while(true);
					System.out.printf("The summation from %d to %d is %d",y1,y2,sum(y1,y2));
					break;
				case 2:
					System.out.print("Enter number you wan a factorial of: ");
					x1=kb.nextInt();
					if(x1<1)
					{
						System.out.print("\nInvalid Input.\n");
						continue;
					}
					System.out.printf("The factorial of %d is %d",x1,fac(x1));
					break;
				case 3:
					System.out.print("\nEnter base number: ");
					w1=kb.nextInt();
					System.out.print("\nRased to what power: ");
					w2=kb.nextInt();
					System.out.printf("%d^%d=%d",w1,w2,pow(w1,w2));
					break;
				case 4:
					do
					{	
						System.out.print("What number would you like to find the factors for: ");
						z1=kb.nextInt();
						if(z1<1)
						{
							System.out.print("\nInvalid Input\n");
							continue;
						}
						break;
					}while(true);
					System.out.printf("The factors for %d are %s",z1,fact(z1,z2,q));
					break;
				case 5:
					System.out.print("Enter a number to test(0 or more): ");
					u3=kb.nextInt();
					if(fib(u1,u2,u3)==true)
					{
						System.out.printf("%d is a fibonacci number.",u3);
					}
					else if(fib(u1,u2,u3)==false)
					{
						System.out.printf("%d is not a fibonacci number.",u3);
					}	
					break;
				case 0:
					System.out.print("Goodbye");
					break menu;
			}
		}while(true);
	}
	public static int sum(int y1,int y2)
	{
		if (y1==y2)
		{
			return y2;
		}
		else
		{
			return y1+=sum(y1+1,y2);
		}
	}
	public static int fac(int x1)
	{
		if (1==x1)
		{
			return x1;
		}
		else
		{
			return x1*=fac(x1-1);
		}
	}
	public static int pow(int w1,int w2)
	{
		if (1==w2)
		{
			return w1;
		}
		else
		{
			return w1*=pow(w1,w2-1);
		}
	}
	public static String fact(int z1,int z2,String q)
	{
		if(z1%z2==0)
		{
			q+=z2+", ";
		}
		if(z1==z2)
		{
			return q;
		}
		return fact(z1,z2+1,q);
	}
	public static boolean fib(int u1, int u2, int u3)
	{
		boolean fi=false;
		do
		{
			u1+=u2;
			u2+=u1;
			if(u3==u1||u3==u2)
			{
				fi=true;
				break;
			}
			else if(u1>u3||u2>u3)
			{
				break;
			}
		}while(true);
		return fi;
	}
}