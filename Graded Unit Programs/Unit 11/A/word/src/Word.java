/**
 * Created by Shadow Spade on 1/30/2015.
 */
import java.io.File;
import java.util.Scanner;
public class Word {
    public static void main(String[] args)
    {
        Scanner kb=null;
        try
        {
          kb=new Scanner(new File("tha_word.txt")).useDelimiter("[*%@ ]");

        }catch(Exception p)
        {
        p.getStackTrace();
        }
        while(kb.hasNextLine())
        {
            System.out.println(kb.next());
        }
    }
}
