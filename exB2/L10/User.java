package exB2.L10;

import java.util.ArrayList;
import java.util.List;
 
/**
 * ユーザークラス。
 */
public class User {
  /**
   * ID
   */
  private int id;
 
  /**
   * 名前
   */
  private String name;
 
  /**
   * 年齢
   */
  private int age;
 
  /**
   * デフォルトコンストラクタ
   */
  public User() {
    super();
  }
 
  /**
   * コンストラクタ
   */
  public User(int id, String name, int age) {
    super();
    this.id = id;
    this.name = name;
    this.age = age;
  }
 
  @Override
  public String toString() {
    return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
  }
 
  public int getId() {
    return id;
  }
 
  public void setId(int id) {
    this.id = id;
  }
 
  public String getName() {
    return name;
  }
 
  public void setName(String name) {
    this.name = name;
  }
 
  public int getAge() {
    return age;
  }
 
  public void setAge(int age) {
    this.age = age;
  }
 
  /**
   * テスト用に User インスタンスの List を返す
   */
  public static List<User> getUserData() {
    List<User> result = new ArrayList<>();
 
    result.add(new User(1, "コード一郎", 25));
    result.add(new User(2, "コード次郎", 21));
    result.add(new User(3, "コード華子", 22));
    result.add(new User(4, "寺田翔太朗", 27));
 
    return result;
  }
 
  /**
   * User の List を画面表示する
   */
  public static void printUserList(List<User> list) {
    for (User user : list) {
      System.out.format("[%2d] %-8s\t%2d 歳%n", user.getId(), user.getName(), user.getAge());
    }
 
  }
}