package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener // @WebListenerアノテーション
public class ListenerSample
    implements ServletContextListener, ServletContextAttributeListener, HttpSessionListener, ServletRequestListener {

  // コンストラクタ
  public ListenerSample() {
  }

  // ServletContextのライフサイクル
  // Webアプリケーションが開始されたとき
  public void contextInitialized(ServletContextEvent event) {
    // アプリケーションスコープを取得
    ServletContext application = event.getServletContext();
    // アプリケーションスコープにアクセス回数を表すインスタンスを登録
    application.setAttribute("count", new Integer(0));
    // コンソールにメッセージを出力
    System.out.println("ServletContextListener#contextInitialized()メソッドを実行");
  }
  // Webアプリケーションが終了したとき
  public void contextDestroyed(ServletContextEvent event) {
    // コンソールにメッセージを出力
    System.out.println("ServletContextListener#contextDestroyed()メソッドを実行");
  }

  // アプリケーションスコープの変更
  // アプリケーションスコープにインスタンスが追加されたとき
  public void attributeAdded(ServletContextAttributeEvent event) {
    // コンソールにメッセージを出力
    System.out.println("___ServletContextAttributeListener#attributeAdded()メソッドを実行");
  }
  // アプリケーションスコープのインスタンスを上書きしたとき
  public void attributeReplaced(ServletContextAttributeEvent event) {
    // コンソールにメッセージを出力
    System.out.println("___ServletContextAttributeListener#attributeReplaced()メソッドを実行");
  }
  // アプリケーションスコープのインスタンスを削除したとき
  public void attributeRemoved(ServletContextAttributeEvent event) {
    // コンソールにメッセージを出力
    System.out.println("___ServletContextAttributeListener#attributeRemoved()メソッドを実行");
  }

  // Sessionのライフサイクル
  // セッションが生成されたとき
  public void sessionCreated(HttpSessionEvent event) {
    // コンソールにメッセージを出力
    System.out.println("_________HttpSessionListener#sessionCreated()メソッドを実行");
  }
  // セッションが破棄されたとき
  public void sessionDestroyed(HttpSessionEvent event) {
    // コンソールにメッセージを出力
    System.out.println("_________HttpSessionListener#sessionDestroyed()メソッドを実行");
  }

  // Requestのライフサイクル
  // リクエストが生成したとき
  public void requestInitialized(ServletRequestEvent event) {
    // コンソールにメッセージを出力
    System.out.println("____________ServletRequestListener#requestInitialized()メソッドを実行");
  }
  // リクエストが終了したとき
  public void requestDestroyed(ServletRequestEvent event) {
    // コンソールにメッセージを出力
    System.out.println("____________ServletRequestListener#requestDestroyed()メソッドを実行");
  }
}