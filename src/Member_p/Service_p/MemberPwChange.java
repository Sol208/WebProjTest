package Member_p.Service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Member_p.MemberService;
import Member_p.Model_p.CorpMemberDAO;
import Member_p.Model_p.CorpMemberDTO;
import Member_p.Model_p.MemberDAO;
import Member_p.Model_p.MemberDTO;

public class MemberPwChange implements MemberService{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String memberkind = request.getParameter("memberkind");
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String msg = "비밀번호 변경에 실패했습니다.";
		String goUrl = "/Main/Main";
		
		if(memberkind.equals("개인회원")) {
			MemberDTO dto = new MemberDAO().findId(email);
			dto.setPw(pw);
			new MemberDAO().pwChange(dto);
			msg = "변경된 비밀번호로 로그인 해주세요.";
			goUrl = "/Main/Main";
		} else if(memberkind.equals("법인회원")) {
			CorpMemberDTO dto = new CorpMemberDAO().findId(email);
			dto.setPw(pw);
			new CorpMemberDAO().pwChange(dto);
			msg = "변경된 비밀번호로 로그인 해주세요.";
			goUrl = "/Main/Main";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("mainUrl", "alert");
		request.setAttribute("goUrl", goUrl);
	}

}
