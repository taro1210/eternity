/*<実施する処理>
①レベルが1のプレイヤーに、新人歓迎アイテム「応援旗」を追加する。
　ただしプレイヤーはアイテムを4個までしか所持できないので、
　すでにアイテムを4個所持している場合は、代わりに所持金に100Gを加算する。
②レベルが10以下のプレイヤーに、支度金として所持金に100Gを加算する。
③アイテム「鋼玉」を持っている場合は、「スペシャルソード」と交換する。
*/

package exB2.L09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

public class Kadai9 {

	private final static String inputCsvFile = "c:\\CodeCamp\\game_player.csv";
	private final static String outputCsvFile = "c:\\CodeCamp\\output.csv";

	public static void main(String[] args) {
		String line;
		ArrayList<String> csvArray = null;
		File inputFile = new File(inputCsvFile);
		File outputFile = new File(outputCsvFile);
		BufferedReader in = null;
		BufferedWriter out = null;
		boolean answer = true;
		System.out.println("◆◇◆◇作業を開始します。◆◇◆◇");
		try {
			if (!(inputFile.exists())) {
				throw new FileNotFoundException();
			} else if (outputFile.exists()) {
				answer = cheak();
			}
			if (answer) {
				int line_num = 0;
				in = new BufferedReader(new FileReader(inputFile));
				out = new BufferedWriter(new FileWriter(outputFile));
				while ((line = in.readLine()) != null) {
					csvArray = Lists.newArrayList(Splitter.on(',').split(line));
					line_num++;
					/*if (line_num == 0) {
						csvArray.set(0, "ID");
						csvArray.set(1, "名前");
						csvArray.set(2, "職業");
						csvArray.set(3, "レベル");
						csvArray.set(4, "所持金(G)");
						csvArray.set(5, "武器");
						csvArray.set(6, "防具");
						csvArray.set(7, "アイテム1");
						csvArray.set(8, "アイテム2");
						csvArray.set(9, "アイテム3");
						csvArray.set(10, "アイテム4");

					}*/
					if (line_num >= 1) {
						int lowLevel = Integer.parseInt(csvArray.get(3));
						// 新人歓迎アイテム「応援旗」を追加
						if (lowLevel == 1) {
							if (csvArray.get(8).equals("")) {
								csvArray.set(8, "応援旗");
							} else if (csvArray.get(9).equals("")) {
								csvArray.set(9, "応援旗");
							} else if (csvArray.get(10).equals("")) {
								csvArray.set(10, "応援旗");
							} else {
								int money = Integer.parseInt(csvArray.get(4));
								money = money + 100;
								csvArray.set(4, "" + Integer.toString(money));
							}
						}
						// 支度金として所持金に100Gを加算する
						if (lowLevel <= 10) {
							int money = Integer.parseInt(csvArray.get(4));
							money = money + 100;
							csvArray.set(4, "" + Integer.toString(money));
						}
						// 「鋼玉」を持っている場合は、「スペシャルソード」と交換
						for (int i = 7; i < csvArray.size(); i++) {
							if (csvArray.get(i).equals("鋼玉")) {
								csvArray.set(i, "スペシャルソード");
								break;
							}
						}
					}
					out.write(String.join(",", csvArray));
					out.newLine();
				}
				System.out.println("◆◇◆◇作業を完了しました。◆◇◆◇");
			} else {
				System.out.println("◆◇◆◇作業を中断します。◆◇◆◇");
			}
		} catch (FileNotFoundException e) {
			System.out.println("データが存在しないぞなもし");
		} catch (IOException | NumberFormatException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				System.out.println("close fail");
				e.printStackTrace();
			}
		}

	}

	@SuppressWarnings("resource")
	private static boolean cheak() {
		boolean answer;
		System.out.println("output.csvは存在します。上書きしますか？[Y/N]");
		String inputX = new java.util.Scanner(System.in).nextLine();
		if (inputX.equalsIgnoreCase("y")) {
			answer = true;
		} else if (inputX.equalsIgnoreCase("n")) {
			answer = false;
		} else {
			System.out.println("もう一度入力し直してください");
			return cheak();
		}
		return answer;
	}
}
