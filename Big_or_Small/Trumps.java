package Big_or_Small;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Trumps {

	int index = 0;
	Card[]deck = new Card[52];

	public void makeDeck(){
		for(int i = 0; i < 4; i++){
			for(int j = 1; j < 14; j++){
			Card card = new Card(i, j);
			deck[index] = card;
			index++;
			}
		}
		index = 0;
	}

	public void shuffle() {
	    // 配列が空か１要素ならシャッフルしようがないので、そのままreturn
	    if (deck.length <= 1) {
	        return;
	    }

	    // Fisher–Yates shuffle
	    Random rnd = ThreadLocalRandom.current();
	    for (int i = deck.length - 1; i > 0; i--) {
	        int dex = rnd.nextInt(i + 1);
	        // 要素入れ替え(swap)
	        Card tmp = deck[dex];
	        deck[dex] = deck[i];
	        deck[i] = tmp;
	    } //オブジェクト指向的に引数をわざわざ渡さずともdeckをshuffleしたらよい。
	}

	public Card draw(){
		String suitN = Card.getSuitName(deck[index].getSuit());
		System.out.println(suitN + deck[index].getNum());
		index++;
		return deck[index -1];
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
				return fullCard();
			}
		}

		public void clearDeck(){
			for (int i = 0; i<deck.length; i++){
			deck[i] = null;
			makeDeck();
			shuffle();
			}
		}
}
