package MyPage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/MyPage/*")
public class MyPage_Controller extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	ArrayList<String> nonClass;

	public MyPage_Controller() {
	        super();
	        nonClass = new ArrayList<String>();
	        nonClass.add("InputPass");
	    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String serviceStr = req.getRequestURI().substring(
				(req.getContextPath() + "/MyPage/").length());
		System.out.println("ServiceStr ==> " + serviceStr);
		req.setCharacterEncoding("utf-8");
		
		if(nonClass.contains(serviceStr)) {
			req.setAttribute("mainUrl", "mypage/"+serviceStr);
		}else {
			try {
				MyPage_Service serv = (MyPage_Service)Class.forName("MyPage.Service.MyPage" + serviceStr).newInstance();
				serv.execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/member/template.jsp"); 
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
