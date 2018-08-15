package List14_4_3;

public class BookShelf{

Book book=new Book();

//本の追加
int index=0;
String[]hondana=new String[5];
public void hontuika(){
System.out.println("書籍を追加しますか？[はい: yes いいえ: no ]");

String tuika=new java.util.Scanner(System.in).nextLine();

//noの場合はfalseを返す
	if(tuika.equals("no")){
			System.out.println("終了します。");
			}

//yesの場合はtrueを返す
	if(tuika.equals("yes")){
		for(int i=0; i<hondana.length;){
		System.out.print("書籍名を入力＞");
		 String name=new java.util.Scanner(System.in).nextLine();
		Book.name=name;
		 System.out.print("価格を入力＞");
		int price=new java.util.Scanner(System.in).nextInt();
		 Book.price=price;
		System.out.print("著者名を入力＞");
		 String author=new java.util.Scanner(System.in).nextLine();
		Book.author=author;
		 System.out.println("「書名:" + name +"/価格:" +price + "円/著者:" + author+"」を追加しました");
		 System.out.println("登録完了しました。");
		 System.out.println("===========================");
		 System.out.println("");
		 hondana[i]="書名："+name+"/価格："+price+"円/著者："+author;
	//この↓から明日やる。
		 if(hondana[i].equals(hondana[i])){
		 		for(i=0; i<hondana.length; i++);
		 		System.out.println("同じ書籍は追加できません。");
				break;
		 }
		 i++;
			System.out.println("本棚の"+i+"番目に入れました");
			System.out.println("続けて書籍を追加しますか？[はい: yes いいえ: no / 確認：ch]");
				String tuika2=new java.util.Scanner(System.in).nextLine();
				//noの場合はfalseを返す
				if(tuika2.equals("no")){
					System.out.println("終了します。");
					break;
				}
				if(tuika2.equals("ch")){
					System.out.println("本を表示します。");
					System.out.println(hondana[0]);
					System.out.println(hondana[1]);
					System.out.println(hondana[2]);
					System.out.println(hondana[3]);
					System.out.println(hondana[4]);
					break;
				}

				if(i==5){
					System.out.println("これ以上追加できません。");
				}
			}
		}
	}
}
