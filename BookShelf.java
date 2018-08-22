package List14_4_3;

public class BookShelf {

	//Book hon;
	//Book[]hondana;

	//本の追加
	public Book tuika() {
		System.out.print ( "書籍名を入力＞" );
			String name = new java.util.Scanner (System.in) .nextLine();
		System.out.print ( "価格を入力＞" );
			int price = new java.util.Scanner (System.in) .nextInt();
		System.out.print ( "著者名を入力＞" );
			String author = new java.util.Scanner (System.in) .nextLine();
		Book hon = new Book (name,price,author);
		return hon;
	}

	public boolean check (Book hon, Book hondana[]) {
		boolean B = false;
		for (int i = 0; i < hondana.length; i++) {
			if (hondana[i] != null){
				if (hon.equals (hondana[i])){
					System.out.println ( "同じ本は追加できません。" );
					B = true;
					break;
				} else {
					break;
				}
			}
		}
		return B;
	}

	public void hyoji (Book hondana[]) {
		System.out.println("本を表示します。");
			for (int j = 0; j < hondana.length; j++)  {
				System.out.println(hondana[j]);
			}
	}

	public void  full(Book hondana[]) {
		System.out.println ( "これ以上追加できません。" );
			for (int j = 0; j < hondana.length; j++ )  {
				System.out.println ( hondana[j] );
				end();
			}
	}

	public void input(Book hondana[]) {

		System.out.println ("続けて書籍を追加しますか？[はい: yes いいえ: no / 確認：ch]" );
			String tuika2 = new java.util.Scanner (System.in) .nextLine();
			if (tuika2.equals("yes")) {
				tuika();
			} else if (tuika2.equals("ch")) {
				hyoji ( hondana );
			} else {
			}
	}

	public void end() {
		System.out.println ( "終了します。");
		System.out.println ("===========================");
	}
}