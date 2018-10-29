package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Photo;

public class PhotoDAO {
	private final String DRIVER_NAME = "org.h2.Driver";
	private final String JDBC_URL = "jdbc:h2:~/employManager";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";


	// 写真データの取得
	public Photo findById(int i) {
		Photo photo = new Photo();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {

			// JDBCドライバを読み込み
			Class.forName(DRIVER_NAME);

			// データベースへ接続
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			// SELECT文を準備
			String sql = "SELECT IMG FROM 写真 WHERE ID = ?";

			// 準備したSQLをデータベースに届けるPrepareStatementインスタンスを取得する
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,i);
			// SQLを実行し、結果はResultSetインスタンスに格納される
			rs = pstmt.executeQuery();
			rs.next();

			Blob blob = rs.getBlob(i);
			InputStream is = blob.getBinaryStream();
				

			return photo;

		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return null;

			// JDBCドライバが見つからなかったときの処理
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	// データの更新
	public int update(Photo photo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			// JDBCドライバを読み込み
			Class.forName(DRIVER_NAME);

			// データベースへ接続
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			// UPDATE文を準備
			String sql = "UPDATE 写真 SET IMG_ID=?,IMG=? WHERE ID=?";

			// 準備したSQLをデータベースに届けるPrepareStatementインスタンスを取得する
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, photo.getPhotoId());
			pstmt.setBlob(2, photo.getPhoto());
			pstmt.setInt(3, photo.getId());

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
	public int insert(Photo photo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			// JDBCドライバを読み込み
			Class.forName(DRIVER_NAME);

			// データベースへ接続
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			// SELECT文を準備
			String sql = "INSERT INTO 写真 VALUES(?, ?, ?)";

			// 準備したSQLをデータベースに届けるPrepareStatementインスタンスを取得する
			pstmt = conn.prepareStatement(sql);

			// IDが「0」で渡ってくるので最新IDを登録する
			PreparedStatement oneTimePst = null;
			ResultSet rs = null;

			// IDを取り出してくるSELECT文
			if(photo.getId() == 0){
				String oneTimeSql = "SELECT ID FROM 写真";
				oneTimePst = conn.prepareStatement(oneTimeSql);
				rs = oneTimePst.executeQuery();
				int maxIdCount = 0;

				// 最大値のみを引っ張り出してmaxIdCountに格納
				while (rs.next()) {
					maxIdCount = rs.getInt("ID");
				}
				// 部署IDは「D-(id値)」にする(0埋めしたい)
				if(maxIdCount+1 > 9){
					photo.setPhotoId("P-" + (maxIdCount+1));
				}else {
					photo.setPhotoId("P-0" + (maxIdCount+1));
				}

				// 「最大値+1」をセットする
				photo.setId(maxIdCount+1);
			}
			// ResultSetをクローズを閉じる
			if(rs != null){
				rs.close();
			}

			// PreparedStatementを閉じる
			if (oneTimePst != null) {
				oneTimePst.close();
			}

			pstmt.setInt(1, photo.getId());
			pstmt.setString(2, photo.getPhotoId());
			pstmt.setBlob(3, photo.getPhoto());
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