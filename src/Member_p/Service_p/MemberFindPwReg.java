package Member_p.Service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Member_p.MemberService;
import Member_p.Model_p.CorpMemberDAO;
import Member_p.Model_p.CorpMemberDTO;
import Member_p.Model_p.MemberDAO;
import Member_p.Model_p.MemberDTO;

public class MemberFindPwReg implements MemberService{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String memberkind = request.getParameter("memberkind");
		
		
		
		System.out.println("MemberFindPwReg ===> " + memberkind);
		
		request.setAttribute("memberkind", memberkind);
		request.setAttribute("email", email);
		request.setAttribute("mainUrl", "member/FindPwReg");
	}

}
