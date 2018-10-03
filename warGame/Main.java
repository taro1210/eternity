package warGame;

import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) {
		boolean existingData = true;// 新規で始めるか続きで始めるかの判定
		Card[] deck = new Card[26]; // deckの枚数
		Card[] player = new Card[deck.length / 2]; // playerの手札
		Card[] cpu = new Card[deck.length / 2]; // cpuの手札
		int winCard = 0; // 自分の獲得したカード
		int drowCard = 0; // 場に積んであるカード
		int loseCard = 0; // 相手の獲得したカード
		int gameCount = 0; // 現在のゲーム回数
		int playerHandCard = 0;
		int cpuHandCard = 0;

		// トランプクラスのインスタンス

		Trump trp = new Trump();

		// CSVクラスのインスタンス
		Csv_data csv = new Csv_data();

		System.out.println("**** War Game ****\r\n");
		// 中断データの有無の確認
		if (csv.existSaveData()) {
			System.out.println("中断データが見つかりました。");
			String[] readDataArray = csv.interrupDataLording();
			// 中断データから再開する場合処理
			if (readDataArray != null) {
				winCard = Integer.parseInt(readDataArray[0]);
				drowCard = Integer.parseInt(readDataArray[1]);
				loseCard = Integer.parseInt(readDataArray[2]);
				gameCount = Integer.parseInt(readDataArray[3]);
				playerHandCard = Integer.parseInt(readDataArray[4]);
				cpuHandCard = Integer.parseInt(readDataArray[5]);
				int a = (readDataArray.length - 6) / 2;
				player = trp.readDataInput(6, a + 6, readDataArray);
				cpu = trp.readDataInput(a + 6, readDataArray.length, readDataArray);
				existingData = false;
			} else if (readDataArray == null) {
				existingData = true;
			}
			System.out.println("");
		}

		// 新規ゲームを行う場合に処理する
		if (existingData) {
			// デッキ生成
			deck = trp.makeDeck(deck.length);

			// カードをシャッフル
			trp.shuffle();

			// シャッフルした結果をお互いの手札へ
			player = trp.distributesCard(0, player.length, deck);
			cpu = trp.distributesCard(1, cpu.length, deck);
			playerHandCard = player.length;
			cpuHandCard = cpu.length;
		}

		// ゲームを開始する
		String inputChack = null;
		while (gameCount < player.length & gameCount < cpu.length) {
			System.out.printf("◆第%d回戦%n", gameCount + 1);
			String pl_suit = player[gameCount].getSuit();
			String cp_suit = cpu[gameCount].getSuit();

			// 11～14(A)は数字->文字に変えるため判定変換メソッドへ
			String pl_num = trp.cardNumChange(player[gameCount].getNum());
			String cp_num = trp.cardNumChange(cpu[gameCount].getNum());

			System.out.printf("あなたの持ち札:%d枚、獲得した札:%d枚%n", playerHandCard, winCard);
			System.out.printf("ＣＰＵの持ち札:%d枚、獲得した札:%d枚%n", cpuHandCard, loseCard);
			System.out.printf("場に積まれた札:%d枚%n%n", drowCard);
			System.out.print("札を切りますか？\r\n[切る:d  中断:q] >");
			try {
				inputChack = csv.scan();
				if (inputChack.equalsIgnoreCase("Q")) {
					break;
				} else if (!(inputChack.equalsIgnoreCase("D") || inputChack.equalsIgnoreCase("Q"))) {
					throw new InputMismatchException();
				}

				System.out.println("\r\nあなたのカード: " + pl_suit + pl_num);
				System.out.println("CPUのカード: " + cp_suit + cp_num);

				if (player[gameCount].getNum() > cpu[gameCount].getNum()) {
					System.out.println("勝ち！札を獲得しました！");
					winCard += 2 + drowCard;
					drowCard = 0;
				} else if (player[gameCount].getNum() == cpu[gameCount].getNum()) {
					System.out.println("引き分けです。");
					drowCard += 2;
				} else {
					System.out.println("負け…。Lose…");
					loseCard += 2 + drowCard;
					drowCard = 0;
				}
				playerHandCard--;
				cpuHandCard--;
				System.out.println("");
				gameCount++;
			} catch (InputMismatchException e) {
				System.out.println("半角文字のd,qのどちらかを入力して下さい");
			}
		}

		// 手札が無くなった場合結果を発表する
		if (gameCount == player.length || gameCount == cpu.length) {
			System.out.println("");
			System.out.println("**** 結果発表 ****");
			System.out.println("あなたの獲得したカード:" + winCard + "枚\r\nCPUの獲得したカード:" + loseCard + "枚\r\n");
			if (winCard > loseCard) {
				System.out.println("あなたの勝ちです!おめでとう！\r\n");
			} else if (winCard == loseCard) {
				System.out.println("引き分けです…。\r\n");
			} else {
				System.out.println("あなたの負けです…。\r\n");
			}
			System.out.println("今回の結果を登録します");
			csv.saveGameResult(winCard, loseCard);

			csv.dalete();

			// 中断を選択された時、csvに保存
		} else if (inputChack.equalsIgnoreCase("Q")) {
			System.out.println("中断しました");
			csv.interrupDataWrite(winCard, drowCard, loseCard, gameCount, playerHandCard, cpuHandCard, player, cpu);
		}
	}
}