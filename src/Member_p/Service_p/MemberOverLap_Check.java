package Member_p.Service_p;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Member_p.MemberService;
import Member_p.Model_p.CorpMemberDAO;
import Member_p.Model_p.MemberDAO;

public class MemberOverLap_Check implements MemberService{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
			String user_id = request.getParameter("pid");
			
			String checkId = "false";
			if(user_id.equals("")) {
				checkId = "null";
			} else if(new MemberDAO().idCheck(user_id).equals("useable") && new CorpMemberDAO().idCheck(user_id).equals("userable")) {
				checkId = "true";
			} else if(new MemberDAO().idCheck(user_id).equals("unuseable") || new CorpMemberDAO().idCheck(user_id).equals("unuseable")) {
				checkId = "false";
			}
			
			try {
				response.getWriter().append(checkId);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	}

}
