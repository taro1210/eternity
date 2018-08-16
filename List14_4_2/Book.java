package List14_4_2;

class Book{ 
String name; // 書名 
String author; // 著者 
String publisher; // 出版社 

/* コンストラクタ */ 
Book(String name, String author, String publisher){ 
this.name = name; 
this.author = author; 
this.publisher = publisher; 
System.out.println("本を作成しました。"); 
} 

/* 本の文字列化 */ 
public String toString(){ 
return("書名:" + name + " 、" + "著者:" + author + 
" 、" + " 出版社:" + publisher + "です。"); 
} 
} 
