package com.bit.utils.emaillist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.utils.emaillist.dao.EmaillistDao;
import com.bit.utils.emaillist.dao.EmaillistDaoOrcl;
import com.bit.utils.emaillist.vo.EmaillistVo;

//	Controller 역할을 담당하는 Servlet
//	web.xml 내에 servlet과 setvlet-mapping을 등록 한 것과 동일한 효과
@WebServlet(name="Emaillist", urlPatterns="/el")
public class EmaillistServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//	파라미터 a를 확인해서 a.equals("form")이면 form.jsp로 포워드
		String action = req.getParameter("a");
//		if (action.equals("from")) -> 안되요! null일 수 있어요
		if ("form".equals(action)) {
			//	폼 페이지로 Forward
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/emaillist/form.jsp");
			rd.forward(req, resp);
		} else {
			//	목록
			EmaillistDao dao = new EmaillistDaoOrcl();
			List<EmaillistVo> list = dao.getList();
			//	처리 중인 req, resp -> /WEB-INF/views/emaillist/index.jsp 쪽으로 처리 주도권을 넘기기
			//	(Forward)
			//	JSP에게 처리한 목록 전달해 줘야 함
			req.setAttribute("list", list);
			//	Forward를 위한 RequestDispatcher
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/emaillist/index.jsp");
			//	Forward
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//	저장 처리
		String lastName = req.getParameter("ln");
		String firstName = req.getParameter("fn");
		String email = req.getParameter("email");

		//	DTO 객체 생성, 설정
		EmaillistVo vo = new EmaillistVo();
		vo.setLastName(lastName);
		vo.setFirstName(firstName);
		vo.setEmail(email);
		
		//	DAO
		EmaillistDao dao = new EmaillistDaoOrcl();
		dao.insert(vo);
		
		//	주소록 메인 페이지로 Redirect
		resp.sendRedirect(req.getContextPath() + "/el");
	}

}
