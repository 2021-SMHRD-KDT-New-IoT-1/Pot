<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.PlantDAO"%>
<%@page import="com.model.PlantVO"%>
<%@page import="com.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="SelectPlant.css" />
</head>

<body>
	<%
		request.setCharacterEncoding("UTF-8");
	String pt_num = null;

	MemberVO vo = (MemberVO) session.getAttribute("member");
	String mem_num = vo.getMem_num();
	/* PlantVO pvo = (PlantVO) session.getAttribute("plant"); */

	PlantDAO pdao = new PlantDAO();
	ArrayList<PlantVO> pal = pdao.selectPlant(mem_num);
	
	%>
	<div class="main2">
		<div class="intro_bg">
			<div class="header">
				<a href="Main.jsp"><img src="./img/Main_logo.png"
					style="margin: 6px"></a>
				<ul class="nav">
					<%if (vo==null) { %>
					<li><a href="login.jsp">로그인/회원가입</a></li>
					<% } else { %>
					<li><a href="Join_plant.jsp">식물 등록</a></li>
					<li><a href="SelectPlant">식물 관리</a></li>
					<li><a href="PlantDiaryMain.jsp">나만의 식물일기</a></li>
					<li><a href="LogoutService">로그아웃</a></li>
					<% } %>
				</ul>
			</div>
			<hr id="topLine" color="darkgray" size="3px" width="100%">
			<div class="intro_text">
				<br>
				<h2 align="center">식물 선택 페이지</h2>
				<br>
				<table class="type09">
					<thead>
						<tr>
							<!-- 식물이름 -->
							<th scope="cols">NICK</th>
							<!-- 식물정보 -->
							<th scope="cols">COMMENT</th>
							<th scope="cols">CHOICE</th>
							<th scope="cols">WATER PUMP</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (PlantVO pvo : pal) {
								pt_num = pvo.getPt_num();
						%>
						<tr>
							<th scope="row"><%=pvo.getPt_nick()%></th>
							<td><%=pvo.getComment()%></td>
							<td><a href="Calendar.jsp?num=<%=pt_num%>">CHOICE</a></td>
							<td><a href="RemotePlant.jsp?num=<%=pt_num%>">CHOICE</a></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<footer>
		<div>LOGO</div>
		<div>
			CEO. 김태석<br /> Addr. 광주광역시 동구 예술길 31-15 3층 스마트인재개발원<br />
			010-0000-0000<br /> COPYRIGHT 2021 우리머만들조. ALL RIGHT RESERVED.
		</div>
	</footer>
</body>
</html>