package Comment;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Market.Market_Service;

@WebServlet("/Comment/*")
public class Comment_Controller extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String serviceStr = req.getRequestURI().substring(
					(req.getContextPath() + "/Comment/").length());
			System.out.println("ServiceStr ==> " + serviceStr);
			
			try {
				Comment_Service serv = (Comment_Service) Class.forName("Comment.Service.Comment" + serviceStr)
						.newInstance();
				serv.execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher dispatcher = req.getRequestDispatcher("/member/template.jsp"); 
			dispatcher.forward(req, resp);
			
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
