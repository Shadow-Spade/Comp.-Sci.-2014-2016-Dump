import java.io.File;
import java.util.Scanner;

public class TTTG
{
    public static void main(String[] args) {
        Scanner kb = null;
        String q = null;
        int z = 0, s = 0;
        char[][] board = new char[3][3];
        try {
            kb = new Scanner(new File("TTTs.txt")).useDelimiter("[\n]");
        } catch (Exception p) {
            p.printStackTrace();
        }
        do {
            while (kb.hasNextLine()) {
               poop:
                for (int y = 0; y < 3; y++) {
                    q = kb.nextLine();
                    //System.out.println(q);
                    for (int x = 0; x < 3; x++) {
                       if(q.equals(""))
                       {
                           break poop;
                       }
                        board[y][x] = q.charAt(x);
                    }
                }
                z++;
                if (z ==2) {
                    z = 0;
                    break;
                }
            }
            System.out.println(gs(board));
            s++;
            if (s == 5) {
                break;
            }
        } while (true);

    }
    public static String gs(char[][] board)
    {
        String x=null;
        if((board[0][0]=='X'&&board[0][1]=='X'&&board[0][2]=='X')||(board[0][0]=='X'&&board[1][0]=='X'&&board[2][0]=='X')||
                (board[0][0]=='X'&&board[1][1]=='X'&&board[2][2]=='X')||(board[0][1]=='X'&&board[1][1]=='X'&&board[2][1]=='X')||
                (board[1][0]=='X'&&board[1][1]=='X'&&board[1][2]=='X')||(board[2][0]=='X'&&board[2][1]=='X'&&board[2][2]=='X')||
                (board[0][2]=='X'&&board[1][2]=='X'&&board[2][2]=='X')||(board[0][2]=='X'&&board[1][1]=='X'&&board[2][0]=='X'))
        {
            x="X Wins";
        }
        else if((board[0][0]=='O'&&board[0][1]=='O'&&board[0][2]=='O')||(board[0][0]=='O'&&board[1][0]=='O'&&board[2][0]=='O')||
                (board[0][0]=='O'&&board[1][1]=='O'&&board[2][2]=='O')||(board[0][1]=='O'&&board[1][1]=='O'&&board[2][1]=='O')||(board[1][0]=='O'&&
                board[1][1]=='O'&&board[1][2]=='O')||(board[2][0]=='O'&&board[2][1]=='O'&&board[2][2]=='O')||(board[0][2]=='O'&&board[1][2]=='O'&&board[2][2]=='O')||
                (board[0][2]=='O'&&board[1][1]=='O'&&board[2][0]=='O'))
        {
            x="O Wins";
        }
        else if(board[0][0]!='-'&&board[0][1]!='-'&&board[0][2]!='-'&&board[1][0]!='-'&&board[1][1]!='-'&&board[1][2]!='-'&&board[2][0]!='-'&&board[2][1]!='-'&&board[2][2]!='-')
        {
            x="Cat Game";
        }
        else
        {
            x="Playing";
        }
        return x;
    }
}
