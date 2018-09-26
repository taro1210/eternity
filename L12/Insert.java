package exB2.L12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
/**
 *
 * データの作成(INSERT)処理を行う
 *
 */
public class Insert {
 
  public static void main(String[] args) {
 
    // JDBCドライバのロード
    try {
      Class.forName("org.h2.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
 
    try (
        // DBMSとの接続
        // JDBC URLは、環境に合わせて変更してください。
        // ここでは「c:\Users\CodeCamp\test」にあるデータベースに接続しています。
        Connection connection = DriverManager.getConnection("jdbc:h2:c:\\CodeCamp\\test", "sa", "");
        //DriverManager.getConnection("jdbc:h2:c:\\CodeCamp\\test");
    		//con=DriverManager.getConnection("jdbc:h2:tcp://localhost:8082/h2data");
        // PreparedStatementを使ってSQLの準備
        PreparedStatement pstmt = connection.prepareStatement("INSERT INTO EMP VALUES(?, ?)");) {
 
      // 10 件のデータを作成します
      for (int i = 0; i < 20; i++) {
 
        // 準備したSQLにパラメータをセット
        int id = i + 1; // ID列に1から始まる連番をセット
        pstmt.setInt(1, id);
        pstmt.setString(2, "ユーザー" + id); // NAME列にユーザー1, ユーザー2, …をセット
 
        // executeUpdate()でSQLを実行
        int cnt = pstmt.executeUpdate();
        System.out.printf("データを%d件INSERTしました。\n", cnt);
      }
 
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
 
}