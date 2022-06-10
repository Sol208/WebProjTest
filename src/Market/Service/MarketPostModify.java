package Market.Service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Market.Market_Service;
import Market.Model.MarketDAO;
import Market.Model.MarketDTO;

public class MarketPostModify implements Market_Service{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
			
		String post_id = (String)request.getParameter("post_id");
		MarketDAO dao = new MarketDAO();
		Object data = dao.detail(post_id);
		MarketDTO dto = (MarketDTO) data;
		int cnt = 0;
		
		if(!dto.getImg().equals("")) {
			String[] img_Cnt = dto.getImg().split(",");
			cnt = img_Cnt.length;
		}
		
		request.setAttribute("img_Cnt", cnt);
		request.setAttribute("dto", data);
		request.setAttribute("mainUrl", "market/PostModify");
	}

}
