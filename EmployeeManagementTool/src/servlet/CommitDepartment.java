package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Department;
import dao.DepartmentDAO;

/**
 * Servlet implementation class CommitDepartment
 */
@WebServlet("/CommitDepartment")
public class CommitDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommitDepartment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Department department = new Department();

		department.setId(Integer.parseInt(request.getParameter("id")));
		department.setDptId(request.getParameter("dptId"));
		department.setDptName(request.getParameter("dptName"));

		int result = 0;
		if(department.getId() == 0) {
			result = new DepartmentDAO().insert(department);
		}else {
			result = new DepartmentDAO().update(department);
		}

		if(result == 1) {
			request.getRequestDispatcher("/departRegist.jsp?result=登録").forward(request, response);
		}else {
			request.getRequestDispatcher("/departErrer.jsp?result=登録").forward(request, response);
		}
	}

}