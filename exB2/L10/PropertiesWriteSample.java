package exB2.L10;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Properties;
 
/**
 * プロパティファイル書き込みサンプル。
 */
public class PropertiesWriteSample {
  /**
   * プロパティファイルの名前。
   * (環境に合わせて書き換えてください)
   */
  private static final String PROPERTIES_FILE = "c:\\CodeCamp\\sample2.properties";
 
  public static void main(String[] args) {
    User user = new User(1, "コード一郎", 25);
 
    try (
        Writer out = new FileWriter(PROPERTIES_FILE);) {
 
      Properties properties = new Properties();
 
      // プロパティをキー・値のペアでセットする。
      properties.setProperty("id", Integer.toString(user.getId()));
      properties.setProperty("name", user.getName());
      properties.setProperty("age", Integer.toString(user.getAge()));
 
      // プロパティファイルを保存
      properties.store(out, "プロパティファイルのテスト");
 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}