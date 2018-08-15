package List14_4;

public class BookShelf{
Book[] bookShelf= new Book[5];/*本の配列 */
int index= 0; /* 本がつぎに入る本棚の位置（配列の添え字） */

/* コンストラクタ */
BookShelf(int maxsize){
}


//本の追加
int i=0;
public Book hontuika(){
System.out.println("新しい書籍を追加しますか？[はい: yes いいえ: no / 本の確認:hon]");
String tuika=new java.util.Scanner(System.in).nextLine();
//yesの場合はtrueを返す
while(tuika.equals("yes")){
 System.out.print("書籍名を入力＞");
	String name=new java.util.Scanner(System.in).nextLine();
	System.out.print("価格を入力＞");
	String price=new java.util.Scanner(System.in).nextLine();
	System.out.print("著者名を入力＞");
	String author=new java.util.Scanner(System.in).nextLine();
	System.out.println("「書名:" + name +"/価格:" +price + "円/著者:" + author+"」を追加しました");
	System.out.println("登録完了しました。");
	System.out.println("===========================");
	System.out.println("");
	bookShelf[i] =hontuika();
	i++;
	System.out.println("繰り返し、書籍を追加しますか？[はい: yes いいえ: no]");
	String tuika2=new java.util.Scanner(System.in).nextLine();
	if(tuika2.equals("yes")){
		continue;
	}
		if(i>=4){
			System.out.println("これ以上追加できません。");
			break;
		}
		if(bookShelf[i].equals (bookShelf[i])){
			System.out.println("同じ本は登録できません。");
			break;
		}
	System.out.println("終了します。");
	break;
}
//noの場合はfalseを返す
if(tuika.equals("no")){
	System.out.println("終了します。");
}
//honの場合は本の確認を返す
if(tuika.equals("hon")){
	System.out.println("現在登録している本");
	System.out.println(bookShelf[i]);
}
return hontuika();
}
}