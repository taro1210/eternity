package exB2;

public class Main_1_2_2 {
	public static void main(String[] args) {
		String c = "JavaScript";

		// 文字列の中に、引数で指定した文字列が含まれるか調べる
		if (c.contains("vaSc")) {
			System.out.println("contains true");
		} else {
			System.out.println("contains false");
		}

		// 引数で指定した文字列で始まるか調べる
		if (c.startsWith("Jav")) {
			System.out.println("startsWith true");
		} else {
			System.out.println("startsWith false");
		}

		// 引数で指定した文字列が、先頭から何文字目に出現するか調べる
		System.out.print("アルファベット1文字入力＞");
		@SuppressWarnings("resource")
		String target = new java.util.Scanner(System.in).nextLine();
		System.out.print("「" + target + "」は");
		int i = c.indexOf(target);
		//System.out.println(i);
		if (i < 0) {
			System.out.println("存在しません。");
		} else {
			System.out.println(i + 1 + "文字目に出現します。");
		}
	}
}