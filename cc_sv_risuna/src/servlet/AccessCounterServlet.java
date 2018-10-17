package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AccessCounter")
public class AccessCounterServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  // アクセス回数用の変数を宣言
  private int count;

  public AccessCounterServlet() {
    super();
  }

  @Override
  public void init() throws ServletException {
    ServletContext application = this.getServletContext();
    // アクセス回数用の変数を初期化
    this.count = 0;

    // アプリケーションスコープに格納
    application.setAttribute("count", new Integer(count));
    // コンソールに出力
    System.out.println("サーブレットクラスが生成されたので、init()メソッドが実行されました。");
  };

  @Override
  public void destroy() {
    // コンソールに出力
    System.out.println("サーバが終了したので、このインスタンスが破棄される直前にdestroy()メソッドが実行されました。");
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // アプリケーションスコープを取得
    ServletContext application = this.getServletContext();
    // アプリケーションスコープからアクセス回数を取得
    int count = (Integer) application.getAttribute("count");

    // カウントアップし、アプリケーションスコープに格納
    application.setAttribute("count", new Integer(++count));

    // フォワード処理
    request.getRequestDispatcher("/WEB-INF/jsp/init_destroy.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}