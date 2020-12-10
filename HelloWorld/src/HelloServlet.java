import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//	localhost:8080/hs -> 요청을 처리하도록
//	서블릿 생성을 위해 HttpServlet을 상속 받아야 한다
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, //	요청 정보 객체
			HttpServletResponse resp) throws ServletException, IOException {	//	응답 정보 객체
		//	GET 방식의 요청을 처리
		//	요청에서 name 파라미터를 받아와서 출력
		String name = req.getParameter("name");	//	name 파라미터 받아오기
		if (name == null) {
			name = "Unknown";
		}
		//	출력 : 응답 객체로부터 PrintWriter를 받아와서 내용을 출력
		PrintWriter out = resp.getWriter();
		out.println("<h1>Hello Servlet</h1>");
		out.println("<p>Welcome," + name + "</p>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//	POST 방식의 요청을 처리
		//	파라미터를 받아올 때 파라미터의 적절한 인코딩 정보를 전달
//		req.setCharacterEncoding("UTF-8");
		//	데이터 불러오기
		String firstName = req.getParameter("first_name");
		String lastName = req.getParameter("last_name");

		//	출력
		//	응답의 타입과 인코딩 정보를 출력
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<h1>Form Data</h1>");
		out.println("<p>Family Name: " + lastName + "</p>");
		out.println("<p>First Name: " + firstName + "</p>");
	}

}
