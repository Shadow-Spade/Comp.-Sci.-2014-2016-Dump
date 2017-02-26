package pack1;
import java.util.Scanner;
public class Main {
    public static void main(String []args) {
        Scanner kb = new Scanner(System.in);
        int col;
        ConnectFourGame c4 = new ConnectFourGame();
        do
        {
            c4.draw();
            do
            {
                System.out.println("Red, enter a column number (0-6): ");
                col = kb.nextInt();
                if(col>6||col<0||c4.columnFull(col))
                {
                    System.out.println("Invalid Input");
                    continue;
                }
                c4.dropPiece(col,ConnectFourGame.RED);
                break;
            }while(true);
            if(c4.status()==ConnectFourGame.RED_WINS)
            {
                c4.draw();
                System.out.println("Red Wins!");
                System.exit(0);
            }
            else if(c4.status()==ConnectFourGame.DRAW)
            {
                c4.draw();
                System.out.print("Tie Game!");
                System.exit(0);
            }
            c4.draw();
            do
            {
                System.out.println("Black, enter a column number (0-6): ");
                col = kb.nextInt();
                if(col>6||col<0||c4.columnFull(col))
                {
                    System.out.println("Invalid Input");
                    continue;
                }
                c4.dropPiece(col,ConnectFourGame.BLACK);
                break;
            }while(true);
            if(c4.status()==ConnectFourGame.BLACK_WINS)
            {
                c4.draw();
                System.out.print("Black Wins!");
                System.exit(0);
            }
            else if(c4.status()==ConnectFourGame.DRAW)
            {
                c4.draw();
                System.out.print("Tie Game!");
                System.exit(0);
            }
        }while(true);
    }
}
