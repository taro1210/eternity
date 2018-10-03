package exB2.L12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;

public class Kadai12 {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws SQLException {
		/*
		 * try { Class.forName("org.h2.Driver"); } catch (ClassNotFoundException
		 * e) { e.printStackTrace(); }
		 */
		Connection connection = null;
		while (true) {
			System.out.println("| 〒 郵便番号検索 ------------------------- |");
			System.out.println("|                                           |");
			System.out.println("| [C]新規テーブル作成 --------------------- |");
			System.out.println("| [A]郵便番号全件表示 --------------------- |");
			System.out.println("| [S]検索(郵便番号) ----------------------- |");
			System.out.println("| [T]検索(都道府県/市町村) ---------------- |");
			System.out.println("| [Q]終了 --------------------------------- |\r\n");

			System.out.print("どの操作を行いますか? >");

			String inputMenu = null;
			String sqlmes = null;
			try {
				connection = DriverManager.getConnection("jdbc:h2:c:\\CodeCamp\\test", "sa", "");
				inputMenu = new java.util.Scanner(System.in).nextLine();

				if ("C".equalsIgnoreCase(inputMenu) || "Ｃ".equalsIgnoreCase(inputMenu)) {
					System.out.println("テーブル作成を行います。--------------------");

					if ("C".equalsIgnoreCase(inputMenu) || "Ｃ".equalsIgnoreCase(inputMenu)) {
						PreparedStatement pstmt = connection.prepareStatement("CREATE TABLE ZIP_CODE AS SELECT * FROM CSVREAD"
								+ "('c:\\CodeCamp\\zip_data_split_1.csv',null,'UTF-8')");
						pstmt.executeUpdate();
						PreparedStatement in = connection.prepareStatement("INSERT INTO ZIP_CODE SELECT * FROM CSVREAD"
								+ "('c:\\CodeCamp\\zip_data_split_2.csv')");
						in.executeUpdate();
						in = connection.prepareStatement("INSERT INTO ZIP_CODE SELECT * FROM CSVREAD"
								+ "('c:\\CodeCamp\\zip_data_split_3.csv')");
						in.executeUpdate();
						System.out.println("テーブル作成されました");
						continue;
					}
				} else if ("A".equalsIgnoreCase(inputMenu) || "Ａ".equalsIgnoreCase(inputMenu)) {
					System.out.println("郵便番号を全件表示します。------------------");
					sqlmes = "SELECT ZIP_CODE, PREF, CITY, TOWN FROM ZIP_CODE";
				} else if ("S".equalsIgnoreCase(inputMenu) || "Ｓ".equalsIgnoreCase(inputMenu)) {
					inputMenu = "S";
					System.out.println("郵便番号で検索します。----------------------");
					sqlmes = "SELECT ZIP_CODE, PREF, CITY, TOWN FROM ZIP_CODE WHERE ZIP_CODE = ?";
				} else if ("T".equalsIgnoreCase(inputMenu) || "Ｔ".equalsIgnoreCase(inputMenu)) {
					inputMenu = "T";
					System.out.println("住所で検索します。--------------------------");
					sqlmes = "SELECT ZIP_CODE, PREF, CITY, TOWN FROM ZIP_CODE WHERE PREF = ? AND CITY = ?";
				} else if ("Q".equalsIgnoreCase(inputMenu) || "Ｑ".equalsIgnoreCase(inputMenu)) {
					System.out.println("");
					break;
				} else {
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				System.out.println("");
				System.err.println("不適切な文字が入力されました。");
				System.out.println("");
				continue;
			}
			if (connection == null) {
				System.out.println("");
				System.err.println("テーブルを作成して下さい。");
				System.out.println("");
				continue;
			}
			// PreparedStatementを使ってSQLの準備
			PreparedStatement pstmt = connection.prepareStatement(sqlmes, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			// SQLに検索条件を設定
			if ("S".equals(inputMenu)) {
				System.out.println("郵便番号を7桁で入力して下さい");
				String inputX = zipCode();
				pstmt.setString(1, inputX);
			} else if ("T".equals(inputMenu)) {
				System.out.println("都道府県を入力して下さい。");
				String inputPref = address();
				pstmt.setString(1, inputPref);
				System.out.println("市町村を入力して下さい(区まである場合は区も入力)。");
				String inputCity = address();
				pstmt.setString(2, inputCity);
			}
			try (
					// ResultSetオブジェクトから結果を取得
					ResultSet rs = pstmt.executeQuery();) {
				int count = 1;
				int memoryCount = 0;
				while (rs.next()) {
					int zipCode = rs.getInt(1);
					String pref = rs.getString(2);
					String city = rs.getString(3);
					String town = rs.getString(4);

					System.out.printf("〒%3d %s %s %s\r\n", zipCode, pref, city, town);
					count++;
					memoryCount++;
					if (count > 10) {
						if (memoryCount <= 10) {
							System.out.println("次の10件を表示…[N] 終了…[Q]");
						} else if (memoryCount > 10) {
							System.out.println("前の10件を表示…[B] 次の10件を表示…[N] 終了…[Q]");
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
						} else if ("Q".equalsIgnoreCase(inputNorB) || "Ｑ".equalsIgnoreCase(inputNorB)) {
							break;
						} else {
							System.err.println("[N],[B],[Q]のいずれかを入力して下さい");
							rs.relative(-10);
							count = 1;
							memoryCount -= 10;
						}
					}
				}
				if (memoryCount == 0) {
					System.out.println("ヒットしませんでした。");
				}
				System.out.println("");
				System.out.println("まだ検索を続けますか？ Yes…[y] No…[n]");
				try {
					String inputX = new java.util.Scanner(System.in).nextLine();
					if ("Y".equalsIgnoreCase(inputX) || "Ｙ".equalsIgnoreCase(inputX)) {
						continue;
					} else if ("N".equalsIgnoreCase(inputX) || "Ｎ".equalsIgnoreCase(inputX)) {
						break;
					} else {
						throw new InputMismatchException();
					}
				} catch (InputMismatchException e) {
					System.err.println("日本語で入力して下さい。");
					continue;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				// DBMSとの切断。
				System.out.println("終了します。--------------------------------");
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("resource")
	public static String zipCode() {
		try {
			String inputX = new java.util.Scanner(System.in).nextLine();
			if (!(inputX.matches("\\d{7}"))) {
				throw new InputMismatchException();
			}
			return inputX;
		} catch (InputMismatchException e) {
			System.err.println("7桁の数字で入力して下さい");
			return zipCode();
		}
	}

	@SuppressWarnings("resource")
	public static String address() {
		try {
			String inputX = new java.util.Scanner(System.in).nextLine();
			if (inputX.matches("\\w") || inputX.matches("\\d")) {
				throw new InputMismatchException();
			}
			return inputX;
		} catch (InputMismatchException e) {
			System.err.println("日本語で入力して下さい。");
			return address();
		}
	}
}