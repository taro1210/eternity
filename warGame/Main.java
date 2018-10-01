package warGame;

import java.util.InputMismatchException;

public class Main {
	 /**
	   * CSVファイルの名前
	   * (環境に合わせて書き換えてください)
	   */
	  private static final String CSV_FILE = "c:\\CodeCamp\\savedata.csv";// データを読み込み?
	public static void main(String[] args) {
		// 中断データの有無…

		Card[] deck = new Card[26]; // deckの枚数
		Card[] player = new Card[deck.length / 2]; // playerの手札
		Card[] cpu = new Card[deck.length / 2]; // cpuの手札
		int pleyerCount = 0; // playerの枚数カウンター
		int cpuCount = 0; // cpuの枚数カウンター
		int winCard = 0;
		int drowCard = 0;
		int loseCard = 0;

		// トランプクラスのインスタンス
		Trump trp = new Trump();

		// デッキ生成
		deck = trp.makeDeck(deck.length);

		// カードをシャッフル
		trp.shuffle();

		// シャッフルした結果をお互いの手札へ
		for (int i = 0; i < deck.length; i++) {
			if (i % 2 == 0) {
				player[pleyerCount] = deck[i];
				pleyerCount++;
			} else if (i % 2 == 1) {
				cpu[cpuCount] = deck[i];
				cpuCount++;
			}
		}
		int gameCount = 0;
		while (gameCount < player.length & gameCount < cpu.length) {
			System.out.printf("◆第%d回戦\r\n", gameCount + 1);
			String pl_suit = player[gameCount].getSuit();
			String cp_suit = cpu[gameCount].getSuit();
			String pl_num = trp.cardNumChange(player[gameCount].getNum());
			String cp_num = trp.cardNumChange(cpu[gameCount].getNum());
			System.out.printf("%d枚目の手札を出しますか？\r\n[出す:d  中断:q]\r\n", gameCount + 1);
			try {
				String inputX = scan();
				if (inputX.equalsIgnoreCase("Q")) {
					break;
				} else if (!(inputX.equalsIgnoreCase("D"))) {
					throw new InputMismatchException();
				}

				System.out.println("あなたのカード: " + pl_suit + pl_num);
				System.out.println("CPUのカード: " + cp_suit + cp_num);

				if (player[gameCount].getNum() > cpu[gameCount].getNum()) {
					System.out.println("勝ち！Win！");
					winCard += 2 + drowCard;
					drowCard = 0;
				} else if (player[gameCount].getNum() == cpu[gameCount].getNum()) {
					System.out.println("引き分け！Drow！");
					drowCard += 2;
				} else {
					System.out.println("負け…。Lose…");
					loseCard += 2 + drowCard;
					drowCard = 0;
				}
				System.out.println("あなたの獲得したカード:" + winCard + "枚\r\nCPUの獲得したカード:" + loseCard + "枚");
				System.out.println("");
				gameCount++;
			} catch (InputMismatchException e) {
				System.out.println("d,qのどちらかを入力して下さい");
			}
		}
		if (gameCount == player.length & gameCount == cpu.length) {
			System.out.println("");
			System.out.println("結果。result");
			System.out.println("あなたの獲得したカード:" + winCard + "枚\r\nCPUの獲得したカード:" + loseCard + "枚");
			if (winCard > loseCard) {
				System.out.println("あなたの勝ちです!");
			} else if (winCard == loseCard) {
				System.out.println("引き分けです…");
			} else {
				System.out.println("あなたの負けです…");
			}
		} else {
			System.out.println("中断しました");
			// なんらかに今の配列（player＆cpu）、gameCount、獲得カードと場のカードをセーブしたい（やっぱcsvかな～）
		}
	}

	@SuppressWarnings("resource")
	public static String scan() {
		String inputX = new java.util.Scanner(System.in).nextLine();
		return inputX;
	}
}
