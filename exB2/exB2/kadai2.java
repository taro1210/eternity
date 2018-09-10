package exB2;

import java.util.Calendar;

public class kadai2 {

	public static void main(String[] args) {
		int year;
		int month;

		kadai2sub kd = new kadai2sub();
		System.out.println("年を入力（1900～2100）: ");
		year = kd.inputY();
		//月の入力
		System.out.println("月を入力（1～12）: ");
		month = kd.inputM();

		System.out.println(year + "年" + month + "月");
		System.out.println(" 日 月 火 水 木 金 土");

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DATE, 1);

		// その月の最終日
		int max_day = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 1日の曜日
		int start_index = cal.get(Calendar.DAY_OF_WEEK);
		for (int i = 1; i < start_index; i++) {
			System.out.printf("%3s", ""); // 1週目の1日までを空白で埋める
		}

		for (int i = 1; i <= max_day; i++) {
			System.out.printf("%3d", i);
			cal.set(Calendar.DATE, i);
			if (Calendar.SATURDAY == cal.get(Calendar.DAY_OF_WEEK)) {
				System.out.println("");
			}
		}
	}

}
