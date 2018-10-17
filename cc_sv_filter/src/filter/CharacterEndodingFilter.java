package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class CharacterEndodingFilter implements Filter {

  public CharacterEndodingFilter() {
  }

  public void destroy() {
  }

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    // 前処理
    // すべてのリクエストに対して文字コードをUTF-8に変換する
    request.setCharacterEncoding("UTF-8");
    // フィルタ実行のメッセージをコンソールに出力
    System.out.println("フィルタの前処理（文字コード変換）を実行しました。");
    chain.doFilter(request, response);
    // フィルタ実行のメッセージをコンソールに出力
    System.out.println("フィルタの後処理を実行しました。");
  }

  public void init(FilterConfig fConfig) throws ServletException {

  }

}