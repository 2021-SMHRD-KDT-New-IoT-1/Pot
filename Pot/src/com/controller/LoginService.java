package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberDAO;
import com.model.MemberVO;

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");

		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.login(email, pw);
		// 로그인 기능 작성
		// 로그인 가능할 경우 -> 콘솔에 "로그인성공" 출력
		// 로그인 불가능할 경우 -> 콘솔에 "로그인실패" 출력
		
		if (vo != null) {
			// 세션 객체 생성, 서블렛이아니라서 리퀘스트나 리스폰스를 못함
			HttpSession session = request.getSession();

			// 세션 값 설정
			session.setAttribute("member", vo);
			
			System.out.println("로그인 성공");

			response.sendRedirect("Main.jsp");
	
		}else {
			System.out.println("로그인 실패");
			
			response.sendRedirect("Main.jsp");
		}
	}

}
