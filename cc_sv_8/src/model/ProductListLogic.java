package model;

import java.util.ArrayList;
import java.util.List;

public class ProductListLogic {
  private String[][] product = {
      { "F-01", "りんご", "100" },
      { "F-02", "みかん", "80" },
      { "F-03", "バナナ", "120" },
      { "F-04", "パイナップル", "300" },
      { "F-05", "ぶどう", "320" },
      { "F-06", "グレープフルーツ", "400" },
      { "F-07", "キウイ", "200" },
      { "F-08", "もも", "150" },
      { "F-09", "なし", "170" },
      { "F-10", "メロン", "800" } };

  //全商品リストを返すメソッド
  public List<Product> getProductList() {
    List<Product> list = null;
    list = new ArrayList<Product>();
    for (int i = 0; i < product.length; i++) {
      list.add(
          new Product(product[i][0], product[i][1], Integer.parseInt(product[i][2])));
    }
    return list;
  }

  //引数で渡される商品IDで指定される商品を返すメソッド
  public Product getProduct(String product_id){
    Product item = null;
    for(int i = 0; i < product.length; i++){
      if( product_id.equals(product[i][0])){
        item = new Product(product[i][0], product[i][1], Integer.parseInt(product[i][2]));
        break;
      }
    }
    return item;
  }
}