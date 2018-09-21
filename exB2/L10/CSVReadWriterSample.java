package exB2.L10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * CSVファイルの読み書きサンプル
 */
public class CSVReadWriterSample {
  /**
   * CSVファイルの名前
   * (環境に合わせて書き換えてください)
   */
  private static final String CSV_FILE = "c:\\CodeCamp\\sample.csv";

  public static void main(String[] args) {

    // ユーザーデータの準備
    List<User> users = User.getUserData();
    System.out.println("【初期データ】");
    User.printUserList(users);

    // CSVファイルの書き込み処理
    try (
        // CSVファイルを開いて、BufferedWriterを取得
        BufferedWriter out = Files.newBufferedWriter(Paths.get(CSV_FILE));) {

      // データをCSV形式で書き込み
      for (User user : users) {
        out.write(String.format("%s,%s,%s%n", user.getId(), user.getName(), user.getAge()));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    // CSVファイルの読み込み処理
    List<User> readData = new ArrayList<>();
    try (
        // CSVファイルを読み込みように開き、BufferedReaderを取得。
        BufferedReader in = Files.newBufferedReader(Paths.get(CSV_FILE));) {

      while (true) {
        // データを1行読み込む
        String line = in.readLine();
        if (line == null) {
          break;
        }

        // 読み込んだデータを「,」を区切りに分割
        String[] values = line.split(",");

        // 分割したデータをもとにして User インスタンスを作成
        User user = new User(Integer.parseInt(values[0]), values[1], Integer.parseInt(values[2]));

        // User インスタンスを List に追加
        readData.add(user);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    // CSVから読み込んだデータを表示
    System.out.println();
    System.out.println("【CSVファイルから読み込んだデータ】");
    User.printUserList(readData);
  }

}