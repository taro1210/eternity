package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Login;
import model.UserAccount;

public class UserAccountDAO {
	public UserAccount findLogin(Login login) {
		Connection conn = null;
		UserAccount userAc = null;

		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:~/sukkiri", "sa", "");

			String sql = "SELECT USER_ID,NAME,AGE,GENDER,TELL_NUMBER,MAIL,PASS,BELONG "
					+ "FROM USER_ACCOUNT WHERE USER_ID=? AND PASS=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getUserId());
			pStmt.setString(2, login.getPass());

			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				String userId = rs.getString("USER_ID");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				String gender = rs.getString("GENDER");
				String tellNumber = rs.getString("TELL_NUMBER");
				String mail = rs.getString("MAIL");
				String pass = rs.getString("PASS");
				String belong = rs.getString("BELONG");

				userAc = new UserAccount(userId, name, age, gender, tellNumber, mail, pass, belong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return userAc;

	}
}
