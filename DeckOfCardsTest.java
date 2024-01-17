// Card shuffling and dealing.

public class DeckOfCardsTest {
    // execute application
    public static void main(String[] args) {
        // inits deck of cards
        DeckOfCards myDeckOfCards = new DeckOfCards();


        // print all 52 Cards in the order in which they are dealt
        Card cc = myDeckOfCards.dealCard();
        int i = 0;
        while(cc != null){
            System.out.printf("%-19s", cc.toString());
            cc = myDeckOfCards.dealCard();
            i++;
            if (i % 4 == 0) { // output a newline after every fourth card
                System.out.println();
            }
        }
        myDeckOfCards.shuffle();


        // init 2 players
        PokerPlayer pokerPlayer1 = new PokerPlayer();
        PokerPlayer pokerPlayer2 = new PokerPlayer();
        // deal each player 5 cards
        for (int c = 0; c < 5; c++){
            pokerPlayer1.TakeCard(myDeckOfCards.dealCard());
            pokerPlayer2.TakeCard(myDeckOfCards.dealCard());
        }
        // prints out the matches
        System.out.println("Player 1 has " + pokerPlayer1.ShowHand());
        System.out.println("Player 2 has " + pokerPlayer2.ShowHand());
        
        // store the scores
        int score1 = pokerPlayer1.EvalHand();
        int score2 = pokerPlayer2.EvalHand();
        
        // determine winner
        if (score1 < score2){
            System.out.println("Player 2 has won!");
        }
            
        else if (score1 == score2){
            int face1 = pokerPlayer1.TotalFaceValue();
            int face2 = pokerPlayer2.TotalFaceValue();
            if (face1 < face2 ){
                System.out.println("Player 2 has won due to having higher face values!");
            }
            else if (face1 > face2){
                System.out.println("Player 1 has won due to higher face values!");

            }
            else{
                System.out.println("Tie!");
            }
            
        }
            
        else {
            System.err.println("Player 1 has won!");
        }
        
    }
} 
