package warGame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Csv_data {

	// ※環境に応じて書き換えて下さい
	private final static String SAVE_DATA_FILE = "c:\\CodeCamp\\savedata.csv";
	private final static String GAME_RESULT_FILE = "c:\\CodeCamp\\game_result.csv";

	File saveDataFile = new File(SAVE_DATA_FILE); // 中断データ読み書き
	File gameResultFile = new File(GAME_RESULT_FILE); // ゲーム結果データ読み書き
	BufferedReader inputSaveData = null;

	public boolean existSaveData() {
		boolean saveData = false;
		if (saveDataFile.exists()) {
			saveData = true;
		}
		return saveData;
	}

	// 中断データ読み込みのメソッド
	public String[] interrupDataLording() {
		try {
			String[] readDataArray = null; // 読み込んできたデータを格納する。初めからの場合nullで返す
			System.out.println("[続きから始める:y  最初から始める:n]");
			String chackDataFile = scan();

			// 続きからの場合、csvから要素を取り出して内容に代入
			if (chackDataFile.equalsIgnoreCase("y")) {
				System.out.println("中断されたゲームを再開します。");
				inputSaveData = new BufferedReader(new FileReader(saveDataFile));
				String line = inputSaveData.readLine();
				readDataArray = line.split(",");
				inputSaveData.close();

				// 最初からの場合は何もせずnullで返す
			} else if (chackDataFile.equalsIgnoreCase("n")) {
				System.out.println("最初からゲームを始めます。");
			} else {
				throw new IOException();
			}
			return readDataArray;
		} catch (IOException e) {
			System.out.println("半角文字のy,nのどちらかを入力して下さい");
			return interrupDataLording();
		}
	}

	// ゲーム結果データ読み込み、書き込みのメソッド
	public void saveGameResult(int winCard, int loseCard) {
		BufferedWriter outputResultData;

		try {
			int inputGameCount = 0; // ゲームの総プレイ回数
			int inputWinCount = 0; // 総プレイ回数中に勝った回数
			int inputWinCard = 0; // 勝った中で獲得したカードの最大枚数

			if (gameResultFile.exists()) {
				System.out.println("上書きするファイルが見つかりました");
				String result;
				int count = 0;// インデックス(行送りしたいから)
				BufferedReader inputResultData = Files.newBufferedReader(Paths.get(GAME_RESULT_FILE));
				while ((result = inputResultData.readLine()) != null) {
					String[] rstGame = result.split(",");
					if (count == 0) {
						count++;
						continue;
					}
					// 読み込んだデータを代入していく
					inputGameCount = Integer.parseInt(rstGame[0]);
					inputWinCount = Integer.parseInt(rstGame[1]);
					inputWinCard = Integer.parseInt(rstGame[2]);
				}
				// とりあえず開放する
				inputResultData.close();
			}

			outputResultData = Files.newBufferedWriter(Paths.get(GAME_RESULT_FILE));
			outputResultData.write("ゲーム回数,あなたの勝利回数,あなたの最大獲得枚数");
			outputResultData.newLine();

			// ここは必ずで追加する
			inputGameCount++;

			// 勝利していたら(獲得枚数がCPUより多ければ)追加する
			if (winCard > loseCard) {
				inputWinCount++;

				// 勝っていてさらに今までより多い場合は追加する
				if (inputWinCard < winCard) {
					inputWinCard = winCard;
				}
			}
			outputResultData.write(String.format("%s,%s,%s", inputGameCount, inputWinCount, inputWinCard));
			outputResultData.close();
			System.out.println(GAME_RESULT_FILE + "に正常に保存されました\r\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 中断データを書き込むメソッド
	// 今の配列（player＆cpu）とgameCount、各々の手札枚数と獲得枚数、場のカードを保存する
	public void interrupDataWrite(int winC, int drowC, int loseC, int gameCnt, int plCard, int cpCard, Card player[],
			Card[] cpu) {
		BufferedWriter outputSaveData;
		try {
			outputSaveData = Files.newBufferedWriter(Paths.get(SAVE_DATA_FILE));
			outputSaveData.write(String.format("%s,%s,%s,%s,%s,%s,", winC, drowC, loseC, gameCnt, plCard, cpCard));
			for (int i = 0; i < player.length; i++) {
				outputSaveData.write(String.format("%s,%s,", player[i].getSuit(), player[i].getNum()));
			}
			for (int i = 0; i < cpu.length; i++) {
				outputSaveData.write(String.format("%s,%s", cpu[i].getSuit(), cpu[i].getNum()));
				if (!(i == 12)) {
					outputSaveData.write(",");
				}
			}
			outputSaveData.close();
			System.out.println(SAVE_DATA_FILE + "に正常に保存されました");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 中断データを削除するメソッド
	public void dalete() {
		if (saveDataFile.exists()) {
			System.out.print("中断データが見つかりました…");
			// deleteメソッドを使用してファイルを削除する
			if (saveDataFile.delete()) {
				System.out.println("削除されました");
			} else {
				// 閉じれていない場合
				System.err.println("削除できませんでした");
			}
		} else {
			System.out.println("中断データはありませんでした");
		}
	}

	@SuppressWarnings("resource")
	public String scan() {
		String inputX = new java.util.Scanner(System.in).nextLine();
		return inputX;
	}
}