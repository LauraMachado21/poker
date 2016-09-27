package poker;

import java.util.Comparator;

public class CardSuitComparator implements Comparator<Card> {

	public int compare(Card c1, Card c2){
		return c1.getSuit().compareTo(c2.getSuit());
	}
}
