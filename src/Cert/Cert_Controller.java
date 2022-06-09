package Cert;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Member_p.MemberService;

@WebServlet("/Cert/*")
public class Cert_Controller extends HttpServlet{
	private static final long serialVersionUID = 1L;
	ArrayList<String> nonClass;

	public Cert_Controller() {
        nonClass = new ArrayList<String>();
        nonClass.add("authCodeCheck");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String serviceStr = req.getRequestURI().substring(
				(req.getContextPath() + "/Cert/").length());
		System.out.println("ServiceStr ==> " + serviceStr);
		
		if(nonClass.contains(serviceStr)) {
			req.setAttribute("mainUrl", "member/"+serviceStr);
		}else {
			try {
				CertService serv =
						(CertService)Class.forName("Cert.Service.Cert" + serviceStr).newInstance();
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
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}
