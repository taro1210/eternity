package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AccessCounter")
public class AccessCounterServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public AccessCounterServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // リクエストパラメータを取得
    request.setCharacterEncoding("UTF-8");
    String action = request.getParameter("action");

    if (action == null) {
      // アプリケーションスコープを取得
      ServletContext application = this.getServletContext();
      // アプリケーションスコープからアクセス回数を取得
      int count = (Integer) application.getAttribute("count");
      // カウントアップし、アプリケーションスコープに格納
      application.setAttribute("count", new Integer(++count));
    } else {
      // セッションスコープを取得
      HttpSession session = request.getSession();
      // 既存セッションを破棄
      session.invalidate();
    }
    // フォワード処理
    request.getRequestDispatcher("/WEB-INF/jsp/listener.jsp").forward(request, response);
  }

}