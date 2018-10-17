package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class AccessCounterServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public AccessCounterServlet() {
    super();
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // リクエストパラメータを取得
    String userName = request.getParameter("userName");
    String password = request.getParameter("password");

    // セッションスコープを取得
    HttpSession session = request.getSession();

    // セッションスコープのチェック
    if (session == null) {
      // フォワード
      request.getRequestDispatcher("./").forward(request, response);
    } else {
      // セッションスコープにユーザ名・パスワードを登録
      Map<String, String> map = new HashMap<String, String>();
      map.put("userName", userName);
      map.put("password", password);
      session.setAttribute("user", map);

      // フォワード
      request.getRequestDispatcher("/WEB-INF/jsp/top.jsp").forward(request, response);
    }
  }
}