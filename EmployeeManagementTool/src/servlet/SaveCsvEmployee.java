package servlet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Employee;
import dao.EmployeeDAO;


/**
 * Servlet implementation class SaveCsvEmployee
 */
@WebServlet("/SaveCsvEmployee")
public class SaveCsvEmployee extends HttpServlet {
	/**
	   * CSVファイルの名前
	   * (環境に合わせて書き換えてください)
	   */
	  private static final String CSV_FILE = "c:\\CodeCamp\\detabase.csv";
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveCsvEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ArrayList<Employee> employees = new ArrayList<>();
		employees = new EmployeeDAO().findAll();

		// CSVファイルの書き込み処理
	    try {

	    	FileWriter f = new FileWriter(CSV_FILE, false);
            PrintWriter p = new PrintWriter(new BufferedWriter(f));

	      // データをCSV形式で書き込み
	      for (Employee emp : employees) {
	        p.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s%n",
	        			emp.getId(),emp.getEmpId(),emp.getEmpName(),emp.getEmpAge(),
	        			emp.getEmpGender(),emp.getPhotoId(),emp.getZip(),emp.getPref(),
	        			emp.getCity(),emp.getDptId(),emp.getEntryDate(),emp.getResignDate()));
	      }
	      p.close();
	      request.getRequestDispatcher("/employRegist.jsp?result=CSV保存").forward(request, response);
	    } catch (IOException e) {
	      e.printStackTrace();
	      request.getRequestDispatcher("/employErrer.jsp?result=CSV保存").forward(request, response);
	    }
	}

}
