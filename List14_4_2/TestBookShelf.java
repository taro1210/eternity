package List14_4_2;

public class TestBookShelf{ 
public static void main(String[] args) { 
/* 本棚の作成 */ 
BookShelf bookShelf = new BookShelf(2); 

// 追加 START 
// 本棚が空であるかの確認 
System.out.println("本棚の本の数: " + bookShelf.index) ; 

// 本を追加 
Book book1 = new Book("ぼっちゃん", "夏目漱石", "春陽堂"); 
bookShelf.add(book1) ; 

// 追加した本の情報を確認 
System.out.println("本棚に入っている本の情報") ; 
System.out.println(bookShelf.toString()) ; 

// 本を追加 
Book book2 = new Book("斜陽", "太宰治", "新潮社"); 
bookShelf.add(book2) ; 

// 追加した順に本が格納されているか確認 
System.out.println("本棚に入っている本の情報") ; 
System.out.println(bookShelf.toString()) ; 

// 規定数以上の本を追加できない事を確認 
System.out.println("規定数：" + bookShelf.bookShelf.length) ; 
Book book3 = new Book("容疑者xの献身", "東野圭吾", "文藝春秋"); 
bookShelf.add(book3) ; 
// 追加 END 
} 
} 