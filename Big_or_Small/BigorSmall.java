package Big_or_Small;

import java.io.StreamCorruptedException;
import java.util.InputMismatchException;

public class BigorSmall {

	//インスタンス、フィールド生成。
	Chip chip = new Chip();  //Chip生成
	Trumps trump = new Trumps();  //Trump生成

	Card firstCard = null;  //場のカード
	Card secondCard = null;  //プレイヤーのカード

	String fCard;
	String sCard;	 //suit名を代入
	String sentaku;//BigかSmallの文字を入れる
	int inputChip;  //入力されたチップを入れる
	int winChip;  //勝った際にチップを入れる
	String choose;  //Big or Smallの判断を代入
	int countCard = 0; //カード枚数のカウント

	//ゲームを始めるメソッド
	public void startGame() {
		System.out.println("===========  Big OR Small  ===========");
		System.out.println("*********チップの枚数とカード*********");
		trump.makeDeck(); //deckの中身を定義
		trump.shuffle();  //deckをシャッフル

		//スコアの表示
		chip.dispScore();
		System.out.println();

		//一枚目のカード
		System.out.print("場のカード：");
		firstCard = trump.draw();
		countCard++;
		System.out.println();
		System.out.println("************************************");

		//BETする枚数
		chipBET();
	}

	//BETチップを入力するメソッド
	public void chipBET() {
		System.out.print("■BETするチップの枚数");
		if(chip.score == 1) {  //総計が1枚ならMAXは1。
		System.out.println("(MAX:1)");
		} else if(chip.score < 20) {  //総計が20以下ならそれMAXの表示を総計分にする。
			System.out.println("（MIN:1 ～ MAX:" + chip.score + ")");
		} else {
		System.out.println("（MIN:1 ～ MAX:20）");
		}
		try {
			String inputChip = new java.util.Scanner(System.in).nextLine();
				if(inputChip.matches("0\\d+")){  //応用1章＿正規表現
			    	throw new StreamCorruptedException();
				}
				if(!inputChip.matches("\\d+")){
			    	throw new java.util.InputMismatchException();
				}

				int inpC = Integer.parseInt(inputChip);  //文字列を数値に変換
				if(inpC < 1) {
					throw new StreamCorruptedException();
				}
				if(inpC > 20) {
					throw new StreamCorruptedException();
				}
				if(inpC > chip.score){
					throw new ArithmeticException();
				}
				chip.mainasScore(inpC);
				this.inputChip = inpC;
				System.out.println();
				System.out.println("************************************");
				selectBorS();

		} catch(java.util.InputMismatchException e ) {
			System.out.println("半角数字「1～20」を入力して下さい。");
			chipBET();
		} catch(StreamCorruptedException e ) {
			System.out.println("半角数字「1～20」を入力して下さい。");
			chipBET();
		} catch(ArithmeticException e ) {
			System.out.println("現在最大BET数は" + chip.score + "までです。");
			chipBET();
		}
	}

	//現情報表示
	public void selectBorS() {

		//山札がいっぱいの時に飛ぶ
		if(countCard == trump.deck.length) {
			lostDeck();
		}

		//Big or Smallの選択
		System.out.println("■Big or Small選択");
		System.out.print("現在のカード: ");
		fCard = Card.getSuitName(firstCard.getSuit());
		System.out.println(fCard + firstCard.getNum());
		System.out.println("[Big or Small] Big…0  Small…1");
		bigsmall();
	}

	//BigかSmallを決めるメソッド
	public void bigsmall() {
		try {
			String inputval = new java.util.Scanner(System.in).nextLine();
				if(inputval.equals("0")) {
					this.choose = inputval;
				} else if(inputval.equals("1")) {
					this.choose =inputval;
				} else {
					throw new InputMismatchException();
				}
				System.out.println("************************************");
				secondDraw();
		} catch(java.util.InputMismatchException e ) {
			System.out.println("半角数字「0」か「1」を入力して下さい。");
			bigsmall();
		}
	}

	//次のカードを引くメソッド
	public void secondDraw() {

		//引いたカード
		System.out.print("引いたカード：");
		secondCard = trump.draw();
		countCard++;
		nowView();
	}

	//現状の表示メソッド
	public void nowView() {

		System.out.println();
		System.out.println ("*********** Big or Small ***********");

		//場の表示
		System.out.println("BET数: " + inputChip + "枚");
		System.out.print("あなたの選択: ");
		sentaku = null;
			if(choose.equals("0")) {
				sentaku = "Big";
			}else if(choose.equals("1")) {
				sentaku = "Small";
			}
			System.out.println(sentaku);
		System.out.print("場のカード: " );
		fCard = Card.getSuitName(firstCard.getSuit());
		System.out.println(fCard + firstCard.getNum());
		System.out.print("あなたの引いたカード: ");
		sCard = Card.getSuitName(secondCard.getSuit());
		System.out.println(sCard + secondCard.getNum());
		judgeBorS();
	}

	//勝敗判定メソッド
	public void judgeBorS() {
		boolean judge = judgeCards(firstCard, secondCard);
		String correct = null;
			if(judge == true){
				correct = sentaku;
				System.out.println(sCard + secondCard.getNum() + "は" + fCard + firstCard.getNum() + "より" + correct);
			} else if(judge == false){
				if(sentaku.equals("Big")){
					correct = "Small";
				} else if(sentaku.equals("Small")){
					correct = "Big";
				}
				System.out.println(sCard + secondCard.getNum() + "は" + fCard + firstCard.getNum() + "より" + correct);
			}
		System.out.println("************************************");

		if(judge == true) {  //勝メソッドへ
			System.out.println("勝ち！");
			firstCard = secondCard;
			winChip = inputChip * 2;
			System.out.println(winChip + "枚のチップを手に入れました！");
			System.out.println();
			System.out.println("************************************");
			winChoose();

		} else if(judge == false) {  //敗メソッドへ
			System.out.println ("負け…");
			firstCard = secondCard;
			System.out.println();
			System.out.println("************************************");
			inputChip = 0;
			winChip = 0;
			System.out.println();
			chip.dispScore();
			System.out.println(" ゲームを続けますか？ ");
			System.out.println(" Yes(…0) or No(…1)? ");
			nextGame();
		}
	}

	//カードの比較し勝敗を決めるメソッド
	public boolean judgeCards(Card first, Card second) {
		boolean hantei = false;
			switch(choose) {

			//選択が「0（Big）」の場合
			case "0":
				if(first.getNum() < second.getNum() ) {
					hantei = true;
				} else if(first.getNum() == second.getNum() ) {
					if(first.getSuit() < second.getSuit()) {
							hantei = true;
					} else if(first.getSuit() == second.getSuit()) {
						System.out.println("予期せぬエラーがエラーが発生しました");
						end();
					} else {
						hantei = false;
					}
				}else {
					hantei = false;
				}
				break;

			//選択が「1（Small）」の場合
			case "1":
				if(first.getNum() > second.getNum()) {
					hantei = true;
				} else if(first.getNum() == second.getNum()) {
					if(first.getSuit() > second.getSuit()) {
						hantei = true;
					} else if(first.getSuit() == second.getSuit()) {
						System.out.println("予期せぬエラーが発生しました");
						end();
					} else {
						hantei = false;
					}
				} else {
					hantei = false;
				}
				break;
				}
			return hantei;
	}

	//勝ちの場合のみ倍プッシュ
	public void winChoose() {
		System.out.println("獲得した" + winChip + "枚でゲームを続けますか？");
		System.out.println(" Yes(…0) or No(…1)? ");
		try {
			String inputNext = new java.util.Scanner(System.in).nextLine();
				if ( inputNext.equals("0")) {   //ゲームを続ける
					inputChip = winChip;
					selectBorS();
				} else if(inputNext.equals("1")) {    //続けずチップを回収する。
					chip.chip10 = chip.chip10 + (winChip / 10);    //10チップに足す
					chip.chip1 = chip.chip1 + (winChip % 10);     //1チップに足す
						if(chip.chip1 >= 10) {
							while(chip.chip1 >= 10) {
								chip.chip1 -= 10;
								chip.chip10++;
							}
					}
					System.out.println();
					chip.dispScore();
					System.out.println(" ゲームを続けますか？ ");
					System.out.println(" Yes(…0) or No(…1)? ");
					nextGame();
				} else {
					throw  new 	InputMismatchException();
				}
				} catch(java.util.InputMismatchException e) {
					System.out.println("半角数字「0」,「1」を入力して下さい。");
					winChoose();
				}
	}

	//ゲームを続けるかどうかの判定をするメソッド

	public void nextGame() {
		try {
			String inputNext = new java.util.Scanner(System.in).nextLine();
				if(inputNext.equals("0")) { //ゲームを続ける
					String nextG = chip.checkScore(); //チップの有無を確認する
						if(nextG.equals("1")){
							end(); //なかったら終了。
						} else {
							System.out.println();
							System.out.println("************* Next Game! *************");
							chipBET();
						}

				} else if(inputNext.equals("1")) {    //ゲームを終了する
					end();
				} else {
					throw  new 	InputMismatchException();
				}
			} catch(java.util.InputMismatchException e) {
				System.out.println("半角数字「0」,「1」を入力して下さい。");
				nextGame();
			}
	}

	//山札が無くなった時のメソッド
	public void lostDeck() {
		System.out.println("山札にカードがありません。");
		System.out.println("リセットして続けますか？ Yes(…0) / No(…1)");
		String lostD = trump.lostCard();
			if(lostD.equals("0")) {
				trump.clearDeck();
				System.out.println("山札をリセットしました。");
				startGame();
			} else {
				end();
			}
	}

	//終了メソッド
	public void end() {
		System.out.println();
		System.out.println("************************************");
		System.out.println("終了します。お疲れ様でした。");
		System.out.println("************************************");
	}
}