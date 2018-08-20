package Big_or_Small;

/*
 mainメソッドを持つ。
「BigOrSmall」クラスを使用して、「Big or Small」のゲームをスタートする。
 */
public class T_Game {

	public static void main ( String[]args ) {

		System.out.println ("===========  Big OR Small  ===========");
		System.out.println ("*********チップの枚数とカード*********");
		Chip chip = new Chip();

		chip.score(); //スコアの表示

		System.out.print ("現在のカード："); //一枚目のカード
		Trump trump = new Trump();
		trump.drow();
		System.out.println ("************************************");

		B_or_S bigorsmall = new B_or_S(); //ゲームスタート
		System.out.println ("■BETするチップの枚数"); //チップをBET
		System.out.println ("（MIN:1 ～ MAX:20）");
		bigorsmall.chipBET();
		System.out.println ("************************************");

		System.out.println("■Big(…0) or Small(…1) ？ ");
		bigorsmall.Game1();
		System.out.println ("************************************");

	}
}
