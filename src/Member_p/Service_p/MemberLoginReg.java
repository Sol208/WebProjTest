package Member_p.Service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Member_p.MemberService;
import Member_p.Model_p.MemberDAO;
import Member_p.Model_p.MemberDTO;

public class MemberLoginReg implements MemberService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String inputId = (String) request.getParameter("pid");
		String inputPw = (String) request.getParameter("pw");
		
		MemberDTO dto = new MemberDAO().detail(inputId);
		String msg = "로그인 실패";
		String goUrl = "main";
		
		if(dto == null) {
			msg = "아이디를 확인해주세요";
			goUrl = "Login";
		}else {
			if(inputPw.equals(dto.getPw())) {
				msg = "로그인 성공!";
				goUrl = "Main"; // 원래는 nowpage가 들어가야함
				HttpSession session = request.getSession();
				session.setAttribute("UserData", dto);
				
			} else {
				msg = "비밀번호를 확인해주세요";
				goUrl = "Login";
			}
			
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("mainUrl", "alert");
		request.setAttribute("goUrl", goUrl); //Controller에서 nowpage를 Attribute로 전달받아 로그인 전 조회중이던 페이지로 이동해야함
		
	}
	
	

}
