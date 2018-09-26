package exB2.L12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Kadai12 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {


		System.out.println("| 〒 郵便番号検索 ------------------------- |");
		System.out.println("|                                           |");
		System.out.println("| [C]新規テーブル作成 --------------------- |");
		System.out.println("| [A]郵便番号全件表示 --------------------- |");
		System.out.println("| [S]検索(郵便番号) ----------------------- |");
		System.out.println("| [T]検索(都道府県/市町村/町名) ----------- |\r\n");

		System.out.print("どの操作を行いますか? >");
		String inputMenu = new java.util.Scanner(System.in).nextLine();
		String a = null;
		if("C".equalsIgnoreCase(inputMenu) || "Ｃ".equalsIgnoreCase(inputMenu)){
			//テーブル生成から
		}else if("A".equalsIgnoreCase(inputMenu) || "Ａ".equalsIgnoreCase(inputMenu)){
			a = "SELECT ZIP_CODE, PREF, CITY, TOWN FROM ZIP_CODE";
		}else if("S".equalsIgnoreCase(inputMenu) || "Ｓ".equalsIgnoreCase(inputMenu)){
			a = "SELECT ZIP_CODE, PREF, CITY, TOWN FROM ZIP_CODE WHERE ZIP_CODE = ?";
		}else if("T".equalsIgnoreCase(inputMenu) || "Ｔ".equalsIgnoreCase(inputMenu)){
			a = "SELECT ZIP_CODE, PREF, CITY, TOWN FROM ZIP_CODE WHERE PREF = ? AND CITY = ? AND TOWN = ?";
		}

		/* try { Class.forName("org.h2.Driver"); } catch (ClassNotFoundException
		 * e) { e.printStackTrace(); }
		 */

		Connection connection = null;
		try {

			connection = DriverManager.getConnection("jdbc:h2:c:\\CodeCamp\\test", "sa", "");

			// PreparedStatementを使ってSQLの準備

			PreparedStatement pstmt = connection.prepareStatement(
					a,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			// SQLに検索条件を設定
			String inputX = new java.util.Scanner(System.in).nextLine();
			pstmt.setString(1,inputX);

			try (

					// executeQuery()メソッドでSQLを実行
					/*
					 * ResultSet scrollingRS =stmt.executeQuery(
					 * "SELECT * FROM whatever");
					 */
					ResultSet rs = pstmt.executeQuery();) {

				// ResultSetオブジェクトから結果を取得
				int count = 1;
				int memoryCount = 0;
				while (rs.next()) {
					int zipCode = rs.getInt(1);
					String pref = rs.getString(2);
					String city = rs.getString(3);
					String town = rs.getString(4);

					//if (!(pref.contains(inputX))) {
						//continue;
					//}
					System.out.printf("〒%3d %s %s %s\r\n", zipCode, pref, city, town);
					count++;
					memoryCount++;
					if (count > 10) {
						System.out.print("続き…N  ");
						if (memoryCount > 10) {
							System.out.println("前…B");
						} else {
							System.out.println("");
						}
						String inputNorB = new java.util.Scanner(System.in).nextLine();
						if ("N".equalsIgnoreCase(inputNorB) || "Ｎ".equalsIgnoreCase(inputNorB)) {
							count = 1;
							continue;
						} else if ("B".equalsIgnoreCase(inputNorB) || "Ｂ".equalsIgnoreCase(inputNorB)) {
							rs.relative(-20);
							count = 1;
							memoryCount -= 20;
							continue;
						} else {
							break;
						}
					}
				}
				System.out.println("オワリー");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {

					// DBMSとの切断。
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}