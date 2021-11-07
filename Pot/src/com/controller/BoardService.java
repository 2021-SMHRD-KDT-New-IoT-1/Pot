package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.BoardDAO;
import com.model.BoardVO;
import com.model.MemberVO;
import com.model.PlantDAO;
import com.model.PlantVO;

@WebServlet("/BoardService")
public class BoardService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		MemberVO vo = (MemberVO) session.getAttribute("member");
		
		BoardDAO bdao = new BoardDAO();
		
		String mem_num = vo.getMem_num();
		System.out.println("���̵�: " + mem_num);
		ArrayList<BoardVO> bvo = bdao.listBoard(mem_num);
		
		if (bvo != null) {
			// ���� ��ü ����, �����̾ƴ϶� ������Ʈ�� ���������� ����
			session = request.getSession();
			
			// ���� �� ����
			session.setAttribute("board", bvo);
			System.out.println("�Խñ� ��ȸ ����");

			response.sendRedirect("PlantDiaryMain.jsp");
	
		}else {
			
			System.out.println("�Խñ� ��ȸ ����");
			
			response.sendRedirect("Main.jsp");
		}
	}

}
