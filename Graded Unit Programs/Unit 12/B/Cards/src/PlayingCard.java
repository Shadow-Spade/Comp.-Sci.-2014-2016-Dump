public class PlayingCard {
    char suit;
    String value;

    public PlayingCard(char suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    public char getSuit() {
        return suit;
    }

    public String getValue() {
        return value;
    }

    public boolean equals(Object o) {
        PlayingCard pc = (PlayingCard) o;

        if (this.getSuit() == pc.getSuit() && this.getValue().equals(pc.getValue())) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        if (suit == 'S' && value.equals("A")) {
            return "Ace of Spades";
        } else if (suit == 'S' && value.equals("2")) {
            return "2 of Spades";
        } else if (suit == 'S' && value.equals("3")) {
            return "3 of Spades";
        } else if (suit == 'S' && value.equals("4")) {
            return "4 of Spades";
        } else if (suit == 'S' && value.equals("5")) {
            return "5 of Spades";
        } else if (suit == 'S' && value.equals("6")) {
            return "6 of Spades";
        } else if (suit == 'S' && value.equals("7")) {
            return "7 of Spades";
        } else if (suit == 'S' && value.equals("8")) {
            return "8 of Spades";
        } else if (suit == 'S' && value.equals("9")) {
            return "9 of Spades";
        } else if (suit == 'S' && value.equals("10")) {
            return "10 of Spades";
        } else if (suit == 'S' && value.equals("J")) {
            return "Jack of Spades";
        } else if (suit == 'S' && value.equals("Q")) {
            return "Queen of Spades";
        } else if (suit == 'S' && value.equals("K")) {
            return "King of Spades";
        } else if (suit == 'H' && value.equals("A")) {
            return "Ace of Hearts";
        } else if (suit == 'H' && value.equals("2")) {
            return "2 of Hearts";
        } else if (suit == 'H' && value.equals("3")) {
            return "3 of Hearts";
        } else if (suit == 'H' && value.equals("4")) {
            return "4 of Hearts";
        } else if (suit == 'H' && value.equals("5")) {
            return "5 of Hearts";
        } else if (suit == 'H' && value.equals("6")) {
            return "6 of Hearts";
        } else if (suit == 'H' && value.equals("7")) {
            return "7 of Hearts";
        } else if (suit == 'H' && value.equals("8")) {
            return "8 of Hearts";
        } else if (suit == 'H' && value.equals("9")) {
            return "9 of Hearts";
        } else if (suit == 'H' && value.equals("10")) {
            return "10 of Hearts";
        } else if (suit == 'H' && value.equals("J")) {
            return "Jack of Hearts";
        } else if (suit == 'H' && value.equals("Q")) {
            return "Queen of Hearts";
        } else if (suit == 'H' && value.equals("K")) {
            return "King of Hearts";
        } else if (suit == 'C' && value.equals("A")) {
            return "Ace of Clubs";
        } else if (suit == 'C' && value.equals("2")) {
            return "2 of Clubs";
        } else if (suit == 'C' && value.equals("3")) {
            return "3 of Clubs";
        } else if (suit == 'C' && value.equals("4")) {
            return "4 of Clubs";
        } else if (suit == 'C' && value.equals("5")) {
            return "5 of Clubs";
        } else if (suit == 'C' && value.equals("6")) {
            return "6 of Clubs";
        } else if (suit == 'C' && value.equals("7")) {
            return "7 of Clubs";
        } else if (suit == 'C' && value.equals("8")) {
            return "8 of Clubs";
        } else if (suit == 'C' && value.equals("9")) {
            return "9 of Clubs";
        } else if (suit == 'C' && value.equals("10")) {
            return "10 of Clubs";
        } else if (suit == 'C' && value.equals("J")) {
            return "Jack of Clubs";
        } else if (suit == 'C' && value.equals("Q")) {
            return "Queen of Clubs";
        } else if (suit == 'C' && value.equals("K")) {
            return "King of Clubs";
        } else if (suit == 'D' && value.equals("A")) {
            return "Ace of Diamonds";
        } else if (suit == 'D' && value.equals("2")) {
            return "2 of Diamonds";
        } else if (suit == 'D' && value.equals("3")) {
            return "3 of Diamonds";
        } else if (suit == 'D' && value.equals("4")) {
            return "4 of Diamonds";
        } else if (suit == 'D' && value.equals("5")) {
            return "5 of Diamonds";
        } else if (suit == 'D' && value.equals("6")) {
            return "6 of Diamonds";
        } else if (suit == 'D' && value.equals("7")) {
            return "7 of Diamonds";
        } else if (suit == 'D' && value.equals("8")) {
            return "8 of Diamonds";
        } else if (suit == 'D' && value.equals("9")) {
            return "9 of Diamonds";
        } else if (suit == 'D' && value.equals("10")) {
            return "10 of Diamonds";
        } else if (suit == 'D' && value.equals("J")) {
            return "Jack of Diamonds";
        } else if (suit == 'D' && value.equals("Q")) {
            return "Queen of Diamonds";
        } else if (suit == 'D' && value.equals("K")) {
            return "King of Diamonds";
        } else {
            return "";
        }
    }
}