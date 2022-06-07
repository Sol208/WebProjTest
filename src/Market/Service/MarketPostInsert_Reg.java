package Market.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Market.Market_Service;
import Market.Model.MarketDAO;
import Market.Model.MarketDTO;
import Member_p.Model_p.CorpMemberDTO;
import Member_p.Model_p.MemberDTO;

public class MarketPostInsert_Reg implements Market_Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		MarketDTO dto = new MarketDTO();
		dto.setPost_id("market" + System.currentTimeMillis());
		dto.setUser_id(request.getParameter("userId"));
		dto.setUser_num(Integer.parseInt(request.getParameter("userNum")));
		dto.setUser_email(request.getParameter("userEmail"));
		dto.setTitle(request.getParameter("title"));
		dto.setCheck_quality(request.getParameter("check_quality"));
		dto.setL_category(request.getParameter("l_category"));
		dto.setS_category(request.getParameter("s_category"));
		dto.setDelivery(request.getParameter("delivery"));
		dto.setPrice(Integer.parseInt(request.getParameter("price")));
		dto.setContent(request.getParameter("content"));

		new MarketDAO().insert(dto);

		request.setAttribute("msg", "작성되었습니다.");
		request.setAttribute("goUrl", "PostList");
		request.setAttribute("mainUrl", "alert");

	}
}
