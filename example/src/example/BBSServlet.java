package example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BBSMain")
public class BBSServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  // GETリクエストの時は、そのままJSPへフォワード
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/bbs.jsp");
    rd.forward(request, response);
  }

  // POSTリクエストの時は、名前・メッセージを追加してからJSPへフォワード
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    String message = request.getParameter("message");
    @SuppressWarnings("unchecked")
    List<String> messages = (List<String>)getServletContext().getAttribute("messages");
    if (messages == null) {
      messages = new ArrayList<>();
    }

    synchronized (messages) {
      messages.add(name + ": " + message);
    }
    getServletContext().setAttribute("messages", messages);
    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/bbs.jsp");
    rd.forward(request, response);
  }

}