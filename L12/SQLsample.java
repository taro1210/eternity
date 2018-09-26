package exB2.L12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLsample {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection connection = null;
		try {

			connection = DriverManager.getConnection("jdbc:h2:c:\\CodeCamp\\test", "sa", "");

			// PreparedStatementを使ってSQLの準備
			Statement pstmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			connection.prepareStatement("SELECT ZIP_CODE, PREF, CITY, TOWN FROM ZIP_CODE WHERE ZIP_CODE > ?");
			// SQLに検索条件を設定
			System.out.println("まず聞こう…");
			String inputX = new java.util.Scanner(System.in).nextLine();

			try (

					// executeQuery()メソッドでSQLを実行
					/*
					 * ResultSet scrollingRS =stmt.executeQuery("SELECT * FROM whatever");
					 */
					ResultSet rs = pstmt.executeQuery("SELECT ZIP_CODE, PREF, CITY, TOWN FROM ZIP_CODE");) {

				// ResultSetオブジェクトから結果を取得
				int count = 1;
				int memoryCount = 0;
				while (rs.next()) {
					int zipCode = rs.getInt(1);
					String pref = rs.getString(2);
					String city = rs.getString(3); 
					String town = rs.getString(4); 

					if (!(pref.contains(inputX))) {
						continue;
					}
					System.out.printf("〒%3d, %s, %s, %s\n", zipCode, pref, city, town);
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