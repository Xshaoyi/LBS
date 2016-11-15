package pwc.LBS.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class DefaultWrapperServlet extends HttpServlet {

	/**
	 * 图片url映射
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = req.getContextPath();
		String pathw = req.getServletPath();
		String path1 = req.getRequestURL().toString();
		String imgName = path1.substring(path1.lastIndexOf("/")+1);
		String path2 = req.getContextPath();
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/script/app/img/phones/"+imgName);
    	
    	rd.forward(req, resp);
	}
	

}
