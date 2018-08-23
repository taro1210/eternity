package Big_or_Small;

import java.util.InputMismatchException;

/*トランプクラス
4×13通りのトランプが、1枚ずつ入った52枚をトランプ(カードデッキ)として考える。
カードデッキに重複したカードは存在しない。
カードデッキからランダムなカードを引ける。
カードデッキからカードを引くと、そのカードはカードデッキから取り除かれる。
カードデッキは初期状態(52枚)に戻すことができる。*/


class Trump {

	Card[] deck = new Card[52];
	Card card = new Card();
	int j = 0;
	Card showCard;

	//カードを引くメソッド
	public void draw(Card drawCard){
		int draw = new java.util.Random().nextInt (4);
		int num = new java.util.Random().nextInt (13);
			Card deckCard = new Card(num,draw);
			this.showCard = deckCard;

			Boolean isRegist = false;
			for (int i = 0; i < deck.length; i++) {
				if (deck[i] != null) {
					if(deckCard.equals(deck[i])){
						isRegist = true;
						break;
					}
				}
			}

			if (!isRegist){
				deck[j] = deckCard;
				switch (draw){
				case 0:
					System.out.println ("クラブ" + card.club[num]);
					break;
				case 1:
					System.out.println ("ダイヤ" + card.diamond[num]);
					break;
				case 2:
					System.out.println ("ハート" + card.heart[num]);
					break;
				case 3:
					System.out.println ("スペード" + card.spade[num]);
					break;
			}
				j++;
			} else {
				deckCard = null;
				draw (deckCard);
			}

	}

	public void nowCard(int num, int draw){
		switch (draw){
		case 0:
			System.out.println ("クラブ" + card.club[num]);
			break;
		case 1:
			System.out.println ("ダイヤ" + card.diamond[num]);
			break;
		case 2:
			System.out.println ("ハート" + card.heart[num]);
			break;
		case 3:
			System.out.println ("スペード" + card.spade[num]);
			break;
		}
	}

	public String fullCard(){
	try {
		String fullGame = new java.util.Scanner(System.in).nextLine();
			if (! fullGame.equals("0") || !fullGame.equals("1")){
				throw  new 	InputMismatchException();
			}
			return fullGame;
		} catch ( java.util.InputMismatchException e ) {
			System.out.println ("半角数字「0」か「1」を入力して下さい。");
			fullCard();
			return null;
		}
	}

	public void clearDeck(){
		for (int i = 0; i<deck.length; i++){
		deck[i] = null;
		}
	}
}
	/*
	int num = new java.util.Random().nextInt (13)+1;
	int level = new java.util.Random().nextInt(4);
	String mark = null;
		switch (level){
			case 0:
				mark = ("クローバー");
				break;
			case 1:
				mark = ("ダイヤ");
				break;
			case 2:
				mark = ("ハート");
				break;
			case 3:
				mark = ("スペード");
				break;
		}
		Card firstCard = new Card(mark, num ,level);
		System.out.println(mark + num);

		Boolean isRegist = false;
		for (int i = 0; i < cardnum.length; i++) {
			if (cardnum[i] != null) {
				if(firstCard.equals(cardnum[i])){
					isRegist = true;
					break;
				}
			}
		}
		if (!isRegist){
			cardnum[x] = firstCard;
			x++;*/

	/*public Card drow2(){
		int card2 = new java.util.Random().nextInt (13)+1;
		int level2 = new java.util.Random().nextInt(4);
		String mark2 = null;
			switch (level2){
				case 0:
					mark2 = ("クローバー");
					break;
				case 1:
					mark2 = ("ダイヤ");
					break;
				case 2:
					mark2 = ("ハート");
					break;
				case 3:
					mark2 = ("スペード");
					break;
			}

			try{
				Card secondCard = new Card(mark2, card2 ,level2);
				System.out.println (mark2 + card2);


			if  (secondCard.mark.equals(firstCard.mark) &&
				 secondCard.card == (firstCard.card) &&
				 secondCard.level == (firstCard.level)){
				throw new IllegalArgumentException();
			}

			} catch (IllegalArgumentException e) {
				drow2();
			}
			return secondCard;
	}*/

	/*public void check(){
			for (int i = 0; i < cardnum.length; i++) {
					if ( cardnum[i] != null ) {
						if  (firstCard.mark.equals(cardnum[i].mark) &&
							 firstCard.card == (cardnum[i].card) &&
							 firstCard.level == (cardnum[i].level)){
							break;
						} else {
							cardnum[i] = firstCard;
							i++;
							break;
						}
					}
			}
	}*/


