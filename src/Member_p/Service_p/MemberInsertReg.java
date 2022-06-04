package Member_p.Service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Member_p.MemberService;
import Member_p.Model_p.MemberDAO;
import Member_p.Model_p.MemberDTO;

public class MemberInsertReg implements MemberService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
			
			int phonenum = Integer.parseInt(request.getParameter("phonenum1")+
					request.getParameter("phonenum2")+
					request.getParameter("phonenum3"));
			
			MemberDTO dto = new MemberDTO();
			dto.setPid(request.getParameter("pid"));
			dto.setPw(request.getParameter("pw"));
			dto.setpName(request.getParameter("pname"));
			dto.setGender(request.getParameter("gender"));
			dto.setEmail(request.getParameter("email"));
			dto.setTelecom(request.getParameter("telecom"));
			dto.setPhoneNum(phonenum);
			dto.setAddress(request.getParameter("address"));
			
			new MemberDAO().insert(dto);
			
			String msg = "회원가입 되었습니다.", goUrl ="Main"; 
			
			request.setAttribute("msg", msg);
			request.setAttribute("goUrl", goUrl);
			request.setAttribute("mainUrl", "alert");
	}

}
