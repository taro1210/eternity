package exB2.L10;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * ユーザーリスト
 */
public class UserList implements Serializable {

  private List<User> users;

  /**
   * 引数なしのコンストラクタ
   */
  public UserList() {
    super();
  }

  /**
   * コンストラクタ。
   */
  public UserList(List<User> users) {
    super();
    this.users = users;
  }

  // ※Userクラスの要素名をuserにするための調整
  @XmlElementWrapper
  @XmlElement(name = "user")
  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

}