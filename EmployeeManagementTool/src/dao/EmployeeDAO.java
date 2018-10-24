package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Employee;

public class EmployeeDAO {
	private final String DRIVER_NAME = "org.h2.Driver";
	private final String JDBC_URL = "jdbc:h2:~/employManager";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	// 全件取得
	public ArrayList<Employee> findAll() {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {

			// JDBCドライバを読み込み
			Class.forName(DRIVER_NAME);

			// データベースへ接続
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			// SELECT文を準備
			String sql = "SELECT ID,EMPLOYEE_ID,NAME,AGE,GENDER,"
						+ "PHOTO_ID,ZIP,PREF,CITY,DEPARTMENT_ID,"
						+ "ENTRY,RESIGN FROM 社員情報 ORDER BY ID ASC";

			// 準備したSQLをデータベースに届けるPrepareStatementインスタンスを取得する
			pstmt = conn.prepareStatement(sql);

			// SQLを実行し、結果はResultSetインスタンスに格納される
			rs = pstmt.executeQuery();

			// 結果を１レコードづつ取得する
			while (rs.next()) {
				int    id        = rs.getInt   ("ID");			 // ID
				String empId     = rs.getString("EMPLOYEE_ID");	 // 社員ID
				String empName   = rs.getString("NAME");		 // 名前
				int    empAge    = rs.getInt   ("AGE");			 // 年齢
				String empGender = rs.getString("GENDER");		 // 性別
				String photoId   = rs.getString("PHOTO_ID");	 // 写真ID
				String zip       = rs.getString("ZIP");			 // 郵便番号
				String pref      = rs.getString("PREF");		 // 都道府県
				String city      = rs.getString("CITY");		 // 市町村
				String dptId     = rs.getString("DEPARTMENT_ID");// 部署ID
				String entry     = rs.getString("ENTRY");		 // 入社日
				String resign    = rs.getString("RESIGN");		 // 退社日

				// Productインスタンスにデータを保存する
				Employee employee = new Employee();
				employee.setId(id);
				employee.setEmpId(empId);
				employee.setEmpName(empName);
				employee.setEmpAge(empAge);
				employee.setEmpGender(empGender);
				employee.setPhotoId(photoId);
				employee.setZip(zip);
				employee.setPref(pref);
				employee.setCity(city);
				employee.setDptId(dptId);
				employee.setEntryDate(entry);
				employee.setResignDate(resign);

				// リストにProductインスタンスを追加する
				employees.add(employee);
			}
			return employees;

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
	public Employee findById(int i) {
		Employee employee = new Employee();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {

			// JDBCドライバを読み込み
			Class.forName(DRIVER_NAME);

			// データベースへ接続
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			// SELECT文を準備
			String sql = "SELECT ID,EMPLOYEE_ID,NAME,AGE,GENDER,PHOTO_ID,"
					+ "ZIP,PREF,CITY,DEPARTMENT_ID,ENTRY,RESIGN "
					+ "FROM 社員情報 WHERE ID=?";

			// 準備したSQLをデータベースに届けるPrepareStatementインスタンスを取得する
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,i);
			// SQLを実行し、結果はResultSetインスタンスに格納される
			rs = pstmt.executeQuery();
			rs.next();

			int    id        = rs.getInt   ("ID");			 // ID
			String empId     = rs.getString("EMPLOYEE_ID");	 // 社員ID
			String empName   = rs.getString("NAME");		 // 名前
			int    empAge    = rs.getInt   ("AGE");			 // 年齢
			String empGender = rs.getString("GENDER");		 // 性別
			String photoId   = rs.getString("PHOTO_ID");	 // 写真ID
			String zip       = rs.getString("ZIP");			 // 郵便番号
			String pref      = rs.getString("PREF");		 // 都道府県
			String city      = rs.getString("CITY");		 // 市町村
			String dptId     = rs.getString("DEPARTMENT_ID");// 部署ID
			String entry     = rs.getString("ENTRY");		 // 入社日
			String resign    = rs.getString("RESIGN");		 // 退社日

			// Productインスタンスにデータを保存する
			employee.setId(id);
			employee.setEmpId(empId);
			employee.setEmpName(empName);
			employee.setEmpAge(empAge);
			employee.setEmpGender(empGender);
			employee.setPhotoId(photoId);
			employee.setZip(zip);
			employee.setPref(pref);
			employee.setCity(city);
			employee.setDptId(dptId);
			employee.setEntryDate(entry);
			employee.setResignDate(resign);

			return employee;

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
	public int update(Employee employee) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			// JDBCドライバを読み込み
			Class.forName(DRIVER_NAME);

			// データベースへ接続
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			// UPDATE文を準備
			String sql = "UPDATE 社員情報 SET EMPLOYEE_ID='?',NAME='?',AGE=?,GENDER='?',"
					+ "PHOTO_ID='?',ZIP='?',PREF='?',CITY='?',DEPARTMENT_ID='?',"
					+ "ENTRY='?',RESIGN='?' WHERE ID=?";

			// 準備したSQLをデータベースに届けるPrepareStatementインスタンスを取得する
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, employee.getEmpId());
			pstmt.setString(2, employee.getEmpName());
			pstmt.setInt(3, employee.getEmpAge());
			pstmt.setString(4, employee.getEmpGender());
			pstmt.setString(5, employee.getPhotoId());
			pstmt.setString(6, employee.getZip());
			pstmt.setString(7, employee.getPref());
			pstmt.setString(8, employee.getCity());
			pstmt.setString(9, employee.getDptId());
			pstmt.setString(10, employee.getEntryDate());
			pstmt.setString(11, employee.getResignDate());
			pstmt.setInt(12, employee.getId());

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
			String sql = "DELETE FROM 社員情報 WHERE ID=?";

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

	// データの登録(INSERT)
	public int insert(Employee employee) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			// JDBCドライバを読み込み
			Class.forName(DRIVER_NAME);

			// データベースへ接続
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			// SELECT文を準備
			String sql = "INSERT INTO 社員情報(ID,EMPLOYEE_ID," + "NAME,AGE,GENDER,PHOTO_ID,ZIP,PREF,CITY,"
					+ "DEPARTMENT_ID,ENTRY,RESIGN)" + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

			// 準備したSQLをデータベースに届けるPrepareStatementインスタンスを取得する
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, employee.getId());
			pstmt.setString(2, employee.getEmpId());
			pstmt.setString(3, employee.getEmpName());
			pstmt.setInt(4, employee.getEmpAge());
			pstmt.setString(5, employee.getEmpGender());
			pstmt.setString(6, employee.getPhotoId());
			pstmt.setString(7, employee.getZip());
			pstmt.setString(8, employee.getPref());
			pstmt.setString(9, employee.getCity());
			pstmt.setString(10, employee.getDptId());
			pstmt.setString(11, employee.getEntryDate());
			pstmt.setString(12, employee.getResignDate());
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

	// データを検索
	public ArrayList<Employee> search(String departId, String employId, String employName) {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {

			// JDBCドライバを読み込み
			Class.forName(DRIVER_NAME);

			// データベースへ接続
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			// SELECT文を準備
			String sql = "SELECT ID,EMPLOYEE_ID,NAME,AGE,GENDER,PHOTO_ID,ZIP,PREF,CITY,"
					   + "DEPARTMENT_ID,ENTRY,RESIGN FROM 社員情報 WHERE DEPARTMENT_ID LIKE'%?%' "
					   + "AND EMPLOYEE_ID LIKE'%?%' AND NAME LIKE'%?%'";

			// 準備したSQLをデータベースに届けるPrepareStatementインスタンスを取得する
			pstmt = conn.prepareStatement(sql);
			if(departId != null){
				pstmt.setString(1, departId);
			}else{
				pstmt.setString(1, "");
			}
			if(employId != null){
				pstmt.setString(2, employId);
			}else{
				pstmt.setString(2, "");
			}
			if(employName != null){
				pstmt.setString(3, employName);
			}else{
				pstmt.setString(3, "");
			}

			// SQLを実行し、結果はResultSetインスタンスに格納される
			rs = pstmt.executeQuery();

			// 結果を１レコードづつ取得する
			while (rs.next()) {
				int    id        = rs.getInt   ("ID");			 // ID
				String empId     = rs.getString("EMPLOYEE_ID");	 // 社員ID
				String empName   = rs.getString("NAME");		 // 名前
				int    empAge    = rs.getInt   ("AGE");			 // 年齢
				String empGender = rs.getString("GENDER");		 // 性別
				String photoId   = rs.getString("PHOTO_ID");	 // 写真ID
				String zip       = rs.getString("ZIP");			 // 郵便番号
				String pref      = rs.getString("PREF");		 // 都道府県
				String city      = rs.getString("CITY");		 // 市町村
				String dptId     = rs.getString("DEPARTMENT_ID");// 部署ID
				String entry     = rs.getString("ENTRY");		 // 入社日
				String resign    = rs.getString("RESIGN");		 // 退社日

				// Productインスタンスにデータを保存する
				Employee employee = new Employee();
				employee.setId(id);
				employee.setEmpId(empId);
				employee.setEmpName(empName);
				employee.setEmpAge(empAge);
				employee.setEmpGender(empGender);
				employee.setPhotoId(photoId);
				employee.setZip(zip);
				employee.setPref(pref);
				employee.setCity(city);
				employee.setDptId(dptId);
				employee.setEntryDate(entry);
				employee.setResignDate(resign);

				// リストにProductインスタンスを追加する
				employees.add(employee);
			}
			return employees;

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
}
