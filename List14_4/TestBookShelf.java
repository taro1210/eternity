package List14_4;

public class TestBookShelf{
	public static void main(String[] args) {

		BookShelf bookShelf=new BookShelf(5);
		System.out.println("現在所持している本一覧========");

		//本の数、確認
		if(bookShelf.index==0){
			System.out.println("所有している本はありません。");
		}else{
			System.out.println(bookShelf.toString());
			System.out.println();
			System.out.println("===========================");
		}
		//本の追加
			bookShelf.hontuika();
		
	}
}
