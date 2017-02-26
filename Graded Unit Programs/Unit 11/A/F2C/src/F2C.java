import java.io.File;
import java.util.Scanner;

/**
 * Created by p0712195 on 2/4/2015.
 */

public class F2C {
    public static void main(String[] args)
    {
        Scanner kb=null;
        int amnt=0,c,f;
        try
        {
            kb=new Scanner(new File("temps.txt"));
            amnt=kb.nextInt();
        }
        catch(Exception q)
        {
            q.printStackTrace();
        }
        for(int x=0;x<amnt;x++)
        {
            c=kb.nextInt()*9;
            //noinspection PointlessArithmeticExpression
            f=(c/5)+32;
            System.out.println(f);
            f=0;
        }
    }
}
