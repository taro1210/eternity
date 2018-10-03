package exB2.L13;

import java.util.Scanner;

public class kadai13 {

	@SuppressWarnings("resource")
	public static void main(String args[]) {
		int i = 0;
		String str = "";
		do {
			i++;
			System.out.println("何か文字を入力してください！(eが入力されたら終了)");
			Thread showThread = new ShowThread();
			if (i == 1) {
				showThread.start();
			}
			Scanner scan = new Scanner(System.in);
			str = scan.next();
			System.out.println("入力文字は " + str + " です。");
		} while (!(str.equals("e")));
		System.out.println("入力ループは抜けました。");

	}
}

class ShowThread extends Thread {
	public void run() {
		for (int i = 0; i <= 2; i++) {
			if (i == 1) {
				System.out.println("1〜100の番号を同時に表示しています。");
			} else if (i == 2) {
				for (int j = 1; j <= 100; j++) {
					//if (j < 10) {
						//System.out.print(" ");
					//}
					//String str = String.format("%2s", Integer.toString(j));
					System.out.printf("%3s", Integer.toString(j));
					if (j % 10 == 0) {
						System.out.print("\r\n");
					}
				}
			} else {
				System.out.print("これはスレッドテストです。");
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}
		System.out.println("スレッドの実行が終了しました。");
	}

}