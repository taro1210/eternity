package List14_4_3;

public class BookShelf {

	public Book hon;
	Book[]hondana;

	//本の追加
	public void tuika() {
		System.out.print ( "書籍名を入力＞" );
			String name = new java.util.Scanner (System.in) .nextLine();
		System.out.print ( "価格を入力＞" );
			int price = new java.util.Scanner (System.in) .nextInt();
		System.out.print ( "著者名を入力＞" );
			String author = new java.util.Scanner (System.in) .nextLine();
		Book hon = new Book (name,price,author);
		System.out.println ( hon+"を追加します。" );
	}

	public void check() {
		for(int i=0; i<hondana.length; i++) {
			if(hondana[i] != null){
				if ( i >= hondana.length ) {
					full ();
					break;
				} else if (hon.name.equals (hondana[i].name) &&
					hon.price == (hondana[i].price) &&
					hon.author.equals (hondana[i].author)) {
					System.out.println ("同じ書籍は追加できません。");
					break;
				} else {
					hondana[i] = hon;
					i++;
					System.out.println ( "マイ本棚の"+i+"番目に追加完了しました。" );
					break;
				}
			}
		}
	}

	public void hyoji(){
		System.out.println("本を表示します。");
			for (int j = 0; j < hondana.length; j++)  {
				System.out.println(hondana[j]);
				end();
			}
	}

	public void  full(){
		System.out.println ( "これ以上追加できません。" );
			for (int j = 0; j < hondana.length; j++ )  {
				System.out.println ( hondana[j] );
				end();
			}
	}

	public  void end() {
		System.out.println ( "終了します。");
		System.out.println ("===========================");
	}
}