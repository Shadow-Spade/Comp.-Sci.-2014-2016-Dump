import java.io.File;
import java.util.Scanner;

/**
 * Created by p0712195 on 2/17/2015.
 */
//12:51 PM

public class Ascii
{
    public static void main(String[] args)
    {
        Scanner kb=null;
        String q;
        int souptot;
        try
        {
            kb=new Scanner(new File("words.txt"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        while(kb.hasNextLine())
        {
            q=kb.nextLine();
            System.out.println(aT(q));
        }
    }
    public static int aT(String q)
    {
        int tot=0;
        char[] temp=q.toCharArray();
        for(int x=0;x<temp.length;x++)
        {
            tot+=temp[x];
        }
        return tot;
    }
}
