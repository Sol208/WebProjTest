package mypage_modify.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Member_p.Model_p.MemberDAO;
import Member_p.Model_p.MemberDTO;
import mypage_modify.MyPage_Modify_Service;

public class MyPage_Modify_MemberEdit_Reg implements MyPage_Modify_Service{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String pid = request.getParameter("pid");
		String pw = request.getParameter("pw");
		String nick_name = request.getParameter("nick_name");
		String pname = request.getParameter("pname");
		String gender = request.getParameter("gender");
		String phonenum = request.getParameter("phonenum");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String email = email1 + "@" + email2;
// ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
		String address = request.getParameter("address");
		String detailAddress = request.getParameter("detailAddress");
// ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
		
		MemberDTO dto = new MemberDTO();
		
		dto.setPid(pid);
		dto.setPw(pw);
		dto.setNick_name(nick_name);
		dto.setpName(pname);
		dto.setGender(gender);
		dto.setPhoneNum(phonenum);
		dto.setEmail(email);
// ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
		dto.setAddress(address);
		dto.setDetailAddress(detailAddress);
// ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
		
		new MemberDAO().editInfo(dto);
		
		request.setAttribute("msg", "회원정보가 수정되었습니다.");
		request.setAttribute("mainUrl", "alert");
		request.setAttribute("goUrl", "InputPass");	
	}
}
