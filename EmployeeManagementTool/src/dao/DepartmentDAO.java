package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Department;

public class DepartmentDAO {
	private final String DRIVER_NAME = "org.h2.Driver";
	private final String JDBC_URL = "jdbc:h2:~/employManager";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	// 全件取得
	public ArrayList<Department> findAll() {
		ArrayList<Department> departments = new ArrayList<Department>();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {

			// JDBCドライバを読み込み
			Class.forName(DRIVER_NAME);

			// データベースへ接続
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			// SELECT文を準備
			String sql = "SELECT ID,DEPART_ID,DEPART_NAME FROM 部署情報";

			// 準備したSQLをデータベースに届けるPrepareStatementインスタンスを取得する
			pstmt = conn.prepareStatement(sql);

			// SQLを実行し、結果はResultSetインスタンスに格納される
			rs = pstmt.executeQuery();

			// 結果を１レコードづつ取得する
			while (rs.next()) {
				int    id		= rs.getInt   ("ID");		   // ID
				String dptId	= rs.getString("DEPART_ID");   // 部署ID
				String dptName	= rs.getString("DEPART_NAME"); // 部署名

				// Productインスタンスにデータを保存する
				Department department = new Department();
				department.setId(id);
				department.setDptId(dptId);
				department.setDptName(dptName);

				// リストにProductインスタンスを追加する
				departments.add(department);
			}
			return departments;

		// データベース接続やSQL実行失敗時の処理
		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		// JDBCドライバが見つからなかったときの処理
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;

		// PrepareStatementインスタンス、ResultSetインスタンスのクローズ処理
		} finally {
			if (rs != null) {
				try {
					rs.close();

				// ResultSetクローズ処理失敗時の処理
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();

				// PrepareStatementクローズ処理失敗時の処理
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			// データベース切断
			if (conn != null) {
				try {
					conn.close();

				// データベース切断失敗時の処理
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
	}

	// 特定データの取得(int型を引数にIDで検索？)
	public Department findById(int i) {
		Department department = new Department();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {

			// JDBCドライバを読み込み
			Class.forName(DRIVER_NAME);

			// データベースへ接続
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			// SELECT文を準備
			String sql = "SELECT * FROM 部署情報 WHERE ID=?";

			// 準備したSQLをデータベースに届けるPrepareStatementインスタンスを取得する
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,i);

			// SQLを実行し、結果はResultSetインスタンスに格納される
			rs = pstmt.executeQuery();
			rs.next();

			int    id		= rs.getInt   ("ID");		   // ID
			String dptId	= rs.getString("DEPART_ID");   // 部署ID
			String dptName	= rs.getString("DEPART_NAME"); // 部署名

			// Productインスタンスにデータを保存する
			department.setId(id);
			department.setDptId(dptId);
			department.setDptName(dptName);

			return department;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;

			// JDBCドライバが見つからなかったときの処理
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	// データの更新
	public int update(Department department) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			// JDBCドライバを読み込み
			Class.forName(DRIVER_NAME);

			// データベースへ接続
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			// UPDATE文を準備
			String sql = "UPDATE 部署情報 SET DEPART_ID=?,DEPART_NAME=? WHERE ID=?";

			// 準備したSQLをデータベースに届けるPrepareStatementインスタンスを取得する
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, department.getDptId());
			pstmt.setString(2, department.getDptName());
			pstmt.setInt(3, department.getId());

			pstmt.executeUpdate();
			return 1;

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;

			// JDBCドライバが見つからなかったときの処理
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return 0;
		}
	}

	// データの削除(DELETE)
	public int delete(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			// JDBCドライバを読み込み
			Class.forName(DRIVER_NAME);

			// データベースへ接続
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			// DELETE文を準備
			String sql = "DELETE FROM 部署情報 WHERE ID=?";

			// 準備したSQLをデータベースに届けるPrepareStatementインスタンスを取得する
			pstmt = conn.prepareStatement(sql);

			// 行を指定
			pstmt.setInt(1, id);

			//
			pstmt.executeUpdate();
			return 1;

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;

			// JDBCドライバが見つからなかったときの処理
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return 0;
		}
	}

	// データの新規登録(INSERT)
	public int insert(Department department) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			// JDBCドライバを読み込み
			Class.forName(DRIVER_NAME);

			// データベースへ接続
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			// SELECT文を準備
			String sql = "INSERT INTO 部署情報(ID,DEPART_ID,DEPART_NAME) VALUES(?,?,?)";

			// 準備したSQLをデータベースに届けるPrepareStatementインスタンスを取得する
			pstmt = conn.prepareStatement(sql);

			// IDが「0」で渡ってくるので最新IDを登録する
						PreparedStatement oneTimePst = null;
						ResultSet rs = null;

						// IDを取り出してくるSELECT文
						if(department.getId() == 0){
							String oneTimeSql = "SELECT ID FROM 部署情報";
							oneTimePst = conn.prepareStatement(oneTimeSql);
							rs = oneTimePst.executeQuery();
							int maxIdCount = 0;
							int BeforeIdCount = 0;


							// 最大値のみを引っ張り出してmaxIdCountに格納
							while (rs.next()) {
								maxIdCount = rs.getInt("ID");

								// もし間が空いていたらそこに入れたい
								if(maxIdCount - BeforeIdCount != 1){
									maxIdCount = BeforeIdCount;
									break;
								}
								BeforeIdCount = maxIdCount;
							}

							// 「最大値+1」をセットする
							department.setId(maxIdCount+1);

							// 部署IDは「D-(id値)」にする(0埋めしたい)
							if(maxIdCount+1 > 9){
								department.setDptId("D-" + (maxIdCount+1));
							}else {
								department.setDptId("D-0" + (maxIdCount+1));
							}
						}
						// ResultSetをクローズを閉じる
						if(rs != null){
							rs.close();
						}

						// PreparedStatementを閉じる
						if (oneTimePst != null) {
							oneTimePst.close();
						}

			pstmt.setInt(1, department.getId());
			pstmt.setString(2, department.getDptId());
			pstmt.setString(3, department.getDptName());

			pstmt.executeUpdate();
			return 1;

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;

			// JDBCドライバが見つからなかったときの処理
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return 0;
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();

					// PrepareStatementクローズ処理失敗時の処理
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			// データベース切断
			if (conn != null) {
				try {
					conn.close();

					// データベース切断失敗時の処理
				} catch (SQLException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}
	}
}