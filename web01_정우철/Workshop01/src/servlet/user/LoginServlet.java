package servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 
 * 
 * <servlet>
 * 	  <servlet-name>LoginServlet
 * 	  <servlet-class>servlet.use.LoginServlet
 * </servlet>
 * <servlet-mapping>
 * 	  <servlet-name>LoginServlet 
 * 	  <url-pattern>/LoginServlet
 * </servlet-mapping>
 * 
 *  
 * 
 */

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		//1. 폼에 입력된 값 받아서
		String id = request.getParameter("id"); //폼에 입력된 값 할당, 폼 이름
		String password = request.getParameter("password"); //폼에 입력된 값 할당, 폼 이름
		
		//2. 받은 값을 다시 웹브라우저로 전송해서 출력
		//서버 설정을 먼저 변경 ==> 그런다음에 서버를 plugin
//		request.setCharacterEncoding("UTF-8"); //이 부분이 지금은 적용 안된다...get방식일때는 소용 없다...서버에 처리한다
		response.setContentType("text/html;charset=utf-8"); //위치가 PrintWriter응답받기 전에 해줘야 한다.
		
		
	
		
		out.println("<html><body>");
		out.println("<h3><b>"+id+"</b>님이 로그인 되었습니다!!! </h3>"); //b는 볼드(진하게)
		out.println("<a href='#'>도서 등록</a><br>");
		out.println("<a href='#'>로그아웃</a>");
		out.println("</body></html>");
	}

}
