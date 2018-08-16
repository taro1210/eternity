package List14_4_3;

public class BookShelf{

//本の追加
Book[]hondana=new Book[10];
int index=0;
int x=0;

public void end(){
	System.out.println("終了します。");
}

public void hontuika(){
System.out.println("書籍を追加しますか？[はい: yes いいえ: no ]");
String tuika=new java.util.Scanner(System.in).nextLine();
	if(tuika.equals("yes")){
		tuika();
	}else{

	}
}

public void tuika(){
		System.out.print("書籍名を入力＞");
		 String name=new java.util.Scanner(System.in).nextLine();
		 System.out.print("価格を入力＞");
		int price=new java.util.Scanner(System.in).nextInt();
		System.out.print("著者名を入力＞");
		 String author=new java.util.Scanner(System.in).nextLine();
		 Book hon=new Book(name,price,author);
		 System.out.println(hon+"を追加します。");

		 for(int i=0; i<hondana.length; i++){
			 if(hondana[i] != null){
					if (hon.name.equals(hondana[i].name) &&
							 hon.price==(hondana[i].price) &&
							 hon.author.equals(hondana[i].author)){
				 System.out.println("同じ本の登録は出来ません。");
				 tuika2();
				 }
		 }
		 }
		 hondana[x]=hon;
		 x++;
		 System.out.println("マイ本棚の"+x+"番目に追加完了しました。");
		 if(x>=5){
		 ippai();
		 }else{
		 tuika2();
		 }
}
public void tuika2(){
		System.out.println("続けて書籍を追加しますか？[はい: yes いいえ: no / 確認：ch]");
			String tuika2=new java.util.Scanner(System.in).nextLine();
			if(tuika2.equals("yes")){
				tuika();
			}else if(tuika2.equals("ch")){
				hyoji();
			}else{

			}
		}

public void hyoji(){
		System.out.println("本を表示します。");
		if(hondana[0] != null){
		System.out.println(hondana[0]);
		}
		if(hondana[1] != null){
		System.out.println(hondana[1]);
		}
		if(hondana[2] != null){
		System.out.println(hondana[2]);
		}
		if(hondana[3] != null){
		System.out.println(hondana[3]);
		}
		if(hondana[4] != null){
		System.out.println(hondana[4]);
		}
		System.out.println("===========================");
		System.out.println("");
		end();
}

public void ippai(){
		System.out.println("これ以上追加できません。");
		System.out.println(hondana[0]);
		System.out.println(hondana[1]);
		System.out.println(hondana[2]);
		System.out.println(hondana[3]);
		System.out.println(hondana[4]);
		System.out.println("===========================");
		System.out.println("");
		end();
		}
}