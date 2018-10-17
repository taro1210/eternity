package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Sample")
public class SampleServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public SampleServlet() {
    super();
  }

  @Override
  public void init() throws ServletException {

  }

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config); // スーパークラスのinit()メソッドを実行
    // これ以降、1度だけ実行したい処理を記述

  }

  @Override
  public void destroy() {

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}