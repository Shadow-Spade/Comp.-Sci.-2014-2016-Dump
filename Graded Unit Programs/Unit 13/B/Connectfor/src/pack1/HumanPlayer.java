package pack1;

import java.util.Scanner;

public class HumanPlayer extends Player {

    Scanner kb = new Scanner(System.in);

    public HumanPlayer(String name, int color) {
        super(name, color);
    }

    @Override
    public int move(ConnectFourGame game) {
        System.out.println(name + ", enter a column number (0-6): ");
        return kb.nextInt();
    }
}
