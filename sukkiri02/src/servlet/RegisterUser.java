package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RegisterUserLogic;
import model.User;

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fowardPath = null;
		String action = request.getParameter("action");
		if(action == null){
			fowardPath ="/WEB-INF/jsp/registerForm.jsp";
		}else if(action.equals("done")){
			HttpSession session = request.getSession();
			User registerUser2 = (User)session.getAttribute("registerUser2");

			RegisterUserLogic logic = new RegisterUserLogic();
			logic.register(registerUser2);

			session.removeAttribute("registerUser2");
			fowardPath  = "/WEB-INF/jsp/registerDone.jsp";
		}

		RequestDispatcher dpc = request.getRequestDispatcher(fowardPath);
		dpc.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		User registerUser2 = new User(id, name, pass);

		HttpSession session = request.getSession();
		session.setAttribute("registerUser2",registerUser2);
		RequestDispatcher dpc = request.getRequestDispatcher("/WEB-INF/jsp/registarConfirm.jsp");
		dpc.forward(request, response);

	}

}
