package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Rate;

@WebServlet("/ApplicationScope")
public class ApplicationScopeSample extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ApplicationScopeSample() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // process()メソッドを実行
    process(request, response);
    // フォワード
    request.getRequestDispatcher("/WEB-INF/jsp/rating.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // process()メソッドを実行
    process(request, response);
    // リダイレクト
    response.sendRedirect("./ApplicationScope");
  }

  private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // リクエストパラメータの文字コードをUTF-8に設定
    request.setCharacterEncoding("UTF-8");
    // リクエストパラメータ「action」の値を取得
    String action = request.getParameter("action");

   // アプリケーションスコープを取得
    ServletContext application = this.getServletContext();
    // アプリケーションスコープからインスタンスを取得
    Rate rate = (Rate) application.getAttribute("rate");

   // 評価インスタンスの初期化（初回のみ実行）
    if (rate == null) {
      rate = new Rate();
    }

   // 取得した値の判定
    if (action != null) {
      try {
        int score = Integer.parseInt(request.getParameter("score"));
        rate.setRate(score);
      } catch (NumberFormatException e) {
      }
    }
    // アプリケーションスコープにJavaBeansをセット
    application.setAttribute("rate", rate);
  }
}