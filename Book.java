package List14_4_3;

class Book{
String name; // 書名
int price; // 著者
String author; // 著者

Book(String name, int price, String author){
	this.name=name;
	this.price=price;
	this.author=author;
}
public String toString(){
return ("「書名:" + name +"/価格:" +price + "円/著者:" + author+"」");
}
}