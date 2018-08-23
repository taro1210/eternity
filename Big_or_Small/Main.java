package Big_or_Small;

/*
 mainメソッドを持つ。
「BigOrSmall」クラスを使用して、「Big or Small」のゲームをスタートする。
 */
public class Main{


	public static void main ( String[]args ) {

		Chip chip = new Chip();  //Chipクラス生成
		Trump trump = new Trump();  //Trumpクラス生成
		BorS bos = new BorS();  //B_or_Sクラス生成

		Card firstCard = null ;  //場のカード
		Card secondCard = null ;  //プレイヤーのカード


		System.out.println ("===========  Big OR Small  ===========");
		System.out.println ("*********チップの枚数とカード*********");

		 //スコアの表示
		chip.score();

		 //一枚目のカード
		System.out.print ("現在のカード：");
		trump.draw (firstCard);
		firstCard = trump.showCard;
		System.out.println ("************************************");

		 //BETする枚数
		System.out.println ("■BETするチップの枚数"); //チップをBET
		System.out.println ("（MIN:1 ～ MAX:20）");
		bos.chipBET();
		System.out.println ("************************************");

		for(int first = 0; first < trump.deck.length;){
			//Big or Small
			System.out.println ("■Big(…0) or Small(…1) ？ ");
			bos.bigsmall();
			System.out.println ("************************************");

			//二枚目のカードS
			System.out.print ("引いたカード：");
			trump.draw (secondCard);
			secondCard = trump.showCard;
			System.out.println();

			//判定
			System.out.println();
			System.out.println ("*********** Big or Small ***********");

			System.out.print ("場のカード: " );
			trump.nowCard (firstCard.num, firstCard.draw);
			System.out.print ("あなたの引いたカード: ");
			trump.nowCard (secondCard.num, secondCard.draw);

			System.out.print ("あなたの選択: ");
				if ( bos.choose.equals("0")){
					System.out.println ("Big");
				}else if ( bos.choose.equals("1")){
					System.out.println ("Small");
				}

			bos.Game2(firstCard, secondCard);
			firstCard = secondCard;


			String newGame = bos.nextGame();
			  //if (newGame.equals("0") || newGame.equals("2")){
				if (newGame.equals("0")) {
					first++;
				} else if (newGame.equals("1")){
					break;
				} else if (first == trump.deck.length){
					System.out.println("山札にカードがありません。");
					System.out.println("リセットして続けますか？ Yes(…0) / No(…1)");
					String fullcard = trump.fullCard();
						if (fullcard.equals("0")){
							trump.clearDeck();
							first = 0;
							System.out.println("山札をリセットしました。");
						continue;
					} else if (fullcard.equals("1")) {
						break;
					}

				}
	}
	bos.end();
	}
}