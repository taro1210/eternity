package servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Photo;
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("image/jpeg");

		Photo photo = new Photo();
		photo = new PhotoDAO().findById(Integer.parseInt(request.getParameter("count")));

		 BufferedImage img = photo.getPhoto(); //画像データを取得
		 OutputStream os = response.getOutputStream();
		 try {
		ImageIO.write(img, "jpg", os);
		 }
		 catch (IOException e) {
		}
		os.flush();

		response.sendRedirect("/EmployeeManagementTool/employEdit.jsp");


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}