package Main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Member_p.MemberService;

@WebServlet("/Main/*")
public class Main_Controller extends HttpServlet{
	private static final long serialVersionUID = 1L;

	ArrayList<String> nonClass;
	
    public Main_Controller() {
        super();
        nonClass = new ArrayList<String>();
        nonClass.add("Main");
    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String serviceStr = req.getRequestURI().substring(
				(req.getContextPath() + "/Main/").length());
		System.out.println("ServiceStr ==> " + serviceStr);
		
		req.setCharacterEncoding("utf-8");
		
		if(nonClass.contains(serviceStr)) {
			req.setAttribute("mainUrl", serviceStr);
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/member/template.jsp"); 
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
