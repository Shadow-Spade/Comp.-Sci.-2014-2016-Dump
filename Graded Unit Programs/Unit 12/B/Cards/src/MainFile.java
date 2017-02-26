import java.util.ArrayList;
import java.util.Scanner;

public class MainFile {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Deck deck = new Deck();// Create a 52 card deck
        Hand hand = new Hand();// create an empty hand
        ArrayList<PlayingCard> discard = new ArrayList<PlayingCard>();// Create an ArrayList of cards named discard
        do {
            System.out.println("---Menu----");
            System.out.println("1. View Hand");
            System.out.println("2. Draw");
            System.out.println("3. Discard");
            System.out.println("4. Shuffle discarded cards into deck");
            System.out.println("0. Exit");
            System.out.println("Enter selection: ");
            int selection = keyboard.nextInt();
            //view hands
            if (selection == 1) {
                if (hand.cards.size() == 0) {
                    System.out.println("No cards in hand.");
                } else {
                    System.out.println(hand.getCards().toString());
                }
            } else if (selection == 2) {
                if (deck.cards.isEmpty()) {
                    System.out.println("There are no more cards in the deck");
                } else {
                    PlayingCard pc = deck.draw();
                    System.out.println(pc.toString());
                    hand.addCard(pc);
                }
            } else if (selection == 3) {
                if (hand.cards.isEmpty()) {
                    System.out.println("You have no cards in your hand currently.");
                } else {
                    for (int i = 0; i < hand.cards.size(); i++) {
                        System.out.println(i + ".) " + hand.cards.get(i).toString());
                    }
                    System.out.println("Pick a card to discard or not:");
                    int index = keyboard.nextInt();
                    if (index != hand.cards.size()) {
                        discard.add(hand.cards.get(index));
                        hand.cards.remove(index);
                    } else if (index > hand.cards.size()) {
                    }//does nothing
                }
            } else if (selection == 4) {
                deck.addCards(discard);
                discard.clear();
            } else if (selection == 0) {
                System.exit(0);
            }
        } while (true);
    }
}