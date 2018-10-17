package filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/Login")
public class LoginCheckFilter implements Filter {

  public LoginCheckFilter() {
  }

  public void destroy() {
  }

  @SuppressWarnings("unchecked")
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    // 前処理
    System.out.println("ログインチェックフィルタ実行");
    // セッションの取得
    HttpSession session = ((HttpServletRequest) request).getSession(false);

    // セッションおよびログインのチェック
    if (session == null) {
      // フォワード
      ((HttpServletRequest) request).getRequestDispatcher("./").forward(request, response);
    } else {
      // ログインユーザの取得
      Map<String, String> user = (HashMap<String, String>) session.getAttribute("user");
      if (user == null) {
        ((HttpServletRequest) request).getRequestDispatcher("./").forward(request, response);
      }
      chain.doFilter(request, response);
    }
  }

  public void init(FilterConfig fConfig) throws ServletException {
  }

}