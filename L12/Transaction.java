package exB2.L12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
/**
 *
 * トランザクション制御を利用した処理を行う
 *
 */
public class Transaction {
 
  public static void main(String[] args) {
 
    // JDBCドライバのロード
    try {
      Class.forName("org.h2.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
 
    try (
        // DBMSとの接続
        // JDBC URLは、環境に合わせて変更してください
        // ここでは「c:\Users\CodeCamp\test」にあるデータベースに接続しています
        Connection connection = DriverManager.getConnection("jdbc:h2:c:\\CodeCamp\\test", "sa", "");) {
 
      // 自動コミットモードを解除
      connection.setAutoCommit(false);
 
      try (
          // トランザクションとして実行する一連のSQLを準備します
          // （任意のSQLを記述してください）
          PreparedStatement pstmt = connection.prepareStatement("SELECT");) {
 
        // トランザクションとして実行する一連のSQLを実行する
        // ここで複数の検索や更新処理を行う
        pstmt.executeUpdate();
 
        // コミットを行い処理を確定する
        connection.commit();
 
      } catch (SQLException e) {
        // 途中でエラーが発生した場合は、ロールバックを行なう
        connection.rollback();
        throw e;
      }
 
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}