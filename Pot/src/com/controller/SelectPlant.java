package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberDAO;
import com.model.MemberVO;
import com.model.PlantDAO;
import com.model.PlantVO;

@WebServlet("/SelectPlant")
public class SelectPlant extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		MemberVO vo = (MemberVO) session.getAttribute("member");
		
		PlantDAO pdao = new PlantDAO();
		
		String mem_num = vo.getMem_num();
		System.out.println("아이디" + mem_num);
		ArrayList<PlantVO> pvo = pdao.selectPlant(mem_num);
		
		if (pvo != null) {
			System.out.println("실행1");
			// 세션 객체 생성, 서블렛이아니라서 리퀘스트나 리스폰스를 못함
			session = request.getSession();
			
			// 세션 값 설정
			session.setAttribute("plant", pvo);
			System.out.println("실행2");
			System.out.println("조회 성공");

			response.sendRedirect("SelectPlant.jsp");
	
		}else {
			
			System.out.println("조회 실패");
			
			response.sendRedirect("Main.jsp");
		}
		
	}

}
