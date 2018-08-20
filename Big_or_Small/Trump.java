package Big_or_Small;


/*トランプクラス
4×13通りのトランプが、1枚ずつ入った52枚をトランプ(カードデッキ)として考える。
カードデッキに重複したカードは存在しない。
カードデッキからランダムなカードを引ける。
カードデッキからカードを引くと、そのカードはカードデッキから取り除かれる。
カードデッキは初期状態(52枚)に戻すことができる。*/


class Trump {
		Card cardnum[] = new Card[52];//代入するところ
		String mark;
		int card;
		int level;
		Card firstCard = new Card(mark,  card ,level);
		Card secondCard= new Card(mark,  card ,level);;


	public void drow(){
		int card = new java.util.Random().nextInt (13)+1;
		int level = new java.util.Random().nextInt(4);
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

			Card firstCard = new Card(mark, card ,level);
			System.out.println (this.mark + card);
	}

	public void drow2(){
		int card = new java.util.Random().nextInt (13)+1;
		int level = new java.util.Random().nextInt(4);
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

			try{
				Card secondCard = new Card(mark, card ,level);
				System.out.println (this.mark + card);

			if  (secondCard.mark.equals(firstCard.mark) &&
				 secondCard.card == (firstCard.card) &&
				 secondCard.level == (firstCard.level)){
				throw new IllegalArgumentException();
			}
			}catch (IllegalArgumentException e) {
				drow2();
			}
	}

	public void check(){
			for (int i = 0; i < cardnum.length; i++) {
					if ( cardnum[i] != null ) {
						if  (firstCard.mark.equals(cardnum[i].mark) &&
							 firstCard.card == (cardnum[i].card) &&
							 firstCard.level == (cardnum[i].level)){
							drow();
							break;
						} else {
							cardnum[i] = firstCard;
							i++;
							break;
						}
					}
			}
	}
}
