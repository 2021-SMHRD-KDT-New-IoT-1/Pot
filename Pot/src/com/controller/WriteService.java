package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BoardDAO;
import com.model.MemberDAO;

@WebServlet("/WriteService")
public class WriteService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String gatMem_num = request.getParameter("mem_num");
		
		int mem_num = Integer.parseInt(gatMem_num);
		
		BoardDAO bdao = new BoardDAO();
		int cnt = bdao.writeBoard(title, content, mem_num);
		
		if (cnt > 0) {
			System.out.println("게시글 등록 성공");

			response.sendRedirect("PlantDiaryMain.jsp");

		} else {
			System.out.println("게시글 등록 실패");
			response.sendRedirect("Main.jsp");
		}
		
	}

}
