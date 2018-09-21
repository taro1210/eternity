package exB2.L09;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
 
/**
 * テキストファイルの読み込みサンプル(java.uti.stream.Streamを利用)。
 */
public class TextReadWithStreamSample {
 
  /**
   * 読み込むテキストファイルの名前。
   * (環境に合わせて書き換えてください)
   */
  private static final String INPUT_FILE = "c:\\CodeCamp\\sample2.txt";
 
  public static void main(String[] args) {
    try (
 
        // テキストファイルを開き、読み込み用のStreamを生成。
        Stream<String> stream = Files.lines(Paths.get(INPUT_FILE));) {
 
      // Streamからデータを読み込み、そのまま画面に表示。
      stream.forEach(System.out::println);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}