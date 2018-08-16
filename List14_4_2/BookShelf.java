package List14_4_2;

class BookShelf{ 
Book[] bookShelf; /* 本棚のデータ構造 ここでは本の配列 */ 
int index; /* 本がつぎに入る本棚の位置（配列の添え字） */ 

/* コンストラクタ */ 
BookShelf(int maxsize){ 
bookShelf = new Book[maxsize]; 
index = 0; 
} 

/* 本棚に本aBook を入れる */ 
void add(Book aBook){ 
// 修正 START 
if(this.bookShelf.length > index) { 
bookShelf[index] = aBook; 
index++; 
}else{ 
System.out.println("本棚に本を追加できません。") ; 
} 
// 修正 END 
} 

void show(){ 
this.toString(); 
} 

/* 本棚の文字列化 */ 
public String toString(){ 
String ret = ""; 

for(int i=0;i<index;i++){ 
ret += (i+1) + "冊目の本は" + bookShelf[i].toString() +"\n" ; 
} 

return ret; 
} 
} 