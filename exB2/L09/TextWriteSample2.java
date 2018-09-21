package exB2.L09;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * テキストファイルの書き込みサンプル。
 */
public class TextWriteSample2 {

	/**
	 * 書き込むテキストファイルの名前。 (環境に合わせて書き換えてください)
	 */
	private static final String OUTPUT_FILE = "c:\\CodeCamp\\sample.txt";

	public static void main(String[] args) {
		try (
				// 出力するためにファイルを開く。
				// バッファリング出力をするためのI/Oストリームを利用。
				FileWriter fw = new FileWriter(OUTPUT_FILE);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw);
				) {

			// データを書き込む。
			for (int i = 0; i < 10; i++) {
				out.printf(i + 1 + "回目の恋が終わりました\r\n");
				if (i == 9) {
					out.print("僕は死にましぇん！！！");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}