import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int selection,players;
        //Ask for who||what is playing
        do {
            System.out.println("How many players are there? (1-2)");
            selection=kb.nextInt();
            if (selection==1){
                players=ConnectFourPanel.ONE_PLAYER;
                break;
            }
            if (selection==2){
                players=ConnectFourPanel.TWO_PLAYER;
                break;
            }
        }while(true);
        new ConnectFourFrame(players, "Connect Four Visual Game");
    }
}
