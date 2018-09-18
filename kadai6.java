package exB2;

import java.util.Arrays;
import java.util.List;

public class kadai6 {
	public static String text = "Alice was beginning to get very tired of sitting by "
			+ "her sister on the bank, and of having nothing to do: once or "
			+ "twice she had peeped into the book her sister was reading, but "
			+ "it had no pictures or conversations in it, `and what is the use "
			+ "of a book,\' thought Alice `without pictures or conversation?\'\n"
			+ "So she was considering in her own mind (as well as she could, "
			+ "for the hot day made her feel very sleepy and stupid), whether "
			+ "the pleasure of making a daisy-chain would be worth the trouble "
			+ "of getting up and picking the daisies, when suddenly a White "
			+ "Rabbit with pink eyes ran close by her.\nThere was nothing so "
			+ "very remarkable in that; nor did Alice think it so very much "
			+ "out of the way to hear the Rabbit say to itself, `Oh dear! "
			+ "Oh dear! I shall be late!\' (when she thought it over afterwards, "
			+ "it occurred to her that she ought to have wondered at this, but "
			+ "at the time it all seemed quite natural); but when the Rabbit "
			+ "actually took a watch out of its waistcoat-pocket, and looked "
			+ "at it, and then hurried on, Alice started to her feet, for it "
			+ "flashed across her mind that she had never before seen a rabbit "
			+ "with either a waistcoat-pocket, or a watch to take out of it, "
			+ "and burning with curiosity, she ran across the field after it, "
			+ "and fortunately was just in time to see it pop down a large " + "rabbit-hole under the hedge.";

	public static void main(String[] args) {
		List<String> split = Arrays.asList(text.replace("-", "_").split("\\W"));
		long i = nobelCount(split);
		System.out.println("文章中に10文字以上の文字は" + i + "語あります。");
		System.out.println("***************************************\r\n");
		split.stream()
		.filter(novel -> novel.length() >= 10)

		// .distinct() …重複を無くしたいとき
		.forEach(novel -> System.out.println("[" + novel.replace("_", "-") + "]:文字数:" + novel.length()));
	}

	public static long nobelCount(List<String> split) {
		return split.stream()
				.filter(novel -> novel.length() >= 10)
				.count();
	}
}