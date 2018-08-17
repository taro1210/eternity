package Lise15_8;

import java.io.StreamCorruptedException;

public class Main {
	public static void main ( String [] args) {
		String errerMesege=new String();
		System.out.print("数値データを入力してください>");
		try {
		int imputval=new java.util.Scanner(System.in).nextInt();

		  if ( imputval < 0) {
			throw  new 	StreamCorruptedException ( errerMesege="入力されたデータが下限値をを下回っています。​");

		} if ( imputval > 9) {
			throw  new 	StreamCorruptedException ( errerMesege="入力されたデータが上限値をを上回っています。​");
		}
		System.out.print("正常に処理が行われました");
		} catch ( java.util.InputMismatchException e ) {
			System.out.println("半角数字1桁を入力して下さい");

		} catch ( 	StreamCorruptedException e ) {
			System.out.println(errerMesege);
		}
	}
}

