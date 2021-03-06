package Market.Service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Comment.Model.CommentDAO;
import Comment.Model.CommentDTO;
import Market.Market_Service;
import Market.Model.MarketDAO;

public class MarketPostDetail_Reg implements Market_Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		if (session.getAttribute("User") == null) {
			request.setAttribute("msg", "로그인이 필요합니다.");
			request.setAttribute("goUrl", "/Member/Login");
			request.setAttribute("mainUrl", "alert");
		} else {

			String post_id = (String) request.getParameter("post_id");
			MarketDAO dao = new MarketDAO();
			
			ArrayList<CommentDTO> comment_list = new CommentDAO().list(post_id);
			Object post_data = dao.detail(post_id);
			
			request.setAttribute("post_dto", post_data);
			request.setAttribute("comment_dto", comment_list);

			request.setAttribute("mainUrl", "market/PostDetail");
		}
	}
}
