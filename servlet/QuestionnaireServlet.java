package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Gender;
import model.GreetingLogic;
import model.UserBean;

@WebServlet("/questionnaire")
public class QuestionnaireServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public QuestionnaireServlet() {
    super();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //Getメソッドでのリクエストのため、トップページにフォワード処理を行う
    RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
    dispatcher.forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   //リクエストパラメータの文字コードをUTF-8に設定
    request.setCharacterEncoding("UTF-8");
    //リクエストパラメータを取得
    String lastName = request.getParameter("lastName"); //姓
    String firstName = request.getParameter("firstName"); //名
    int age = Integer.parseInt(request.getParameter("age")); //年齢（String型で受け取るため、int型に変換）
    Gender gender = request.getParameter("gender").equals("male") ? Gender.Male : Gender.Female; //性別

   //挨拶コメントを取得するインスタンスを生成
    GreetingLogic logic = new GreetingLogic();
    //挨拶コメントを取得し、リクエストスコープに保持させる
    request.setAttribute("greeting", logic.getGreet());

   //UserBeanインスタンスの生成およびフィールドへの代入
    UserBean bean = new UserBean();
    bean.setFirstName(firstName);
    bean.setLastName(lastName);
    bean.setAge(age);
    bean.setGender(gender);

   //上記で生成、設定したUserBeanインスタンスをリクエストスコープに保持させる
    request.setAttribute("user", bean);

   //入力された値の確認画面へフォワード
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/confirm.jsp");
    dispatcher.forward(request, response);
  }
}