package Big_or_Small;

import java.io.StreamCorruptedException;

/*BigOrSmallクラス
・「チップ」クラス、「トランプ」クラス、「カード」クラスを使用する。
・カードデッキから1枚ずつカードを引き、先に引いたカードに対し、
  後に引いたカードの数字が大きい(Big)カードになるのか、小さい(Small)カードになるのかを判断する。
・お互いのカードの数字が同じだった場合、カードのマークで「Big」or「Small」を判断する。
・カードのマークの強さは、「スペード」 > 「ハート」 > 「ダイヤ」 > 「クラブ」の
  順であり、スペードが最も強く、クラブが最も弱い。
・「Big or Small」は連続して行うことができる。連続して行う場合、
  最初に引いたカードAと次に引いたカードBで、「Big or Small」を行い、
  次のゲームでは、カードBと、さらに新しく引くカードCで、「Big or Small」を行う。
  チップ情報などを表示する(例: 「保有点、[10]チップの枚数、[1]チップの枚数」)。*/


public class B_or_S {
	//「チップ」クラス、「トランプ」クラス、「カード」クラスを使用する。
	Trump trump = new Trump();
	Chip chip =new Chip();
	Card card =new Card(null, 0, 0);

	public void chipBET(){
		try {
			int inputChip=new java.util.Scanner(System.in).nextInt();
				if ( inputChip < 0) {
					throw  new 	StreamCorruptedException();

				} if ( inputChip > 20) {
					throw  new 	StreamCorruptedException();
				}
				chip.score(inputChip);
			} catch ( java.util.InputMismatchException e ) {
				System.out.print ("BETは半角数字で「0～20」を入力して下さい。>");
				chipBET();
			} catch ( StreamCorruptedException e ) {
				System.out.print ("BETは半角数字で「0～20」を入力して下さい。>");
				chipBET();
			}
	}

	//・カードデッキから1枚ずつカードを引き、先に引いたカードに対し、
	//後に引いたカードの数字が(Big)になるのか、(Small)になるのかを判断する。
	public void Game1(){
		boolean BoS = false;
		try {
		int inputval=new java.util.Scanner(System.in).nextInt();
			if ( inputval < 0) {
				throw  new 	StreamCorruptedException();
			}
			if ( inputval > 1) {
				throw  new 	StreamCorruptedException();
			}

			if ( inputval == (0)) {
				BoS = true;
			} else if ( inputval == (1)) {
				BoS = false;
			}
			Game2(BoS);

		} catch ( java.util.InputMismatchException e ) {
			System.out.println ("「0」か「1」を入力して下さい。");
			Game1();
		} catch ( StreamCorruptedException e ) {
			System.out.println ("「0」か「1」を入力して下さい。");
			Game1();
		}
	}

	public void Game2 (boolean BoS) {
		trump.drow2();
		System.out.println ("************************************");
		if ( BoS = true ) {
			if ( trump.firstCard.card < trump.secondCard.card){
				win();
			} else if ( trump.firstCard.card == trump.secondCard.card) {
				if( trump.firstCard.level < trump.secondCard.level){
					win();
				} else if (trump.firstCard.level == trump.secondCard.level) {
					System.out.println ("エラーが発生しました");
					end();
				} else {
					lose();
				}
			}else {
				lose();
			}
		}else if ( BoS = false ) {
			if ( trump.firstCard.card > trump.secondCard.card){
				win();
			} else if ( trump.firstCard.card == trump.secondCard.card) {
				if( trump.firstCard.level > trump.secondCard.level){
					win();
				} else if (trump.firstCard.level == trump.secondCard.level) {
					System.out.println ("エラーが発生しました");
					end();
				} else {
					lose();
				}
			}else {
				lose();
			}
		}
	}
	public void win() {
		System.out.println ("勝ち！！");
	}
	public void lose() {
		System.out.println ("負け…");
	}
	public void end() {
		System.out.println ("終了します。");
		System.out.println ("************************************");
		System.out.println ("************************************");
	}


}
