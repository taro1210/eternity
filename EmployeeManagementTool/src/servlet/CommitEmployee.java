package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Employee;
import dao.EmployeeDAO;

/**
 * Servlet implementation class CommitEmployee
 */
@WebServlet("/CommitEmployee")
public class CommitEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommitEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		Employee employee = new Employee();

		employee.setId(Integer.parseInt(request.getParameter("id")));
		employee.setEmpId(request.getParameter("empId"));
		employee.setEmpName(request.getParameter("empFamillyName") + "　" + request.getParameter("empFirstName"));
		employee.setEmpAge(Integer.parseInt(request.getParameter("empAge")));
		employee.setEmpGender(request.getParameter("gender"));
		//employee.setPhotoId(request.getParameter("photoId"));  ←今はまだ未定義なので…
		employee.setZip(request.getParameter("firstZip") + "-" + request.getParameter("secondZip"));
		employee.setPref(request.getParameter("pref"));
		employee.setCity(request.getParameter("city"));
		employee.setDptId(request.getParameter("dptId"));
		employee.setEntryDate(request.getParameter("entryYear") + "-" + request.getParameter("entryMonth") + "-"+ request.getParameter("entryDay"));

		// 退社日は登録されなければnullを返す
		if(request.getParameter("resignYear").equals("") || request.getParameter("resignMonth").equals("")
			|| request.getParameter("resignDay").equals("")){
			employee.setResignDate(null);
		}else{
			employee.setResignDate(request.getParameter("resignYear") + "-" + request.getParameter("resignMonth") + "-"+ request.getParameter("resignDay"));
		}

		int result = 0;
		if(employee.getId() == 0) {
			result = new EmployeeDAO().insert(employee);
		}else {
			result = new EmployeeDAO().update(employee);
		}

		if(result == 1) {
			request.getRequestDispatcher("/employRegist.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/employErrer.jsp").forward(request, response);
		}
	}

}