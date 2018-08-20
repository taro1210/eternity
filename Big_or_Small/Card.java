package Big_or_Small;



/*カードクラス
4つのマーク（スペード、ハート、ダイヤ、クラブ）と数字（1〜13）の組み合わせで、計52種類ある。
カード情報は、マークと数字の両方をセットで表示する（例：ハート10）。*/
public class Card {
	String mark;//マーク
	int card;//カード
	int level;//カードの強さ

	Card(String mark, int card , int level) {
		this.mark = mark;
		this.card = card;
		this.level =level;
	}
	public String toString() {
		return ( mark + card +level );
	}
}
