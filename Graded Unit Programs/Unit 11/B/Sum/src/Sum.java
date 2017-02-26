import java.io.File;
import java.util.Scanner;

public class Sum {
    public static void main(String[] args)
    {
        Scanner kb=null,kbb=null;
        double x,sum=0;
        try
        {
            kb=new Scanner(new File("num.txt"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        //Sum
        while (kb.hasNextLine())
        {
            kbb=new Scanner(kb.nextLine()).useDelimiter("[,]");
            while(kbb.hasNextDouble())
            {
                x=kbb.nextDouble();
                sum+=x;
            }
            System.out.println(sum);
            sum=0;
        }
    }
}
