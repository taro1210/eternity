package model;

import java.io.Serializable;

public class Product implements Serializable{
  //フィールドの定義
  private static final long serialVersionUID = 1L;
  private String id; //商品ID
  private String name; //商品名
  private int price; //単価

  //引数なしコンストラクタ
  public Product(){}

  //引数を3つ指定したコンストラクタ
  public Product(String id, String name, int price){
    this.id = id;
    this.name = name;
    this.price = price;
  }

  //getter,setterメソッド
  public String getId() {
    return id;
  }
  public String getName() {
    return name;
  }
  public int getPrice() {
    return price;
  }
}