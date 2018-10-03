package exB2.L02;

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
		//System.out.println(" 日 月 火 水 木 金 土");

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DATE, 1);

		// その月の最終日
		int max_day = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 1日の曜日
		int start_index = cal.get(Calendar.DAY_OF_WEEK);
		for (int i = 1; i < start_index; i++) {
			System.out.printf("%3s", "       "); // 1週目の1日までを空白で埋める
		}

		for (int i = 1; i <= max_day; i++) {
			System.out.printf("%3d", i);
			cal.set(Calendar.DATE, i);
			if(Calendar.SUNDAY == cal.get(Calendar.DAY_OF_WEEK)){
				System.out.print("(日)");
			}else if(Calendar.MONDAY == cal.get(Calendar.DAY_OF_WEEK)){
				System.out.print("(月)");
			}else if(Calendar.TUESDAY == cal.get(Calendar.DAY_OF_WEEK)){
				System.out.print("(火)");
			}else if(Calendar.WEDNESDAY == cal.get(Calendar.DAY_OF_WEEK)){
				System.out.print("(水)");
			}else if(Calendar.THURSDAY == cal.get(Calendar.DAY_OF_WEEK)){
				System.out.print("(木)");
			}else if(Calendar.FRIDAY == cal.get(Calendar.DAY_OF_WEEK)){
				System.out.print("(金)");
			}else if (Calendar.SATURDAY == cal.get(Calendar.DAY_OF_WEEK)) {
				System.out.print("(土)");
				System.out.println("");
			}
		}
	}

}
