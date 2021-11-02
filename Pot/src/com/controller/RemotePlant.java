package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.CalendarDAO;

@WebServlet("/RemotePlant")
public class RemotePlant extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String pt_num = request.getParameter("pt_num");

		System.out.println(pt_num);

		CalendarDAO cdao = new CalendarDAO();
		int cnt = cdao.waterPump(pt_num);

		if (cnt > 0) {
			System.out.println("입력성공");

			response.sendRedirect("SelectPlant.jsp");
		} else {
			System.out.println("입력실패");
			response.sendRedirect("Main.jsp");
		}
	}

}
