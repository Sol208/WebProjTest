package Market.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Market.Market_Service;
import Market.Model.MarketDAO;
import Market.Model.MarketDTO;

public class MarketPostInsert implements Market_Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		if (session.getAttribute("User") == null) {
			request.setAttribute("msg", "로그인이 필요합니다.");
			request.setAttribute("goUrl", "/Member/Login");
			request.setAttribute("mainUrl", "alert");
		} else {
			request.setAttribute("mainUrl", "market/PostInsert");
		}
	}
}
