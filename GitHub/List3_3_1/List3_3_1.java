package List3_3_1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class List3_3_1
 */
@WebServlet("/Unsei/Omikuji")
public class List3_3_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public List3_3_1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ④おみくじの内容をコーディング-------
		// おみくじの種類
		String[] omikujiArray = { "大吉", "吉", "中吉", "小吉", "凶" };
		// おみくじのコメント
		String[] unseiArray = { "最高の運勢です！今日もいいことがありますよ。", // 大吉
				"良い運勢です。忘れ物に注意してね。", // 吉
				"まあまあの運勢です。焦らずに、足元に気をつけてね。", // 中吉
				"良くなりつつあります。この時期の努力はきっと実りますよ。", // 小吉
				"今は我慢の時。これを乗り越えると、運が開けますよ" // 凶
		};
		// 0以上５未満の整数を乱数で発生
		int index = (int) (Math.random() * 5);
		// おみくじの種類を決定
		String omikuji = omikujiArray[index];
		// おみくじのコメントを決定
		String unsei = unseiArray[index];
		// -------------------------------
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang\"ja\">");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>おみくじ</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>★☆★今日の運勢☆★☆</h3>");
		out.println("<p>今日のおみくじは[" + omikuji + "]です。</p>");
		out.println("<p>" + unsei + "</p>");
		out.println("</body>");
		out.println("</html>");
		// -------------------------------
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
