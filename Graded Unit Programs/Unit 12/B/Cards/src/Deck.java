import java.util.ArrayList;

public class Deck {
    ArrayList<PlayingCard> cards = new ArrayList<PlayingCard>();

    public Deck() {
        cards.add(new PlayingCard('S', "A"));
        cards.add(new PlayingCard('S', "2"));
        cards.add(new PlayingCard('S', "3"));
        cards.add(new PlayingCard('S', "4"));
        cards.add(new PlayingCard('S', "5"));
        cards.add(new PlayingCard('S', "6"));
        cards.add(new PlayingCard('S', "7"));
        cards.add(new PlayingCard('S', "8"));
        cards.add(new PlayingCard('S', "9"));
        cards.add(new PlayingCard('S', "10"));
        cards.add(new PlayingCard('S', "J"));
        cards.add(new PlayingCard('S', "Q"));
        cards.add(new PlayingCard('S', "K"));
        cards.add(new PlayingCard('C', "A"));
        cards.add(new PlayingCard('C', "2"));
        cards.add(new PlayingCard('C', "3"));
        cards.add(new PlayingCard('C', "4"));
        cards.add(new PlayingCard('C', "5"));
        cards.add(new PlayingCard('C', "6"));
        cards.add(new PlayingCard('C', "7"));
        cards.add(new PlayingCard('C', "8"));
        cards.add(new PlayingCard('C', "9"));
        cards.add(new PlayingCard('C', "10"));
        cards.add(new PlayingCard('C', "J"));
        cards.add(new PlayingCard('C', "Q"));
        cards.add(new PlayingCard('C', "K"));
        cards.add(new PlayingCard('H', "A"));
        cards.add(new PlayingCard('H', "2"));
        cards.add(new PlayingCard('H', "3"));
        cards.add(new PlayingCard('H', "4"));
        cards.add(new PlayingCard('H', "5"));
        cards.add(new PlayingCard('H', "6"));
        cards.add(new PlayingCard('H', "7"));
        cards.add(new PlayingCard('H', "8"));
        cards.add(new PlayingCard('H', "9"));
        cards.add(new PlayingCard('H', "10"));
        cards.add(new PlayingCard('H', "J"));
        cards.add(new PlayingCard('H', "Q"));
        cards.add(new PlayingCard('H', "K"));
        cards.add(new PlayingCard('D', "A"));
        cards.add(new PlayingCard('D', "2"));
        cards.add(new PlayingCard('D', "3"));
        cards.add(new PlayingCard('D', "4"));
        cards.add(new PlayingCard('D', "5"));
        cards.add(new PlayingCard('D', "6"));
        cards.add(new PlayingCard('D', "7"));
        cards.add(new PlayingCard('D', "8"));
        cards.add(new PlayingCard('D', "9"));
        cards.add(new PlayingCard('D', "10"));
        cards.add(new PlayingCard('D', "J"));
        cards.add(new PlayingCard('D', "Q"));
        cards.add(new PlayingCard('D', "K"));
    }

    public boolean isEmpty() {
        return cards.size() == 0;
    }

    public PlayingCard draw() {
        int x = (int) (Math.random() * cards.size());
        if (cards.isEmpty()) {
            return null;
        } else {
            return cards.remove(x);
        }
    }

    public void addCard(PlayingCard card) {
        cards.add(card);
    }

    public void addCards(ArrayList<PlayingCard> togetherness) {
        for (int x = 0; x < togetherness.size(); x++) {
            cards.add(togetherness.get(x));
        }
    }
}