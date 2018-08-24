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

		Card firstCard = null;  //場のカード
		Card secondCard = null;  //プレイヤーのカード

		System.out.println("===========  Big OR Small  ===========");
		System.out.println("*********チップの枚数とカード*********");
		trump.makeDeck(); //deckの中身を定義
		trump.shuffle();  //deckをシャッフル

		 //スコアの表示
		chip.dispScore();

		 //一枚目のカード
		System.out.print("場のカード：");
		firstCard = trump.draw();
		System.out.println("************************************");

		 //BETする枚数
		System.out.println("■BETするチップの枚数"); //チップをBET
		System.out.println("（MIN:1 ～ MAX:20）");
		bos.chipBET();
		System.out.println("************************************");

		String newGame = "0";
		while(!"1".equals(newGame)) {
			int count = 0;
			count++;

			//Big or Smallの選択
			System.out.println("■Big(…0) or Small(…1) ？ ");
			bos.bigsmall();
			System.out.println("************************************");

			//引いたカード
			System.out.print("引いたカード：");
			secondCard = trump.draw();

			//現状の表示
			System.out.println();
			System.out.println ("*********** Big or Small ***********");

			System.out.print("場のカード: " );
			String fCard = Card.getSuitName(firstCard.getSuit());
			System.out.println(fCard + firstCard.getNum());
			System.out.print("あなたの引いたカード: ");
			String sCard = Card.getSuitName(secondCard.getSuit());
			System.out.println(sCard + secondCard.getNum());

			System.out.print ("あなたの選択: ");
				if(bos.choose.equals("0")) {
					System.out.println ("Big");
				}else if(bos.choose.equals("1")) {
					System.out.println ("Small");
				}
				System.out.println();

			//判定
			boolean judge = bos.Game2(firstCard, secondCard);

			//勝ちの場合のみ倍プッシュ
			if(judge = true){
				String winC = bos.winChoose();
					if(winC.equals("0"))
				firstCard = secondCard;
				continue;
			}

			//引いたカードを新しい場カードに
			firstCard = secondCard;

			//山札がいっぱいの時
			if(count == trump.deck.length) {
				System.out.println("山札にカードがありません。");
				System.out.println("リセットして続けますか？ Yes(…0) / No(…1)");
				newGame = trump.fullCard();
				System.out.println("山札をリセットしました。");
				}

			//新しい場カードを表示
			System.out.print("新しい場のカード：");
			fCard = Card.getSuitName(firstCard.getSuit());
			System.out.println(fCard + firstCard.getNum());
			newGame = bos.nextGame();
			newGame = chip.checkScore();
			}

	bos.end(); //終了
	}
}