package exB2;

public class Main_1_4_6 {
	public static void main(String[] args) {
		String testText = "Lorem ipsum dolor sit amet,aliquip malorum omnesque sea at.";
		String[] split = testText.split("\\W"); // 英単語を構成する文字(a~z, A~Z, _)以外の文字で分割
		int counts = 0;
		System.out.print("アルファベット1文字入力＞");
		@SuppressWarnings("resource")
		String target = new java.util.Scanner(System.in).nextLine();
		for (String string : split) {
			int i = string.indexOf(target);
			if (i >= 0) {
				System.out.print(string + ":");
				System.out.print("「" + target + "」は");
				System.out.println(i + 1 + "文字目に出現します。");
				counts++;
			}
		}
		if (counts == 0){
			System.out.print("該当なし。");
		}
	}
}