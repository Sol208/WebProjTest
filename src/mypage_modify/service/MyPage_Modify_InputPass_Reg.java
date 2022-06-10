package mypage_modify.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Member_p.Model_p.CorpMemberDTO;
import Member_p.Model_p.MemberDTO;
import mypage_modify.MyPage_Modify_Service;

public class MyPage_Modify_InputPass_Reg implements MyPage_Modify_Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		String user_pw = request.getParameter("user_pw");
		String msg = "비밀번호를 확인해주세요";
		String goUrl = "InputPass";

		try {
			MemberDTO dto = (MemberDTO) session.getAttribute("User");
			if (dto.getGrade() == 2) {
				if (dto.getPw().equals(user_pw)) {
					msg = "확인되었습니다.";
					goUrl = "MemberEdit";
				} else {
					msg = "비밀번호를 확인해주세요";
					goUrl = "InputPass";
				}
			} else if (dto.getGrade() == 3) {
				if (dto.getPw().equals(user_pw)) {
					msg = "확인되었습니다.";
					goUrl = "CorpMemberEdit";
				} else {
					msg = "비밀번호를 확인해주세요";
					goUrl = "InputPass";
				}
			}
		} catch (ClassCastException e) {
			System.out.println("법인회원입니다.");
			e.printStackTrace();
		}
		try {
			CorpMemberDTO dto = (CorpMemberDTO) session.getAttribute("User");
			if (dto.getGrade() == 2) {
				if (dto.getPw().equals(user_pw)) {
					msg = "확인되었습니다.";
					goUrl = "MemberEdit";
				} else {
					msg = "비밀번호를 확인해주세요";
					goUrl = "InputPass";
				}
			} else if (dto.getGrade() == 3) {
				if (dto.getPw().equals(user_pw)) {
					msg = "확인되었습니다.";
					goUrl = "CorpMemberEdit";
				} else {
					msg = "비밀번호를 확인해주세요";
					goUrl = "InputPass";
				}
			}
		} catch (ClassCastException e) {
			System.out.println("일반회원입니다.");
			e.printStackTrace();
		}

		request.setAttribute("msg", msg);
		request.setAttribute("mainUrl", "alert");
		request.setAttribute("goUrl", goUrl);
	}

}
