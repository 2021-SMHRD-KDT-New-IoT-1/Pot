package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.PlantDAO;

@WebServlet("/JoinPlant")
public class JoinPlant extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String comment = request.getParameter("comment");
		String ptNick = request.getParameter("ptNick");
		int mem_num = Integer.parseInt(request.getParameter("mem_num"));

		PlantDAO dao = new PlantDAO();
		int cnt = dao.joinPlant(comment, ptNick, mem_num);

		if (cnt > 0) {
			System.out.println("식물 등록 성공");

			RequestDispatcher rd = request.getRequestDispatcher("Plant_Join_success.jsp");

			request.setAttribute("ptNick", ptNick);

			rd.forward(request, response);

		} else {
			System.out.println("식물 등록 실패");
			response.sendRedirect("main.jsp");
		}

	}

}
