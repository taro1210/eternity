package exB2;

public class Main_1_4_2 {
	public static void main(String[] args) {
		// チェック対象の文字列.matches(正規表現);

		System.out.println("1".matches("\\d")); 	// true
		System.out.println("a".matches("\\w")); 	// true
		System.out.println("あ".matches("\\W")); 	// true
		System.out.println("Javあ".matches("Jav."));// true
		System.out.println("Jav".matches("Jav"));
		System.out.println("Jav".equals("Jav"));	// true
		System.out.println("");
		System.out.println("");

		System.out.println("Javaaaa".matches("aho+")); // false
		System.out.println("Java".matches("Java*"));   // true
		System.out.println("Jav".matches("Java*"));    // true
		System.out.println("Jav".matches("Javaaa*"));  // false?

		// 意味：「a」が5回繰り返されているか
		System.out.println("aaaaa".matches("a{5}")); // true
		String a = "aaaaaaaaaaaaaaa";
		System.out.println(a.matches("a{a.length()}")); // Errer

		// 意味：数字2回、ハイフン、数字4回、ハイフン、数字が4回か
		System.out.println("03-1234-5678".matches("\\d{2}-\\d{4}-\\d{4}")); // true
	}
}