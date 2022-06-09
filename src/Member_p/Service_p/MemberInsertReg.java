package Member_p.Service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Member_p.MemberService;
import Member_p.Model_p.MemberDAO;
import Member_p.Model_p.MemberDTO;

public class MemberInsertReg implements MemberService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
			
			String email = request.getParameter("email1") + "@" + request.getParameter("email2");
			int grade = 2;
						
			MemberDTO dto = new MemberDTO();
			dto.setPid(request.getParameter("pid"));
			dto.setPw(request.getParameter("pw"));
			dto.setNick_name(request.getParameter("nick_name"));
			dto.setpName(request.getParameter("pname"));
			dto.setGender(request.getParameter("gender"));
			dto.setEmail(email);
			dto.setTelecom(request.getParameter("telecom"));
			dto.setPhoneNum(request.getParameter("phonenum"));
			dto.setAddress(request.getParameter("address"));
			dto.setGrade(grade);
			
			new MemberDAO().insert(dto);
			
			String msg = "회원가입 되었습니다.", goUrl ="/Main/Main"; 
			
			request.setAttribute("msg", msg);
			request.setAttribute("goUrl", goUrl);
			request.setAttribute("mainUrl", "alert");
	}

}
