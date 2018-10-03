package exB2.L06;

import java.util.Arrays;
import java.util.List;

public class kadai6_ouyou {
	public static String text = "There are, of course, many motivating factors in human behavior, but we would"
			+ "claim that nationalism is particularly worthy of study. Why is it particularly"
			+ "significant? (1)Its significance lies in its power to arouse passionate"
			+ "loyalties and hatreds that motivate acts of extreme violence and courage;"
			+ "people kill and die for their nations. Of course it is not alone in this:"
			+ "people are driven to similar extremes to protect their families, their"
			+ "extended families or 'tribes,' their home areas with their populations, and"
			+ "their religious groups and the holy places and symbols of their religions."
			+ "However, these other loyalties are often rather ( a ) to understand than"
			+ "nationalism. Parents making supreme sacrifices for their children can be seen"
			+ "( b ) obeying a universal law in life forms, the instinct to protect one's own"
			+ "genetic material. This instinct can also be seen at work in the urge to protect"
			+ "one's extended family; but then the extended family, or on a slightly larger"
			+ "scale the 'tribe,' can also be seen, in perhaps the majority of circumstances"
			+ "in which human beings have existed, ( c ) essential for the survival of the"
			+ "individual and of the nuclear family. The nation is not generally essential"
			+ "to survival in this way. Of course, if the entire nation were to be wiped out,"
			+ "the individuals and their families would die, but the ( d ) of the nation as"
			+ "a social unit would not in itself pose a threat to individual or family"
			+ "survival; (2)only if it were to be accompanied by ethnic violence or severe"
			+ "economic collapse would it be life-threatening, and such disastrous events are"
			+ "not an inevitable consequence of the loss of political independence."
			+ "Conversely, there is no logical connection between the gaining of political"
			+ "independence by a subject nation and increased life chances for its citizens."
			+ "In many, perhaps the vast majority, of modern nations there is likewise no"
			+ "evidence that in defending the nation one is defending one's own genetic"
			+ "material; the notion that the citizens of modern nations are kinsfolk, while"
			+ "the citizens of (potentially) hostile neighbors are aliens, makes no sense in"
			+ "view of the highly varied genetic make-up of most modern populations.";

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		List<String> split = Arrays.asList(text.replace("-", "_").split("\\W"));
		System.out.println("現在文章中に" + split.size() + "語あります");
		System.out.print("何文字以上の文字を検索しますか？(重複あり)>");
		int inputX = new java.util.Scanner(System.in).nextInt();
		long i = nobelCount(split, inputX);
		if (i <= 0) {
			System.out.println("文章中に" + inputX + "文字以上の単語はありません。");
		} else {
			System.out.println("文章中に" + inputX + "文字以上の単語は" + i + "語あります。");
			System.out.println("***************************************\r\n");
		}
		split.stream().filter(novel -> novel.length() >= inputX)
				// .distinct() …重複を無くしたいとき
				.forEach(novel -> System.out.println("[" + novel.replace("_", "-") + "]:文字数:" + novel.length()));
	}

	public static long nobelCount(List<String> split, int inputX) {
		return split.stream().filter(novel -> novel.length() >= inputX).count();
	}
}