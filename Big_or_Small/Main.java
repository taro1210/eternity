package Big_or_Small;

/*
 mainメソッドを持つ。
「BigOrSmall」クラスを使用して、「Big or Small」のゲームをスタートする。
 */

public class Main {

	public static void main(String[]args) {

		Chip chip = new Chip();  //Chipクラス生成
		Trumps trump = new Trumps();  //Trumpクラス生成
		BorS bos = new BorS();  //B_or_Sクラス生成
		bos.chip = chip;

		Card firstCard = null;  //場のカード
		Card secondCard = null;  //プレイヤーのカード

		System.out.println("===========  Big OR Small  ===========");
		System.out.println("*********チップの枚数とカード*********");
		trump.makeDeck(); //deckの中身を定義
		trump.shuffle();  //deckをシャッフル

		 //スコアの表示
		chip.dispScore();
		//System.out.println("devag" + chip.score);
		System.out.println();

		 //一枚目のカード
		System.out.print("場のカード：");
		firstCard = trump.draw();
		System.out.println();
		System.out.println("************************************");
		//System.out.println("devag" + chip.score);

		 //BETする枚数
		System.out.println("■BETするチップの枚数");
		System.out.println("（MIN:1 ～ MAX:20）");
		bos.chipBET();  //チップをBET
		System.out.println();
		System.out.println("************************************");


		//newGameに"0"が代入されている間はループ。
		String newGame = "0";
		while(!"1".equals(newGame)) {
			int count = 0;
			count++;

			//Big or Smallの選択
			System.out.println("■Big or Small選択");
			System.out.print("現在のカード: ");
			String fCard = Card.getSuitName(firstCard.getSuit());
			System.out.println(fCard + firstCard.getNum());
			System.out.println("[Big or Small] Big…0  Small…1");
			bos.bigsmall();
			System.out.println("************************************");

			//引いたカード
			System.out.print("引いたカード：");
			secondCard = trump.draw();

			//現状の表示
			System.out.println();
			System.out.println ("*********** Big or Small ***********");

			//場の表示
			System.out.println("BET数" + bos.inputChip + "枚");
			System.out.print("あなたの選択: ");
			String sentaku = null;
				if(bos.choose.equals("0")) {
					sentaku = "Big";
				}else if(bos.choose.equals("1")) {
					sentaku = "Small";
				}
				System.out.println(sentaku);
			System.out.print("場のカード: " );
			fCard = Card.getSuitName(firstCard.getSuit());
			System.out.println(fCard + firstCard.getNum());
			System.out.print("あなたの引いたカード: ");
			String sCard = Card.getSuitName(secondCard.getSuit());
			System.out.println(sCard + secondCard.getNum());

			//正答をここでいわなければならない
			//System.out.println(fCard + firstCard.getNum() + "は" + sCard + secondCard.getNum() + "より" + sentaku);
			System.out.println("************************************");

			//判定
			boolean judge = false;
			judge = bos.Game2(firstCard, secondCard);
			System.out.println();
			System.out.println("************************************");

			//引いたカードを新しい場カードに
			firstCard = secondCard;

			//勝ちの場合のみ倍プッシュ
			if(judge == true) {
				String winC = bos.winChoose();
					if(winC.equals("0")) {
						continue;
					}
			}

			chip.dispScore();
			//山札がいっぱいの時
			if(count == trump.deck.length) {
				String lostD = bos.lostDeck();
				if(lostD.equals("1")){
					break;
				}
			}

			//次のゲームの確認
			newGame = bos.nextGame();
			}

	bos.end(); //終了
	}
}