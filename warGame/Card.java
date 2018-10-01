package warGame;

public class Card {
	private int num;
	private String suit;

	public Card(String suit, int num) {
		this.suit = suit;
		this.num = num;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public String getSuit() {
		return suit;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getNum() {
		return num;
	}
}