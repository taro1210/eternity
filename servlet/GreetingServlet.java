package servlet;
 
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/GreetingCompleteServlet")
public class GreetingServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  public GreetingServlet() {
    super();
  }
 
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
 
  //現在時刻を取得するため、Calendarインスタンスを取得
  Calendar cal = Calendar.getInstance();    
 
  //アクセスされた時間をint型として取得
  SimpleDateFormat sdf = new SimpleDateFormat("HH");
  int hour = Integer.parseInt(sdf.format(cal.getTime()));
 
  //出力する文字列用の変数を空文字で初期化
  String greeting = "";
 
  //現在時刻により判定
  if( hour >= 0 && hour < 6){
    greeting = "早朝にお疲れ様です。";
  }else if( hour < 11 ){
    greeting = "おはようございます。";
  }else if( hour < 16 ){
    greeting = "こんにちは。";
  }else if( hour < 20 ){
    greeting = "こんばんは。";
  }else{
    greeting = "深夜までお疲れ様です。";
  }
 
   //リクエストスコープに挨拶コメントを保持させる
   request.setAttribute("greeting", greeting);
 
  //List7_1_2.jspにフォワード
  RequestDispatcher dispatcher
      = request.getRequestDispatcher("/WEB-INF/jsp/List7_1_2.jsp");
    dispatcher.forward(request, response);
  }
}  