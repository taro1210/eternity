package model;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
 
public class Rate implements Serializable {
  //フィールドの定義
  private static final long serialVersionUID = 1L;
  private List<Integer> rates;
 
  //引数なしコンストラクタ
  public Rate(){
    rates = new ArrayList<Integer>();
  }
 
  //getter（今までの評価値の平均を返す）
  public double getRating(){
    double sum = 0.0;
    if( rates.size() == 0 ){
      return 0.0;
    } else {
      for(int data : rates){
        sum = sum + data;
      }
      return sum / rates.size();
    }
  }
 
  //getter(評価件数を返す）
  public int getNumber(){
    return rates.size();
  }
 
  //setter(評価を追加）
  public void setRate(int value){
    //0から100まで有効とする
    if( value > -1  && value < 101 ){
      rates.add(value);
    }
  }
}