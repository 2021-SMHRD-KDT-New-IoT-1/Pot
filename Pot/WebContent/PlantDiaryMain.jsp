<%@page import="com.model.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="PlantDiaryMain.css">
<link rel="stylesheet" type="text/css" href="media(Plantdiary).css">
<link rel="stylesheet" type="text/css" href="style(Plantdiary).css">
<link rel="stylesheet" type="text/css" href="Main.css">
</head>

<body>
	<%
		request.setCharacterEncoding("UTF-8");
		
		MemberVO vo = (MemberVO)session.getAttribute("member");
		
		ArrayList<BoardVO> bList = (ArrayList)session.getAttribute("board");  
	%>
	<div class="main2">
		<div>
			<div class="header">
				<a href="Main.jsp"><img src="./img/Main_logo.png"
					style="margin: 6px"></a>
				<ul class="nav">
					<%if (vo==null) { %>
					<li><a href="login.jsp">로그인/회원가입</a></li>
					<% } else { %>
					<li><a href="Join_plant.jsp">식물 등록</a></li>
					<li><a href="SelectPlant">식물 관리</a></li>
					<li><a href="BoardService">나만의 식물일기</a></li>
					<li><a href="LogoutService">로그아웃</a></li>
					<% } %>
				</ul>
			</div>
			<hr id="topLine" color="darkgray" size="3px" width="100%">
			<div class="board_wrap">
				<div class="board_title">
					<strong>식물일기</strong>
					<p>나만의 식물일지를 적어보세요!</p>
				</div>
				<div class="board_list_wrap">
					<div class="board_list">
						<div class="top">
							<div class="num">번호</div>
							<div class="title">제목</div>
							<div class="writer">닉네임</div>
							<div class="date">작성일</div>
						</div>
						<% if (bList.size() < 10) {
						for (int i = 0; i < bList.size(); i++) { %>
						<div>
							<div class="num"><%=bList.size()-i %></div>
							<div class="title">
								<a href="PlantDiaryView.jsp?bo_num=<%=i %>&num=<%=bList.size()-i %>"><%=bList.get(i).getTitle() %></a>
							</div>
							<div class="writer"><%=vo.getNick() %></div>
							<div class="date"><%=bList.get(i).getDate().substring(0, 10) %></div>
						</div>							
						 <%}							
						} %>
					</div>
					<div class="board_page">
						<a href="#" class="bt first"><<</a> <a href="#" class="bt prev"><</a>
						<a href="#" class="num on">1</a><a href="#" class="bt next">></a> <a
							href="#" class="bt last">>></a>
					</div>
					<div class="bt_wrap">
						<a href="PlantDiaryWrite.jsp" class="on">글쓰기</a>
						<!--<a href="#">수정</a>-->
					</div>
				</div>
			</div>
		</div>

		<div class="main_text1" style="height: 500px;">
			<div class="main_text2"></div>
			<footer>
				<div>LOGO</div>
				<div>
					CEO. 김태석<br> Addr. 광주광역시 동구 예술길 31-15 3층 스마트인재개발원<br>
					010-0000-0000<br> COPYRIGHT 2021 우리머만들조. ALL RIGHT RESERVED.
				</div>
			</footer>
		</div>
	</div>
</body>
</html>