package Big_or_Small;


/*BigOrSmallクラス
・「チップ」クラス、「トランプ」クラス、「カード」クラスを使用する。
・カードデッキから1枚ずつカードを引き、先に引いたカードに対し、
  後に引いたカードの数字が大きい(Big)カードになるのか、
  小さい(Small)カードになるのかを判断する。
・お互いのカードの数字が同じだった場合、カードのマークで「Big」or「Small」を判断する。
・カードのマークの強さは、「スペード」 > 「ハート」 > 「ダイヤ」 > 「クラブ」の
  順であり、スペードが最も強く、クラブが最も弱い。
・「Big or Small」は連続して行うことができる。連続して行う場合、
  最初に引いたカードAと次に引いたカードBで、「Big or Small」を行い、
  次のゲームでは、カードBと、さらに新しく引くカードCで、「Big or Small」を行う。
  チップ情報などを表示する(例: 「保有点、[10]チップの枚数、[1]チップの枚数」)。*/


public class B_or_S {
	//「チップ」クラス、「トランプ」クラス、「カード」クラスを使用する。
	Card card =new Card();
	Trump trump = new Trump();
	Chip chip =new Chip();

	//・カードデッキから1枚ずつカードを引き、先に引いたカードに対し、
	//後に引いたカードの数字が(Big)になるのか、(Small)になるのかを判断する。
	public void Game1(){
		trump.drow();
		System.out.println("Big or Small?");
		String bigsmall=new java.util.Scanner(System.in).nextLine();
			if ( bigsmall.equals ( "Big" )) {
			} else if ( bigsmall.equals ( "Small" )) {
			}
	}

}
