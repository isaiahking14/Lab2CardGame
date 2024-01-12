// DeckOfCards class represents a deck of playing cards.
import java.security.SecureRandom;
import java.util.ArrayList;

public class DeckOfCards {
    // random number generator
    private static final SecureRandom randomNumbers = new SecureRandom();
    private static final int NUMBER_OF_CARDS = 52; // constant # of Cards

    private ArrayList<Card> dealtcards = new ArrayList<Card>();
    private Card[] deck = new Card[NUMBER_OF_CARDS]; // Card references
    private int currentCard = 0; // index of next Card to be dealt (0-51)

    // constructor fills deck of Cards
    public DeckOfCards() {

        String[] faces = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        int ii = 0; 
        for (String ss : suits) {
            for (String ff : faces){
                deck[ii] = new Card(ff, ss); 
                ii++; 
            }
        
       }
    }


    // shuffle deck of Cards with one-pass algorithm
    public void shuffle() {
        // next call to method dealCard should start at deck[0] again
        currentCard = 0;
        dealtcards.clear();

        // for each Card, pick another random Card (0-51) and swap them
        for (int first = 0; first < deck.length; first++) {
            // select a random number between 0 and 51
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

            // swap current Card with randomly selected Card
            Card temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp; 


        }
    }

    // deal one Card
    public Card dealCard() {
        // collect all the cards out of dealt pile
        // determine whether Cards remain to be dealt
        for (int i = 0; i < deck.length; i++) {
            // test to see if card is has already been dealt (test by seeing if card is in dealt array)
            // if not, deal card, and put into dealt array
            Card temp = deck[i];
            if (dealtcards.contains(temp)){
                continue;
            }
            dealtcards.add(temp);
            return temp;
        }
        return null;
    }


    
    
}