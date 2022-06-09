package mypage_modify.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Member_p.Model_p.MemberDTO;
import mypage_modify.MyPage_Modify_Service;

	public class MyPage_Modify_MemberEdit implements MyPage_Modify_Service{
		
		@Override
		public void execute(HttpServletRequest request, HttpServletResponse response) {
			HttpSession session = request.getSession();
			MemberDTO dto = (MemberDTO)session.getAttribute("User");
			
			String[] email_arr = dto.getEmail().split("@");
			
			
			
			request.setAttribute("email", email_arr[0]);
			request.setAttribute("email_adress", email_arr[1]);
			request.setAttribute("user_data", dto);
			request.setAttribute("mainUrl", "mypage/modify/MemberEdit");
		}
		
	}
