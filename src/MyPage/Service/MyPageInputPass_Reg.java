package MyPage.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Member_p.Model_p.MemberDTO;
import MyPage.MyPage_Service;

public class MyPageInputPass_Reg implements MyPage_Service{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();			
		MemberDTO dto = (MemberDTO)session.getAttribute("User");
		String user_pw = request.getParameter("user_pw");
		String msg = "비밀번호를 확인해주세요";
		String goUrl = "mypage/InputPass";
		
		System.out.println(user_pw);
		
		if (dto.getPw().equals(user_pw)) {
			msg = "확인되었습니다.";
			goUrl = "MemberEdit";
		} else {
			msg = "비밀번호를 확인해주세요";
			goUrl = "InputPass";
		};
		
		request.setAttribute("msg", msg);
		request.setAttribute("mainUrl", "alert");
		request.setAttribute("goUrl", goUrl); //Controller에서 nowpage를 Attribute로 전달받아 로그인 전 조회중이던 페이지로 이동해야함
		
	}

}
