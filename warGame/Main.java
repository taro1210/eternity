package warGame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InputMismatchException;

public class Main {
	/**
	 * CSVファイルの名前 (環境に合わせて書き換えてください)
	 */

	public static void main(String[] args) {
		File saveDataFile = new File("c:\\CodeCamp\\savedata.csv"); // セーブデータをFile型変数に代入
		BufferedReader savedata = null;
		boolean existingData = true;// 新規で始めるか続きで始めるかの判定
		Card[] deck = new Card[26]; // deckの枚数
		Card[] player = new Card[deck.length / 2]; // playerの手札
		Card[] cpu = new Card[deck.length / 2]; // cpuの手札
		int winCard = 0;  // 自分の獲得したカード
		int drowCard = 0; // 場に積んであるカード
		int loseCard = 0; // 相手の獲得したカード
		int gameCount = 0; // 現在のゲーム回数

		// トランプクラスのインスタンス
		Trump trp = new Trump();

		// 中断データの有無の確認
		try {
			if (saveDataFile.exists()) {
				String chackDataFile = ""; //入力を格納する
				
				System.out.println("中断データが見つかりました。");
				do {
					System.out.println("[続きから始める:y  最初から始める:n]");
					chackDataFile = scan();
					// 続きからの場合、csvから要素を取り出して内容に代入
					if (chackDataFile.equalsIgnoreCase("y")) {
						System.out.println("中断されたところから再開します。");
						savedata = new BufferedReader(new FileReader(saveDataFile));
						String line = savedata.readLine();
						String[] readDataArray = line.split(",");

						winCard = Integer.parseInt(readDataArray[0]);
						drowCard = Integer.parseInt(readDataArray[1]);
						loseCard = Integer.parseInt(readDataArray[2]);
						gameCount = Integer.parseInt(readDataArray[3]);
						int a = (readDataArray.length - 4) / 2;

						player = trp.readDataInput(4, a + 4, readDataArray);
						cpu = trp.readDataInput(a + 4, readDataArray.length, readDataArray);
						existingData = false;
						System.out.println(saveDataFile.delete());

						// 最初からの場合は何もせず開始
					} else if (chackDataFile.equalsIgnoreCase("n")) {
						System.out.println("最初からゲームを始めます。");
					} else {
						System.out.println("y,nのどちらかを入力して下さい");
					}
				} while (!(chackDataFile.equalsIgnoreCase("y") || chackDataFile.equalsIgnoreCase("n")));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (existingData) {
			// デッキ生成
			deck = trp.makeDeck(deck.length);

			// カードをシャッフル
			trp.shuffle();

			// シャッフルした結果をお互いの手札へ
			int pleyerCount = 0; // playerの枚数カウンター
			int cpuCount = 0;    // cpuの枚数カウンター
			
			for (int i = 0; i < deck.length; i++) {
				if (i % 2 == 0) {
					player[pleyerCount] = deck[i];
					pleyerCount++;
				} else if (i % 2 == 1) {
					cpu[cpuCount] = deck[i];
					cpuCount++;
				}
			}
		}

		//ゲームを開始する
		String inputX = null;
		while (gameCount < player.length & gameCount < cpu.length) {
			System.out.printf("◆第%d回戦\r\n", gameCount + 1);
			String pl_suit = player[gameCount].getSuit();
			String cp_suit = cpu[gameCount].getSuit();
			String pl_num = trp.cardNumChange(player[gameCount].getNum());
			String cp_num = trp.cardNumChange(cpu[gameCount].getNum());
			System.out.printf("%d枚目の手札を出しますか？\r\n[出す:d  中断:q]\r\n", gameCount + 1);
			try {
				inputX = scan();
				if (inputX.equalsIgnoreCase("Q")) {
					break;
				} else if (!(inputX.equalsIgnoreCase("D") || inputX.equalsIgnoreCase("Q"))) {
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

		//手札が無くなった場合結果を発表する
		if (gameCount == player.length || gameCount == cpu.length) {
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
			System.out.println("今回の結果を登録します");
			File gameResult = new File("c:\\CodeCamp\\game_result.csv");
			BufferedWriter out;

			try {
				int inputGameCount = 0;
				int inputWinCount = 0;
				int inputWinCard = 0;
				if (gameResult.exists()) {
					System.out.println("上書きするファイルが見つかりました");
					String result;
					int count = 0;
					BufferedReader in = Files.newBufferedReader(Paths.get("c:\\CodeCamp\\game_result.csv"));
					while ((result = in.readLine()) != null) {
						String[] rstGame = result.split(",");
						if(count ==0){
							count++;
							continue;
						}
						inputGameCount = Integer.parseInt(rstGame[0]);
						inputWinCount = Integer.parseInt(rstGame[1]);
						inputWinCard = Integer.parseInt(rstGame[2]);
					}
				}

				out = Files.newBufferedWriter(Paths.get("c:\\CodeCamp\\game_result.csv"));
				out.write("ゲーム回数,あなたの勝利回数,あなたの最大獲得枚数");
				out.newLine();
				inputGameCount++;
				if (winCard > loseCard) {
					inputWinCount++;
					if (inputWinCard < winCard) {
						inputWinCard = winCard;
					}

				}
				out.write(String.format("%s,%s,%s", inputGameCount, inputWinCount, inputWinCard));

				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		//中断を選択された時、csvに保存
		} else if (inputX.equalsIgnoreCase("Q")) {
			System.out.println("中断しました");
			// 今の配列（player＆cpu）、gameCount、獲得カードと場のカードをセーブしたい
			BufferedWriter out;
			try {
				out = Files.newBufferedWriter(Paths.get("c:\\CodeCamp\\savedata.csv"));
				out.write(String.format("%s,%s,%s,%s,", winCard, drowCard, loseCard, gameCount));
				for (int i = 0; i < player.length; i++) {
					out.write(String.format("%s,%s,", player[i].getSuit(), player[i].getNum()));
				}
				for (int i = 0; i < cpu.length; i++) {
					out.write(String.format("%s,%s", cpu[i].getSuit(), cpu[i].getNum()));
					if (!(i == 12)) {
						out.write(",");
					}
				}
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("resource")
	public static String scan() {
		String inputX = new java.util.Scanner(System.in).nextLine();
		return inputX;
	}
}