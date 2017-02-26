import java.util.ArrayList;

public class Hand {
    ArrayList<PlayingCard> cards;

    public Hand() {
        cards = new ArrayList<PlayingCard>();
    }

    public ArrayList getCards() {
        return cards;
    }

    public void addCard(PlayingCard card) {
        cards.add(card);
    }

    public boolean removeCard(PlayingCard card) {
        return cards.remove(card);
    }
}