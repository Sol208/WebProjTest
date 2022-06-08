package MyPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MyPage_Service {

	void execute(HttpServletRequest request, HttpServletResponse response);
	
}
