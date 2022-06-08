package Comment.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Comment.Comment_Service;
import Comment.Model.CommentDAO;
import Comment.Model.CommentDTO;

public class CommentInsert implements Comment_Service{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String post_id = request.getParameter("post_id");
		String page = request.getParameter("page");
		String comment = request.getParameter("comment");
		String user_id = request.getParameter("user_id");
		
		CommentDTO dto = new CommentDTO();
		dto.setPost_id(post_id);
		dto.setComment_id("comment" + System.currentTimeMillis());
		dto.setComment_writer(user_id);
		dto.setContent(comment);
		
		
		new CommentDAO().insert(dto);
		
		request.setAttribute("msg", "댓글이 작성되었습니다.");
		request.setAttribute("goUrl", "/Market/PostDetail_Reg?post_id="+post_id+"&page="+page);
		request.setAttribute("mainUrl", "alert");
	}
	
}
