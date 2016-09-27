package poker;

import java.io.IOException;

public class Card {
	
	public enum Suit { H,S,C,D;}
	
	private Suit suit;
	private int rank;
	
	public Card(String v, String s){
		suit = Suit.valueOf(s);
		
		try{
			rank = CardRank.valueOf(v).getCardRank();
		}catch (IllegalArgumentException e){
			rank = Integer.parseInt(v);
		}
	}
	
	public Suit getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}

}
