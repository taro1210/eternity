package exB2;

import java.util.Arrays;
import java.util.Comparator;

class Person {
	private int number;
	private String name;
	private int age;

	public Person(int number, String name, int age) {
		this.number = number;
		this.name = name;
		this.age = age;
	}

	public int getNumber() {
		return this.number;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	@Override
	public String toString() {
		return "社員番号:" + this.number + "\t氏名:" + this.name + "\t年齢:" + this.age + "歳";
	}
}

public class kadai4 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Person people[] = { new Person(9,"橋内 公一", 43),
							new Person(7,"奥谷 保夫", 41),
							new Person(3,"市岡 貢一", 48),
							new Person(4,"春田 淳", 52),
							new Person(5,"伊藤 太郎", 35),
							new Person(6,"朝倉 啓之", 45),
							new Person(11,"安部倉 敬", 33),
							new Person(8,"木下 芳隆", 38),
							new Person(2,"青木 直人", 58),
							new Person(1,"山本 昌久", 50),
							new Person(10,"難波江豪人", 42),
							new Person(13,"綾野 翔太", 27),
							new Person(12,"板本 豊", 28),
							new Person(14,"石川 怜治", 25),
							new Person(15,"小谷 陽亮", 28),
							new Person(16,"寺田翔太朗", 27),
							};
		System.out.print("ソートする基準を選んでください");
		System.out.print("[1:社員番号(昇順) 2:社員番号(降順) 3:社員名(昇順) 4:社員名(降順) 5:年齢(降順)  9:終了]＞ ");
		int inputX = new java.util.Scanner(System.in).nextInt();
		switch(inputX){
		case 1:
			Arrays.sort(people, Comparator.comparing(Person::getNumber));
			System.out.println("社員番号(昇順)で表示します********");
			break;
		case 2:
			Arrays.sort(people, Comparator.comparing(Person::getNumber).reversed());
			System.out.println("社員番号(降順)で表示します********");
			break;
		case 3:
			Arrays.sort(people, Comparator.comparing(Person::getName));
			System.out.println("社員名(昇順)で表示します********");
			break;
		case 4:
			Arrays.sort(people, Comparator.comparing(Person::getName).reversed());
			System.out.println("社員名(降順)で表示します********");
			break;
		case 5:
			Arrays.sort(people, Comparator.comparing(Person::getAge).reversed());
			System.out.println("年齢(降順)で表示します********");
			break;
		}
		
		if(inputX<6 && inputX>0)
		for (Person A : people) {
			System.out.println(A);
		}else{
			System.out.println("終了します********");
		}
		
	}
}