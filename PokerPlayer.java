import java.util.Arrays;

public class PokerPlayer{

    private Card[] pokerHand = new Card[5]; 
    
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