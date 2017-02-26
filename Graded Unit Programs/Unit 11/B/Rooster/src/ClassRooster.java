import java.io.File;
import java.util.Scanner;

/**
 * Created by p0712195 on 2/5/2015.
 */
//1:03 PM

public class ClassRooster {
    public static void main(String []args)
    {
        Scanner kb=null,p=null;
        String fn=null,ln=null;
        int id=0;
        try
        {
            kb = new Scanner(new File("bleh.txt")).useDelimiter("[ ]");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        while(kb.hasNextLine())
        {
            p=new Scanner(kb.nextLine());
            fn=p.next();
            ln=p.next();
            id=p.nextInt();
            System.out.printf("%d - %s %s\n",id,ln,fn);
        }
    }
}
