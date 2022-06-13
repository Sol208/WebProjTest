package Member_p.Service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Member_p.MemberService;
import Member_p.Model_p.CorpMemberDAO;
import Member_p.Model_p.CorpMemberDTO;
import Member_p.Model_p.MemberDAO;
import Member_p.Model_p.MemberDTO;

public class MemberFindPw_CertEmail implements MemberService{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String memberkind = (String) request.getParameter("memberkind");
		String userId = request.getParameter("pid");
		
		if(memberkind.equals("개인회원")) {
			MemberDTO dto = new MemberDAO().findUser(userId);
			
			request.setAttribute("userEmail", dto.getEmail());
			request.setAttribute("mainUrl", "member/FindPw_CertEmail");
			request.setAttribute("memberkind", memberkind);
		} else if(memberkind.equals("법인회원")) {
			CorpMemberDTO dto = new CorpMemberDAO().findUser(userId);
			
			request.setAttribute("userEmail", dto.getEmail());
			request.setAttribute("mainUrl", "member/FindPw_CertEmail");
			request.setAttribute("memberkind", memberkind);
		}
	}
}
