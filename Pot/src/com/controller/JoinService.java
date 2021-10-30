package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.MemberDAO;



@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String nick = request.getParameter("nick");

		MemberDAO dao = new MemberDAO();
		int cnt = dao.join(email, pw, tel, nick);

		if (cnt > 0) {
			System.out.println("가입성공");

			RequestDispatcher rd = request.getRequestDispatcher("Member_Join_success.jsp");

			request.setAttribute("nick", nick);

			rd.forward(request, response);

		} else {
			System.out.println("가입실패");
			response.sendRedirect("Main.jsp");
		}

	}

}
