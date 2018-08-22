package List14_4_3;

public class Main{
	public static void main(String[] args) {
		BookShelf bookShelf = new BookShelf();
		Book hondana[] = new Book[5];

		System.out.println ("現在所持している本一覧========");
		System.out.println ("所有している本はありません。");//本の数、確認

		System.out.println ();
		System.out.println ("===========================");

		//本の追加

		System.out.println ("書籍を追加しますか？[はい: yes いいえ: no ]");
			String tuika = new java.util.Scanner(System.in).nextLine();
			if (tuika.equals("yes")) {

			for (int i = 0; i < hondana.length; i++) {
				Book A = bookShelf.tuika();
				System.out.println ( A + "を追加します。" );
				boolean B = bookShelf.check ( A , hondana);
					if (B == false) {
						hondana[i] = A;
						System.out.println("マイ本棚の" + i++ + "番目に登録しました。");
					}
				System.out.println ("続けて書籍を追加しますか？[はい: yes いいえ: no / 確認：ch]" );
				String tuika2 = new java.util.Scanner (System.in) .nextLine();
					if (tuika2.equals("yes")) {
						continue;
					} else if (tuika2.equals("ch")) {
						bookShelf.hyoji ( hondana );
					} else {
						bookShelf.end();
						break;
					}
					if (i == 5) {
						bookShelf.full (hondana);
						break;
					}
			}
		}
	}
}

