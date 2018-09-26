package exB2.L12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
/**
 *
 * データの更新(UPDATE)処理を行う
 *
 */
public class Update {
 
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
        Connection connection = DriverManager.getConnection("jdbc:h2:c:\\CodeCamp\\test", "sa", "");
 
        // PreparedStatementを使ってSQLの準備
        PreparedStatement pstmt = connection.prepareStatement("UPDATE EMP SET NAME =? WHERE ID =?");) {
 
      // IDが偶数のデータを更新します。
      for (int i = 0; i < 10; i++) {
 
        // 準備したSQLにパラメータをセット
        int id = i + 1;
        if (id % 2 == 0) {
        	if(id % 3 == 0){
        	 pstmt.setString(1, "ユーザー" + id + "(♂×♂)");
        	}else if(id % 4 == 0){
        		pstmt.setString(1, "ユーザー" + id + "(♀×♂)");
        	}else{
        		pstmt.setString(1, "ユーザー" + id + "(♀×♀)");
        	}
          pstmt.setInt(2, id);
 
          /*
           * executeUpdate()でSQLを実行
           */
          int cnt = pstmt.executeUpdate();
          System.out.printf("データを%d件UPDATEしました。\n", cnt);
        }
      }
 
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
 
}