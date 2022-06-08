package MyPage.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MyPage.MyPage_Service;

public class MyPageMemberEdit implements MyPage_Service{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		request.setAttribute("mainUrl", "mypage/MemberEdit");
	}

}
