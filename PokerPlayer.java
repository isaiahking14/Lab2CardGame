import java.util.Arrays;

public class PokerPlayer{
    // inits pokerHand array
    private Card[] pokerHand = new Card[5]; 
    // fills array
    public boolean TakeCard(Card card){
        for (int i = 0; i < pokerHand.length; i++){
            Card temp = pokerHand[i];
            if (temp == null) {
                pokerHand[i] = card;
                return true;
            }
        }
        return false;

    }
    // counts the amount of !'s in the returned string to score as a point system
    public int EvalHand(){
        String temp = ShowHand();
        int count = 0;
 
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == '!') {
                count++;
            }
        }
        return count;
    }
    
    // returns the following strings if the statements are true
    public String ShowHand(){
        // order of eval in most important
        if (hasAFullHouse() == true){
            return "Full house!!!!!!!";
        }
        else if (hasStraight() == true){
            return "Straight!!!!!!";
        }
        else if (hasAFlush() == true){
            return "Flush!!!!!";
        }
        else if (hasFourOfAKind() == true){
            return "Four of a kind!!!!";
        }
        else if (hasThreeOfAKind() == true){
            return "Three of a kind!!!";
        }
        else if (hasTwoPairs() == true){
            return "Two pairs!!";
        }
        else if (hasPair() == true){
            return "A pair!";
        }
        else{
            return "no matches";
        }

    }
     // method to get the total face value in case of a tie 
     public int TotalFaceValue() {
        int totalFaceValue = 0;
    
        for (Card card : pokerHand) {
            if (card != null) {
                totalFaceValue += card.GetFaceValue();
            }
        }
    
        return totalFaceValue;
    }
    
    // bools return true if the following statements are true
    // converts pokerHand array into a stream, gives the items a face value, then looks for matches
    private boolean hasPair(){
        Integer[] faceValue = Arrays.stream(pokerHand).map(card -> card.GetFaceValue()).toArray(Integer[]::new);
        return Arrays.stream(faceValue).anyMatch(count -> count == 2);
    }


    private boolean hasTwoPairs(){
        Integer[] faceValue = Arrays.stream(pokerHand).map(card -> card.GetFaceValue()).toArray(Integer[]::new);
        return Arrays.stream(faceValue).filter(count -> count == 2).count() == 2;
    }


    private boolean hasThreeOfAKind(){
        Integer[] faceValue = Arrays.stream(pokerHand).map(card -> card.GetFaceValue()).toArray(Integer[]::new);
        return Arrays.stream(faceValue).anyMatch(count -> count == 3);
    }


    private boolean hasFourOfAKind(){
        Integer[] faceValue = Arrays.stream(pokerHand).map(card -> card.GetFaceValue()).toArray(Integer[]::new);
        return Arrays.stream(faceValue).anyMatch(count -> count == 4);
    }


    private boolean hasAFlush(){
        Integer[] suitValue = Arrays.stream(pokerHand).map(card -> card.GetSuitValue()).toArray(Integer[]::new);
        return Arrays.stream(suitValue).anyMatch(count -> count == 5);
    }


    private boolean hasStraight(){
        Integer[] faceValue = Arrays.stream(pokerHand).map(card -> card.GetFaceValue()).toArray(Integer[]::new);
        Arrays.sort(faceValue);
        for (int i = 0; i < faceValue.length - 2; i++) {
            if (faceValue[i + 1] - faceValue[i] != 1) {
                return false;
            }
        }
        return true;
    }


    private boolean hasAFullHouse(){
        return hasThreeOfAKind() && hasPair();
    }

}
