package poker;

public enum CardRank {
	T(10),
	J(11),
	Q(12),
	K(13),
	A(14);
		
	private int cardValue;
	
	private CardRank(int i){
		this.cardValue=i;
	}
	
	public int getCardRank(){
		return cardValue;
	}
}
