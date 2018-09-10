package exB2;

public class Main_1_2_4 {
	  public static void main(String[] args) {
	    String e = "  AbcdE";
	 
	    //小文字に変換する・大文字に変換する
	    System.out.println(e.toLowerCase());
	    System.out.println(e.toUpperCase());
	 
	    //前後の空白を取り除く
	    System.out.println(e.trim());
	 
	    //文字列の置き換え
	    System.out.println(e.trim().replace("Abc", "nsnsns").toUpperCase());
	  }
	}