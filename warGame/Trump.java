package warGame;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Trump {

	int index = 0;
	Card[] deck;

	public Card[] makeDeck(int i) {
		deck = new Card[i];
		int index = 0;
		String suit_name = "";
		for (int suit = 0; suit < 2; suit++) {
			for (int num = 2; num < 15; num++) {
				if (suit == 0) {
					suit_name = "ダイヤ";
				} else if (suit == 1) {
					suit_name = "スペード";
				} else {
					System.out.println("エラー！");
				}
				Card card = new Card(suit_name, num);
				deck[index] = card;
				index++;
			}
		}
		return deck;
	}

	public void shuffle() {
		// 配列が空か１要素ならシャッフルしようがないので、そのままreturn
		if (deck.length <= 1) {
			return;
		}

		// Fisher–Yates shuffle
		Random rnd = ThreadLocalRandom.current();
		for (int i = 0; i < deck.length; i++) {
			int dex = rnd.nextInt(i + 1);
			// 要素入れ替え(swap)
			Card tmp = deck[dex];
			deck[dex] = deck[i];
			deck[i] = tmp;
		}
	}

	public String cardNumChange(int num) {
		String changeNum = Integer.toString(num);
		if (num == 11) {
			changeNum = "J";
		} else if (num == 12) {
			changeNum = "Q";
		} else if (num == 13) {
			changeNum = "K";
		} else if (num == 14) {
			changeNum = "A";
		}
		return changeNum;
	}

	public Card[] readDataInput(int x, int y, String readDataArray[]) {
		int j = 0;
		Card[] card = new Card[13];
		for (int i = x; i < y; i++) {
			String suitA = readDataArray[i];
			i++;
			int numB = Integer.parseInt(readDataArray[i]);
			Card cardA = new Card(suitA, numB);
			card[j] = cardA;
			j++;
		}
		return card;
	}

	public Card[] distributesCard(int x, int handCard, Card[] inputdeck) {
		int hdCount = 0;
		Card[] handcard = new Card[handCard];
		for (int i = 0; i < inputdeck.length; i++) {
			if (i % 2 == x) {
				handcard[hdCount] = inputdeck[i];
				hdCount++;
			}
		}
		return handcard;

	}
}