package model;

public enum Gender {
  Female("女"),  Male("男");

  private String text;
  //コンストラクタ
  private Gender(String text){
    this.text = text;
  }
  public String toString() {
    return this.text;
  }
}