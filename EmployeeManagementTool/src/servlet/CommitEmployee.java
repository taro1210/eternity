package servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import beans.Employee;
import beans.Photo;
import dao.EmployeeDAO;
import dao.PhotoDAO;

/**
 * Servlet implementation class CommitEmployee
 */
@WebServlet("/CommitEmployee")
@MultipartConfig
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

		Photo photo = new Photo();
		Employee employee = new Employee();
		PhotoDAO dao = new PhotoDAO();

		Part fPart = request.getPart("img");
		InputStream is = fPart.getInputStream();
		String id = request.getParameter("id");
		Photo p = dao.findById(Integer.parseInt(id));
		if(p == null) {
			id = "0";
		}

		photo.setId(Integer.parseInt(id));
		photo.setPhotoId(request.getParameter("id"));
		photo.setPhoto(is);
		int rstPhoto = 0;
		if(photo.getId() == 0){
			rstPhoto = dao.insert(photo);
		}else {
			rstPhoto = dao.update(photo);
		}


		if (rstPhoto == 1) {
			employee.setPhotoId(photo.getPhotoId());
		}else {
			employee.setPhotoId(null);
		}
		System.out.println(employee.getPhotoId());



		employee.setId(Integer.parseInt(request.getParameter("id")));
		employee.setEmpId(request.getParameter("empId"));
		employee.setEmpName(request.getParameter("empFamillyName") + "　" + request.getParameter("empFirstName"));
		employee.setEmpAge(Integer.parseInt(request.getParameter("empAge")));
		employee.setEmpGender(request.getParameter("gender"));
		employee.setZip(request.getParameter("firstZip") + "-" + request.getParameter("secondZip"));
		employee.setPref(request.getParameter("pref"));
		employee.setCity(request.getParameter("city"));
		employee.setDptId(request.getParameter("dptId"));
		employee.setEntryDate(request.getParameter("entryYear") + "-" + request.getParameter("entryMonth") + "-"+ request.getParameter("entryDay"));

		// 退社日は登録されなければ空白を返す
		if(request.getParameter("resignYear").equals("") || request.getParameter("resignMonth").equals("")
			|| request.getParameter("resignDay").equals("")){
			employee.setResignDate("");
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
			request.getRequestDispatcher("/employRegist.jsp?result=登録").forward(request, response);
		}else {
			request.getRequestDispatcher("/employErrer.jsp?result=登録").forward(request, response);
		}
	}
}