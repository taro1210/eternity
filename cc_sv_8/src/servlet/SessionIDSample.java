package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionID")
public class SessionIDSample extends HttpServlet {
  private static final long serialVersionUID = 1L;

   public SessionIDSample() {
        super();
    }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // セッションスコープの取得
    HttpSession session = request.getSession(false);
    //JSPページで表示するメッセージを格納するArrayList<String>を生成
    List<String> messages = new ArrayList<String>();

   // セッションの有無を判定
    if ( session == null ){
      messages.add("セッションを開始します。");
      session = request.getSession(true);
    }

   // セッションIDの取得
    String session_id = session.getId();
    messages.add("今回のセッションIDは、" + session_id + "です。");

   // Cookieの取得
    Cookie cookie[] = request.getCookies();
    // クッキー情報判定
    if( cookie != null ){
      messages.add("ユーザから送信されたクッキーを表示");
      for(Cookie data : cookie){
        if( "JSESSIONID".equals(data.getName()) ){
          //1日有効なクッキーに変更
          data.setMaxAge(60 * 24);
        }
        messages.add(data.getName() + " : " + data.getValue() + " : " + data.getMaxAge());
      }
    } else {
      messages.add("ユーザからのクッキーは送信されていません");
    }

   //セッションスコープにメッセージを格納
    session.setAttribute("messages", messages);

   //フォワード
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/session_id.jsp");
    dispatcher.forward(request, response);
  }
}