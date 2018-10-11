package model;

import java.io.Serializable;

public class UserBean implements Serializable {
  // privateフィールドの定義
  private static final long serialVersionUID = 1L;
  private String firstName; // 名
  private String lastName; // 姓
  private int age; // 年齢
  private Gender gender; // 性別

  // 引数なしコンストラクタの定義
  public UserBean() {
  }

  // getterメソッド
  // fullNameプロパティ（読み取り用）
  public String getFullName() {
    return this.lastName + " " + this.firstName;
  }

  // minorityプロパティ（読み取り用）
  public boolean isMinority() {
    return this.age < 20;
  }

  public int getAge() {
    return this.age;
  }

  // maleプロパティ（読み取り用）
  public boolean isMale() {
    return this.gender.equals(Gender.Male);
  }

  // setterメソッド
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }
}