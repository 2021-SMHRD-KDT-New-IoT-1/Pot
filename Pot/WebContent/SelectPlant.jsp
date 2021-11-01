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

	MemberVO vo = (MemberVO) session.getAttribute("member");
	%>
	<div class="main2">
		<div class="intro_bg">
			<div class="header">
				<a href="Main.jsp"><img src="./img/Main_logo.png"
					style="margin: 6px"></a>
				<ul class="nav">
					<%
						if (vo == null) {
					%>
					<li><a href="login.jsp">로그인/회원가입</a></li>
					<%
						} else {
					%>
					<li><a href="Join_plant.jsp">식물 등록</a></li>
					<li><a href="calendar.jsp">식물 캘린더</a></li>
					<li><a href="PlantDiaryMain.jsp">나만의 식물일기</a></li>
					<li><a href="RemotePlant.jsp">식물원격제어</a></li>
					<li><a href="LogoutService">로그아웃</a></li>
					<%
						}
					%>
				</ul>
			</div>
			<div class="intro_text">
				<br>
				<h2 align="center">식물 선택 페이지</h2>
				<br>
				<table class="type09">
					<thead>
						<tr>
							<th scope="cols">NICK</th> <!-- 식물이름 -->
							<th scope="cols">COMMENT</th> <!-- 식물정보 -->
							<th scope="cols">CHOICE</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">가을이</th>
							<td>가을에 산 귀여운 가을이</td>
							<td>CHOICE</td>
						</tr>
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