package exB2.L10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.InputMismatchException;
import java.util.Properties;

public class Kadai10 {
	private static final String PROPERTIES_FILE = "c:\\CodeCamp\\kadai10.properties";

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String set;
		String start;
		String mesegeBf;
		String mesegeAf;
		String finishBf;
		String finishAf;
		String finish0;
		String errer1 = null;
		String errer2 = null;
		int inputInt;
		int sumInput = 0;

		try (Reader reader = new FileReader(PROPERTIES_FILE);) {

			Properties properties = new Properties();
			properties.load(reader);
			set = properties.getProperty("set");
			start = properties.getProperty("start");
			mesegeBf = properties.getProperty("mesegeBf");
			mesegeAf = properties.getProperty("mesegeAf");
			finishBf = properties.getProperty("finishBf");
			finishAf = properties.getProperty("finishAf");
			finish0 = properties.getProperty("finish0");
			errer1 = properties.getProperty("errer1");
			errer2 = properties.getProperty("errer2");

			// 繰り返す回数を入力
			System.out.println(set);
			String inputMax = new java.util.Scanner(System.in).nextLine();
			if (inputMax.matches("0\\d+") || inputMax.matches("-\\d+")) {
				throw new InputMismatchException();
			}
			if (!inputMax.matches("\\d+")) {
				throw new InputMismatchException();
			} else {
				inputInt = Integer.parseInt(inputMax);
			}

			// 入力させた回数繰り返す。
			for (int i = 0; i < inputInt;) {
				System.out.println(start);
				String inputX = new java.util.Scanner(System.in).nextLine();
				if ("q".equalsIgnoreCase(inputX)) {
					if (sumInput <= 0) {
						end(finish0);
						break;
					} else {
						end(sumInput, finishBf, finishAf);
						break;
					}
				} else {
					if (inputX.matches("0\\d+") || inputX.matches("-\\d+")) {
						System.err.println(errer2);
						continue;
					}
					if (!inputX.matches("\\d+")) {
						throw new InputMismatchException();
					}

					// 文字列を数値に変換
					int inputValue = Integer.parseInt(inputX);
					if (inputValue < 1 | inputValue > 10) {
						System.err.println(errer2);
						continue;
					}
					// 正常の場合、出力
					System.out.println(mesegeBf + inputValue + mesegeAf);
					sumInput = sumInput + inputValue;
					i++;
					if (i == inputInt) {
						end(sumInput, finishBf, finishAf);
						break;
					}

				}
			}
		} catch (InputMismatchException e) {
			System.err.println(errer1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	public static void end(int sumInput, String finishBf, String finishAf) {
		System.out.println(finishBf + sumInput + finishAf);
	}

	public static void end(String finish0) {
		System.out.println(finish0);
	}
}