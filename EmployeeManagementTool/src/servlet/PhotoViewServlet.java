package servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PhotoDAO;

/**
 * Servlet implementation class PhotoViewServlet
 */
@WebServlet("/PhotoViewServlet")
public class PhotoViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhotoViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BufferedInputStream bis = new PhotoDAO().findByPhoto(Integer.parseInt(request.getParameter("count")));
		response.setContentType("image/jpeg");
		ServletOutputStream os = response.getOutputStream();
		BufferedOutputStream bout = new BufferedOutputStream(os);
		int ch = 0;
		while ((ch = bis.read()) != -1) {
			bout.write(ch);
		}
 	}
}