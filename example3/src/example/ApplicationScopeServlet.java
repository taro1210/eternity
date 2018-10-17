package example;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ApplicationScope")
public class ApplicationScopeServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/applicationScope.jsp");
    rd.forward(request, response);
}

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    ServletContext application = this.getServletContext();//★

    String value = request.getParameter("button");
    synchronized (application) {
      switch (value) {
      case "カウンタクリア":
        application.removeAttribute("count");;
        break;
      case "カウントアップ":
        Integer count = (Integer) application.getAttribute("count");
        if (count != null) {
          count += 1;
        } else {
          count = 1;
        }
        application.setAttribute("count", count);
      }
     }
     RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/applicationScope.jsp");
     rd.forward(request, response);
  }

}