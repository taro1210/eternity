package List14_4_3;

public class Main{
	public static void main(String[] args) {
		BookShelf bookShelf=new BookShelf();
		BookShelf hondana[] = new BookShelf[5];

		System.out.println("現在所持している本一覧========");
		System.out.println("所有している本はありません。");//本の数、確認

		System.out.println();
		System.out.println("===========================");

		//本の追加
		System.out.println("書籍を追加しますか？[はい: yes いいえ: no ]");
		String tuika=new java.util.Scanner(System.in).nextLine();
			if(tuika.equals("yes")){
				bookShelf.tuika();
			}else{
				bookShelf.end();
			}
			bookShelf .check();
			input();
	}

	public static void input() {
		BookShelf bookShelf=new BookShelf();
		System.out.println ("続けて書籍を追加しますか？[はい: yes いいえ: no / 確認：ch]" );
			String tuika2 = new java.util.Scanner (System.in) .nextLine();
			if (tuika2.equals("yes")) {
				bookShelf.tuika();
			} else if (tuika2.equals("ch")) {
				bookShelf .hyoji();
			} else {
				bookShelf.end();
			}
	}
}
