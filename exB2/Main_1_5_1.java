package exB2;

public class Main_1_5_1 {
	public static void main(String[] args) {
		int hour = 7;
		int minute = 15;
		int second = 0;
		int milliSecond = 150;
		String message = "現在の時刻は" + hour + "時" + minute + "分" + second + "秒" + milliSecond + "です";
		System.out.println(message);

		int hour1 = scannerInt();
		String minute1 = scannerStr();
		int second1 = scannerInt();
		String milliSecond1 = scannerStr();
		String message1 = String.format("現在の時刻は%03d時%s分%d秒%sです", hour1, minute1, second1, milliSecond1);
		System.out.println(message1);
	}

	@SuppressWarnings("resource")
	public static String scannerStr() {
		String sc = new java.util.Scanner(System.in).nextLine();
		return sc;
	}

	@SuppressWarnings("resource")
	public static int scannerInt() {
		int ic = new java.util.Scanner(System.in).nextInt();
		return ic;
	}
}
