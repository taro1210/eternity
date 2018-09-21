package exB2.L10;

import java.io.File;

import javax.xml.bind.JAXB;
 
/**
 * JAXBを利用してXMLファイルを読み書きするサンプル。
 */
public class JAXBReadWriteSample {
 
  /**
   * XMLファイルの名前。
   * (環境に合わせて書き換えてください)
   */
  private static final String XML_FILE = "c:\\CodeCamp\\sample.xml";
 
  public static void main(String[] args) {
 
    File file = new File(XML_FILE);
 
    // XMLに書き込むための初期データを準備
    UserList initialData = new UserList(User.getUserData());
    System.out.println("【初期データ】");
    User.printUserList(initialData.getUsers());
 
    // userListインスタンスのデータをXMLファイルに出力。
    JAXB.marshal(initialData, file);
 
    // XMLファイルを読み込んで loadedData インスタンスを取得
    UserList loadedData = JAXB.unmarshal(file, UserList.class);
 
    // XMLから読み込んだデータを表示
    System.out.println();
    System.out.println("【XMLファイルから読み込んだデータ】");
    User.printUserList(loadedData.getUsers());
  }
 
}