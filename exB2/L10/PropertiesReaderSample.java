package exB2.L10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

/**
 * プロパティファイル読み込みサンプル
 */
public class PropertiesReaderSample {
  /**
   * プロパティファイルの名前。
   * (環境に合わせて書き換えてください)
   */
  private static final String PROPERTIES_FILE = "c:\\CodeCamp\\sample.properties";

  public static void main(String[] args) {
    try (
        Reader reader = new FileReader(PROPERTIES_FILE);) {

      Properties properties = new Properties();
      properties.load(reader);

      String id = properties.getProperty("id");
      String name = properties.getProperty("name");
      String age = properties.getProperty("age");

      User user = new User(Integer.parseInt(id), name, Integer.parseInt(age));
      System.out.println(user);

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}