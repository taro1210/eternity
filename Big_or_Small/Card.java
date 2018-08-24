package Big_or_Small;

/*カードクラス
4つのマーク（スペード、ハート、ダイヤ、クラブ）と数字（1〜13）の組み合わせで、計52種類ある。
カード情報は、マークと数字の両方をセットで表示する（例：ハート10）。*/

//Cardは一枚のカードとしての位置づけ


public class Card {
	private int num;
	private int suit;

	public Card(int suit, int num) {
		this.suit = suit;
		this.num = num;

		// TODO 自動生成されたコンストラクター・スタブ
	}

	public void setSuit(int suit){
		this.suit = suit;
	}

	public int getSuit() {
		return suit;
	}

	public void setNum(int num){
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public static String getSuitName(int suit){
		String suitName = null;
		switch (suit){
		case 0:
			suitName = "クラブ";
			break;
		case 1:
			suitName = "ダイヤ" ;
			break;
		case 2:
			suitName = "ハート" ;
			break;
		case 3:
			suitName = "スペード";
			break;
		}
		return suitName;
	}

	/*public  Card cardNumber(int num, int draw) {
		Card cardnumber = null;
		switch (draw){
		case 0:
			cardnumber = ("クラブ" + club[num]);
			break;
		case 1:
			cardnumber = ("ダイヤ" + diamond[num]);
			break;
		case 2:
			cardnumber = ("ハート" + heart[num]);
			break;
		case 3:
			cardnumber = ("スペード" + spade[num]);
			break;
		}
		return cardnumber;
	}*/
}
