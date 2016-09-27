package poker;

public class Poker {
	
	Hand h;
	
	public Poker(){};
	
	public void createHand(String s){
		h = new Hand(s);
		h.orderHand();
	}
	
	public void printHand(){
		h.printHand();
	}
	
	public String getHandRank(){
		return h.getRank();
	}
	
	public static void main(String[] args){
	    Poker p = new Poker();
	    p.createHand("TD TC TH 7C 7D");
	    System.out.println("Kind: " + p.getHandRank());
	}

}
