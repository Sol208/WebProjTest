package Member_p;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Member/*")
public class Member_Controller extends HttpServlet{
	private static final long serialVersionUID = 1L;

	ArrayList<String> nonClass;
	
	ArrayList<String> nonTemplate;
	
    public Member_Controller() {
        super();
        nonClass = new ArrayList<String>();
        nonClass.add("Main");
        nonClass.add("TypeSelect");
        nonClass.add("Login");
        nonClass.add("InsertCorpMember");
        nonClass.add("InsertMember");
        nonClass.add("FindId");
        nonClass.add("FindPw_CheckId");
        
        nonTemplate= new ArrayList<String>();
        nonTemplate.add("OverLap_Check");
        
        
        
    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String serviceStr = req.getRequestURI().substring(
				(req.getContextPath() + "/Member/").length());
		System.out.println("ServiceStr ==> " + serviceStr);
		req.setCharacterEncoding("utf-8");
		
		if(nonClass.contains(serviceStr)) {
			req.setAttribute("mainUrl", "member/"+serviceStr);
		}else {
			try {
				MemberService serv =
						(MemberService)Class.forName("Member_p.Service_p.Member" + serviceStr).newInstance();
				serv.execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		
		if(!nonTemplate.contains(serviceStr)) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/member/template.jsp"); 
			dispatcher.forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}
