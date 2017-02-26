package pack1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int col, z = 1, selection;
        String name;
        ConnectFourGame c4 = new ConnectFourGame();
        ComputerPlayer cp1 = null, cp2 = null;
        HumanPlayer hp1 = null, hp2 = null;
        //Ask for who||what is playing
        while (z < 3) {
            if (z == 1) {
                System.out.print("What kind of player is Red?\n1. Human\n2. Computer\nEnter Selection: ");
                selection = kb.nextInt();
                if (selection > 2 || selection < 1) {
                    System.out.println("Invalid Input.");
                    continue;
                }
                if (selection == 1) {
                    System.out.print("Enter a name: ");
                    name = kb.next();

                    hp1 = new HumanPlayer(name, ConnectFourGame.RED);
                } else if (selection == 2) {
                    cp1 = new ComputerPlayer("Computer 1", ConnectFourGame.RED);
                }
            }
            if (z == 2) {
                System.out.print("What kind of player is Black?\n1. Human\n2. Computer\nEnter Selection: ");
                selection = kb.nextInt();
                if (selection > 2 || selection < 1) {
                    System.out.println("Invalid Input.");
                    continue;
                }
                if (selection == 1) {
                    System.out.print("Enter a name: ");
                    name = kb.next();
                    hp2 = new HumanPlayer(name, ConnectFourGame.BLACK);
                } else if (selection == 2) {
                    cp2 = new ComputerPlayer("Computer 2", ConnectFourGame.BLACK);
                }
            }
            z++;
        }
        do {
            c4.draw();
            do {
                if (hp1 == null) {
                    z = cp1.move(c4);
                    if (c4.columnFull(z)) {
                        continue;
                    }
                    c4.dropPiece(cp1.move(c4), ConnectFourGame.RED);
                    break;
                }
                z = hp1.move(c4);
                if (z > 6 || z < 0 || c4.columnFull(z)) {
                    System.out.println("Invalid Input");
                    continue;
                }
                c4.dropPiece(z, ConnectFourGame.RED);
                break;
            } while (true);
            if (c4.status() == ConnectFourGame.RED_WINS) {
                c4.draw();
                System.out.println("Red Wins!");
                System.exit(0);
            } else if (c4.status() == ConnectFourGame.DRAW) {
                c4.draw();
                System.out.print("Tie Game!");
                System.exit(0);
            }
            c4.draw();
            do {
                if (hp2 == null) {
                    z = cp2.move(c4);
                    if (c4.columnFull(z)) {
                        continue;
                    }
                    c4.dropPiece(cp2.move(c4), ConnectFourGame.BLACK);
                    break;
                }
                z = hp2.move(c4);
                if (z > 6 || z < 0 || c4.columnFull(z)) {
                    System.out.println("Invalid Input");
                    continue;
                }
                c4.dropPiece(z, ConnectFourGame.BLACK);
                break;
            } while (true);
            if (c4.status() == ConnectFourGame.BLACK_WINS) {
                c4.draw();
                System.out.print("Black Wins!");
                System.exit(0);

            } else if (c4.status() == ConnectFourGame.DRAW) {
                c4.draw();
                System.out.print("Tie Game!");
                System.exit(0);
            }
        } while (true);
    }
}
