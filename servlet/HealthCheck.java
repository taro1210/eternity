package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Health;
import model.HealthCheckLogic;

@WebServlet("/HealthCheck")
public class HealthCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher dpc = request.getRequestDispatcher("/WEB-INF/jsp/healthCheck.jsp");
		dpc.forward(request,response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		//double weight2 = Double.parseDouble(request.getParameter("weight"));
		String name = request.getParameter("name");

		Health health = new Health();
		health.setName(name);
		health.setHeight(Double.parseDouble(height));
		health.setWeight(Double.parseDouble(weight));

		HealthCheckLogic hcl = new HealthCheckLogic();
		hcl.exe(health);

		request.setAttribute("health", health);

		RequestDispatcher dpc = request.getRequestDispatcher("/WEB-INF/jsp/healthCheckResult.jsp");
		dpc.forward(request,response);
	}

}
