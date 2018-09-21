package exB2.L09;

import java.nio.file.Path;
import java.nio.file.Paths;
 
/**
 * Pathインタフェースのサンプル
 */
public class PathSample {
 
  private static final String TEST_PATH = "c:\\CodeCamp\\sample.txt";
 
  public static void main(String[] args) {
    // Pathインスタンスの取得
    Path path = Paths.get(TEST_PATH);
 
    // メソッドの実行結果を表示
    System.out.format("toString: %s%n", path.toString());
    System.out.format("getFileName: %s%n", path.getFileName());
    System.out.format("getName(0): %s%n", path.getName(0));
    System.out.format("getNameCount: %d%n", path.getNameCount());
    System.out.format("subpath(0,2): %s%n", path.subpath(0,2));
    System.out.format("getParent: %s%n", path.getParent());
    System.out.format("getRoot: %s%n", path.getRoot());
  }
}