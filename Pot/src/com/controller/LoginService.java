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
		// �α��� ��� �ۼ�
		// �α��� ������ ��� -> �ֿܼ� "�α��μ���" ���
		// �α��� �Ұ����� ��� -> �ֿܼ� "�α��ν���" ���
		
		if (vo != null) {
			// ���� ��ü ����, �����̾ƴ϶� ������Ʈ�� ���������� ����
			HttpSession session = request.getSession();

			// ���� �� ����
			session.setAttribute("member", vo);
			
			System.out.println("�α��� ����");

			response.sendRedirect("Main.jsp");
	
		}else {
			System.out.println("�α��� ����");
			
			response.sendRedirect("Main.jsp");
		}
	}

}
