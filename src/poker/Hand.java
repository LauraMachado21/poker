package poker;

import java.util.ArrayList;
import java.util.Collections;

import poker.Card.Suit;

public class Hand {
	
	public enum Kind {HIGH_CARD, PAIR, TWO_PAIR, THREE_OF_A_KIND, STRAIGHT, 
        FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH}
	
	private ArrayList<Card> hand;
	
	public Hand(String cards){
		hand = new ArrayList<Card>();
		
		String[] handString;
		handString = cards.split(" ");
		
		for(String card: handString){
			hand.add(new Card(card.substring(0,1), card.substring(1,2)));
		}
		
	}
	
	public void orderHand(){
		Collections.sort(hand, new CardSuitComparator());
		Collections.sort(hand, new CardValueComparator());
	}
	
	public void printHand(){
		for(int i=0; i<hand.size();i++){
			System.out.println("Card #" + i);
			System.out.println("Rank: " + hand.get(i).getRank());
			System.out.println("Suit: " + hand.get(i).getSuit().name());
			System.out.println();
		}
	}
	
	/**
     * @returns true if the hand has n cards of the same rank
	 * e.g., "TD TC TH 7C 7D" returns True for n=2 and n=3, and False for n=1 and n=4
     */
    protected boolean hasNKind(int n) {
    	return false;
    }
    
    /**
	 * Optional: you may skip this one. If so, just make it return False
     * @returns true if the hand has two pairs
     */
    public boolean isTwoPair() {
    	return false;
    }   
    
    /**
     * @returns true if the hand is a straight 
     */
    public boolean isStraight() {
    	
    	Card lastCard = hand.get(hand.size()-1);
    	Card firstCard = hand.get(0);
    	ArrayList<Card> tempHand = new ArrayList<Card>();
    	
        if(lastCard.getRank()==CardRank.A.getCardRank() && firstCard.getRank()==2){
        	Card tempCard = new Card("1", lastCard.getSuit().name());
        	tempHand.add(tempCard);
        	tempHand.addAll(hand);
        	tempHand.remove(tempHand.size()-1);
        }else{
        	tempHand = hand;
        }
        
        int prevRank = tempHand.get(0).getRank();
        for(int i=1;i<tempHand.size();i++){
        	if((tempHand.get(i).getRank()-1)!=prevRank) return false;
        }
        
        return true;
    }
    
    /**
     * @returns true if the hand is a flush
     */
    public boolean isFlush() {
		int numberDiffSuit = 0;
		
		Suit prevSuit = null;
		int prevRank = 0;
		
		for(Card c: hand){
			if(c.getSuit()!=prevSuit) numberDiffSuit++;
		
			prevSuit = c.getSuit();
		}
		
		//All cards of the same suit.
		if(numberDiffSuit == 1) return true;
		else return false;
    }
    
    public Kind kind() {
        if (isStraight() && isFlush()) return Kind.STRAIGHT_FLUSH;
        else if (hasNKind(4)) return Kind.FOUR_OF_A_KIND; 
        else if (hasNKind(3) && hasNKind(2)) return Kind.FULL_HOUSE;
        else if (isFlush()) return Kind.FLUSH;
        else if (isStraight()) return Kind.STRAIGHT;
        else if (hasNKind(3)) return Kind.THREE_OF_A_KIND;
        else if (isTwoPair()) return Kind.TWO_PAIR;
        else if (hasNKind(2)) return Kind.PAIR; 
        else return Kind.HIGH_CARD;
    }
    
    public String getRank(){
    	return kind().name();
    }

}
