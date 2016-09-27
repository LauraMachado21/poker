package poker;

import java.util.Comparator;

class CardValueComparator implements Comparator<Card> {
	
    public int compare(Card c1, Card c2)
    {
    	return Integer.compare(c1.getRank(), c2.getRank());
    }
	
}
