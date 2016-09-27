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
	
	public void getRank(){
		System.out.println("Kind: " + h.getRank());
	}
	
	public static void main(String[] args){
	    Poker p = new Poker();
	    p.createHand("AD 2D 3D 4D 5D");
	    p.printHand();
	    p.getRank();
	}

}
