package mypage_modify;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/mypage/modify/*")
public class MyPage_Modify_Controller extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	ArrayList<String> nonClass;

	public MyPage_Modify_Controller() {
	        super();
	        nonClass = new ArrayList<String>();
	        nonClass.add("InputPass");
	    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String serviceStr = req.getRequestURI().substring(
				(req.getContextPath() + "/mypage/modify/").length());
		System.out.println("ServiceStr ==> " + serviceStr);
		req.setCharacterEncoding("utf-8");
		
		if(nonClass.contains(serviceStr)) {
			req.setAttribute("mainUrl", "mypage/modify/"+serviceStr);
		}else {
			try {
				MyPage_Modify_Service serv = (MyPage_Modify_Service)Class.forName("mypage_modify.service.MyPage_Modify_" + serviceStr).newInstance();
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
