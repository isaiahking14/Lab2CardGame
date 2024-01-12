// Card class represents a playing card
public class Card {
    private final String face; // face of card ("Ace", "Deuce", etc)
    private final String suit; // suit of card ("Hearts", "Diamonds", etc)

    // two-argument constructor initializes card's face and suit
    public Card(String cardFace, String cardSuit) {
        this.face = cardFace; //initializes face of card
        this.suit = cardSuit; //initializes suit of card
    }
    public int GetFaceValue() {
        switch (this.face) {
            case "Two": return 2;
            case "Three": return 3;
            case "Four": return 4;
            case "Five": return 5;
            case "Six": return 6;
            case "Seven": return 7;
            case "Eight": return 8;
            case "Nine": return 9;
            case "Ten": return 10;
            case "Jack": return 11;
            case "Queen": return 12;
            case "King": return 13;
            case "Ace": return 14;
            default: return 0;
        }

    }

    public int GetSuitValue() {
        switch (this.suit){
            case "Hearts": return 1;
            case "Diamonds": return 2;
            case "Clubs": return 3;
            case "Spades": return 4;
            default: return 0;
        }
    }
    // return String representation of Card
    public String toString() {
        return face + " of " + suit;
    }
}