package Big_or_Small;



/*カードクラス
4つのマーク（スペード、ハート、ダイヤ、クラブ）と数字（1〜13）の組み合わせで、計52種類ある。
カード情報は、マークと数字の両方をセットで表示する（例：ハート10）。*/
public class Card {

	int draw;
	int num ;

	final int heart[] = {1,2,3,4,5,6,7,8,9,10,11,12,13};
	final int club[] = {1,2,3,4,5,6,7,8,9,10,11,12,13};
	final int spade[] = {1,2,3,4,5,6,7,8,9,10,11,12,13};
	final int diamond[] = {1,2,3,4,5,6,7,8,9,10,11,12,13};

	Card(int num, int draw){
		this.num = num;
		this.draw = draw;
	}

	public Card() {
	}

	/* (非 Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + draw;
		result = prime * result + num;
		return result;
	}

	/* (非 Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (draw != other.draw)
			return false;
		if (num != other.num)
			return false;
		return true;
	}
}