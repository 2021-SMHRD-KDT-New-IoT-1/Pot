package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BoardDAO;

@WebServlet("/DEditService")
public class DEditService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String getBo_num = request.getParameter("bo_num");
		
		int bo_num = Integer.parseInt(getBo_num);
		
		BoardDAO bdao = new BoardDAO();
		int cnt = bdao.updateBoard(title, content, bo_num);
		
		if (cnt > 0) {
			System.out.println("게시글 수정 성공");

			response.sendRedirect("PlantDiaryMain.jsp");

		} else {
			System.out.println("게시글 수정 실패");
			response.sendRedirect("Main.jsp");
		}
	}

}
