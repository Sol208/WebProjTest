package Member_p.Service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Member_p.MemberService;
import Member_p.Model_p.CorpMemberDAO;
import Member_p.Model_p.CorpMemberDTO;
import Member_p.Model_p.MemberDAO;
import Member_p.Model_p.MemberDTO;

public class MemberFindIdReg implements MemberService{
	
	@Override	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
			String email = request.getParameter("email");
			String memberKind = (String) request.getParameter("memberkind");
			System.out.println("memberKind ===> " + memberKind);
			
			if(memberKind.equals("개인회원")) {
				MemberDTO dto = new MemberDAO().findId(email);
				
				request.setAttribute("userId", dto.getPid());
			} else if(memberKind.equals("법인회원")) {
				CorpMemberDTO dto = new CorpMemberDAO().findId(email);
				System.out.println("MemberFindIdReg ===> " + "법인");
				request.setAttribute("userId", dto.getPid());

			}
			
			
			request.setAttribute("mainUrl", "member/FindIdReg");
			
	}

}
