package test;

import dao.UserAccountDAO;
import model.Login;
import model.UserAccount;

public class UserAccountDAO_Test {
	public static void main(String[] args) {
		testFindLogin();
		testNotFindLogin();
	}

	private static void testFindLogin() {
		Login lg = new Login("1", "tera1210");
		UserAccountDAO dao = new UserAccountDAO();
		UserAccount result = dao.findLogin(lg);
		if (result != null && result.getUserId().equals("1") && result.getName().equals("寺田翔太朗")
				&& result.getAge() == 28 && result.getGender().equals("男")
				&& result.getTellNumber().equals("090-5665-9300") && result.getMail().equals("terada@bfront.co.jp")
				&& result.getPass().equals("tera1210") && result.getBelong().equals("ゼネラル・マネージメント部")) {
			System.out.println("OKやで？");
		} else {
			System.out.println("ダメやねえか…");
		}
	}

	private static void testNotFindLogin(){
		Login lg = new Login("1", "terada1210");
		UserAccountDAO dao = new UserAccountDAO();
		UserAccount result = dao.findLogin(lg);
		if (result == null) {
			System.out.println("なくてええんちゃう？");
		} else {
			System.out.println("どないなっとんねん…");
		}
	}
}
