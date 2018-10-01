package warGame;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Otamesi {
	static Card[] deck = new Card[26];

	public static void makeDeck() {
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
	}

	public static void shuffle() {
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

	public static void main(String[] args) {
		makeDeck();// デッキ生成
		shuffle(); // シャッフルする
		for (Card a : deck) {
			String b = Integer.toString(a.getNum());
			if (a.getNum() == 11) {
				b = "J";
			} else if (a.getNum() == 12) {
				b = "Q";
			} else if (a.getNum() == 13) {
				b = "K";
			} else if (a.getNum() == 14) {
				b = "A";
			}
			System.out.println(a.getSuit() + b);
		}
		System.out.println(deck[0].getNum() < deck[1].getNum());
		System.out.println(deck[1].getNum() < deck[2].getNum());
		System.out.println(deck[2].getNum() < deck[3].getNum());
	}
	int i =0;
	for (Card a : deck) {
		String b = Integer.toString(a.getNum());
		if (a.getNum() == 11) {
			b = "J";
		} else if (a.getNum() == 12) {
			b = "Q";
		} else if (a.getNum() == 13) {
			b = "K";
		} else if (a.getNum() == 14) {
			b = "A";
		}
		shaffledCard[i] = a.getSuit() + b;
		i++;
	}
}
