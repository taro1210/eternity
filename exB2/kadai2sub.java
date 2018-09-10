package exB2;

import java.io.StreamCorruptedException;
import java.util.InputMismatchException;

public class kadai2sub {

	@SuppressWarnings("resource")
	public int inputY() {
		int year = 0;
		// 年の入力
		try {
			String inputYear = new java.util.Scanner(System.in).nextLine();
			if (inputYear.matches("0\\d+")) {
				throw new StreamCorruptedException();
			}
			if (!inputYear.matches("\\d+")) {
				throw new java.util.InputMismatchException();
			}
			year = Integer.parseInt(inputYear);
			if (year < 1900) {
				throw new StreamCorruptedException();
			}
			if (year > 2100) {
				throw new StreamCorruptedException();
			}
			return year;
		} catch (InputMismatchException e) {
			System.out.println("文字うつなボケ");
			return inputY();
		} catch (StreamCorruptedException e) {
			System.out.println("1900～2100の間で打たんかい");
			inputY();
			return inputY();
		}
	}

	@SuppressWarnings("resource")
	public int inputM() {
		int month = 0;
		try {
			String inputMonth = new java.util.Scanner(System.in).nextLine();
			if (inputMonth.matches("0\\d+")) {
				throw new StreamCorruptedException();
			}
			if (!inputMonth.matches("\\d+")) {
				throw new java.util.InputMismatchException();
			}
			month = Integer.parseInt(inputMonth);
			if (month < 1) {
				throw new StreamCorruptedException();
			}
			if (month > 12) {
				throw new StreamCorruptedException();
			}
			return month;
		} catch (InputMismatchException e) {
			System.out.println("文字うつなボケ");
			return inputM();
		} catch (StreamCorruptedException e) {
			System.out.println("1～12の間で打たんかい");
			return inputM();
		}
	}

}
