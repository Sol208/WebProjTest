package mypage_modify.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Member_p.Model_p.CorpMemberDTO;
import mypage_modify.MyPage_Modify_Service;

public class MyPage_Modify_CorpMemberEdit implements MyPage_Modify_Service{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
			
		HttpSession session = request.getSession();
		CorpMemberDTO dto = (CorpMemberDTO)session.getAttribute("User");
		String[] email_arr = dto.getCorp_email().split("@");
		
		
		
		request.setAttribute("email", email_arr[0]);
		request.setAttribute("email_adress", email_arr[1]);
		request.setAttribute("user_data", dto);
		request.setAttribute("mainUrl", "mypage/modify/CorpMemberEdit");
	}

}
