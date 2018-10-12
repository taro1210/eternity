package model;

import java.io.Serializable;

public class ShoppingCart implements Serializable{
  //フィールドの定義
  private static final long serialVersionUID = 1L;
  private Product product;  //商品
  private int count;  //数量

  //引数なしコンストラクタ
  public ShoppingCart(){

  }

  //getter,setter
  public Product getProduct() {
    return product;
  }
  public void setProduct(Product product) {
    this.product = product;
  }
  public int getCount() {
    return count;
  }
  public void setCount(int count) {
    this.count = count;
  }
}