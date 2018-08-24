package Big_or_Small;

import java.io.StreamCorruptedException;
import java.util.InputMismatchException;

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

public class BorS {
	//「チップ」クラス、「トランプ」クラス、「カード」クラスを使用する。
	Trumps trump = new Trumps(); //Trumpクラスを生成
	static Chip chip =new Chip();  //Chipクラスを生成


	int inputChip;  //入力されたチップを入れる
	int winChip;  //勝った際にチップを入れる
	String choose;  //Big or Smallの判断を代入

	//BETチップを入力するメソッド
	public void chipBET(){
		try {
			int inputChip=new java.util.Scanner(System.in).nextInt();
				if ( inputChip < 1) {
					throw  new 	StreamCorruptedException();

				} if ( inputChip > 20) {
					throw  new 	StreamCorruptedException();
				}
				chip.score(inputChip);
				this.inputChip = inputChip;
			} catch ( java.util.InputMismatchException e ) {
				System.out.println ("BETは「0～20」を入力して下さい。");
				chipBET();
			} catch ( StreamCorruptedException e ) {
				System.out.println ("BETは「0～20」を入力して下さい。");
				chipBET();
			}
	}

	//Big、Smallの入力を受け付けるメソッド
	public void bigsmall() {
		try {
			String inputval = new java.util.Scanner(System.in).nextLine();
				if ( inputval.equals("0")) {
					this.choose = inputval;
				} else if ( inputval.equals("1")) {
					this.choose =inputval;
				} else {
					throw  new 	InputMismatchException();
				}
			} catch ( java.util.InputMismatchException e ) {
				System.out.println ("半角数字「0」か「1」を入力して下さい。");
				bigsmall ( );
			}
	}

	//カードの比較し勝敗を決めるメソッド
	public boolean Game2(Card first, Card second){
		boolean judge = false;
		switch(choose){

		//選択が「0（Big）」の場合
		case "0":
			if ( first.getNum() < second.getNum() ){
				win();
				judge = true;
			} else if ( first.getNum() == second.getNum() ) {
				if ( first.getSuit() < second.getSuit()){
					win();
					judge = true;
			} else if(first.getSuit() == second.getSuit()) {
				System.out.println ("予期せぬエラーがエラーが発生しました");
				end();
			} else {
				lose();
				judge = false;
			}
		}else {
			lose();
			judge = false;
		}
		break;

		//選択が「1（Small）」の場合
		case "1":
			if ( first.getNum() > second.getNum()){
				win();
				judge = true;
			} else if( first.getNum() == second.getNum()) {
				if ( first.getSuit() > second.getSuit()){
					win();
					judge = true;
				} else if (first.getSuit() == second.getSuit()) {
					System.out.println ("予期せぬエラーが発生しました");
					end();
				} else {
					lose();
					judge = false;
				}
			}else {
				lose();
				judge = false;
			}
		break;
		}
		return judge;
	}

	//勝ちメソッド
	public void win() {
		System.out.println("勝ち！");
		winChip = inputChip * 2;
		System.out.println(winChip + "枚のチップを手に入れました！");
	}

	//勝った場合に賭け直しをするメソッド
	public String winChoose(){
		String winNext = null;
		System.out.println("獲得した" + winChip + "枚でゲームを続けますか？");
		System.out.println(" Yes(…0) or No(…1)? ");
			String inputNext = new java.util.Scanner(System.in).nextLine();
				if ( inputNext.equals("0")) {   //ゲームを続ける
					inputChip = winChip;
					winNext = inputNext;

				} else if(inputNext.equals("1")) {    //続けずチップを回収する。
					chip.chip10 = chip.chip10 + (winChip/10);    //10チップに足す
					chip.chip1 = chip.chip1 + (winChip%10);     //1チップに足す
					if (chip.chip1 >= 10) {
						for (; chip.chip1 >= 10;) {
							chip.chip1 -= 10;
							chip.chip10++;
							winNext = inputNext;
						}
					}
				}
				return winNext;
	}

	//負けメソッド
	public void lose() {
		System.out.println ("負け…");
		inputChip = 0;
	}

	//次のゲームへ進むかを決めるメソッド
	public String nextGame() {
		String bol = null;
		System.out.println(" ゲームを続けますか？ ");
		System.out.println(" Yes(…0) or No(…1)? ");
		try {
			String inputNext = new java.util.Scanner(System.in).nextLine();
				if(inputNext.equals("0")) { //ゲームを続ける
					System.out.println();
					System.out.println("************* Next Game! *************");
					System.out.println("■BETするチップの枚数"); //チップをBET
					System.out.println("（MIN:1 ～ MAX:20）");
					chipBET();
					System.out.println("************************************");
					bol = inputNext;

				} else if ( inputNext.equals("1")) {    //ゲームを終了する
					bol = inputNext;

				} else {
					throw  new 	InputMismatchException();
				}

			} catch(java.util.InputMismatchException e) {
				System.out.println("半角数字「0」,「1」を入力して下さい。");
				bigsmall();
			}
		return bol;
	}

	//終了メソッド
	public static void end() {
		System.out.println();
		System.out.println("************************************");
		System.out.println("終了します。お疲れ様でした。");
		chip.dispScore();
		System.out.println("************************************");
	}
}

	/*public void Game2 () {
		//trump.draw();

			System.out.println ("************************************");

		if ( BoS = true ) {
			if ( trump.cardnum[0].card < trump.cardnum[1].card ){
				win();
			} else if ( trump.cardnum[0].card == trump.cardnum[1].card) {
				if( trump.cardnum[0].level < trump.cardnum[1].level){
					win();
				} else if (trump.cardnum[0].level == trump.cardnum[1].level) {
					System.out.println ("エラーが発生しました");
					end();
				} else {
					lose();
				}
			}else {
				lose();
			}
		}else if ( BoS = false ) {
			if ( trump.cardnum[0].card > trump.cardnum[1].card){
				win();
			} else if (trump.cardnum[0].card == trump.cardnum[1].card) {
				if(trump.cardnum[0].level > trump.cardnum[1].level){
					win();
				} else if (trump.cardnum[0].level == trump.cardnum[1].level) {
					System.out.println ("エラーが発生しました");
					end();
				} else {
					lose();
				}
			}else {
				lose();
			}
		}
	}*/