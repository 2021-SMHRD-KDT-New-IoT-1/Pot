<%@page import="com.model.CalendarVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.CalendarDAO"%>
<%@page import="com.model.PlantVO"%>
<%@page import="com.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="RemotePlant.css">
<link rel="stylesheet" type="text/css" href="RemotePlant2.css">
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
  	
  	int pt_num = Integer.parseInt(request.getParameter("num"));

  	System.out.println("리모트 식물 번호: " + pt_num);
  	CalendarDAO dao = new CalendarDAO();
  	
  	int humid = dao.getHumid(pt_num);
	
	MemberVO vo = (MemberVO)session.getAttribute("member");
	%>
	<div class="main2">
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
		<form action="RemotePlant" method="post">
			<div id="single">
				<div id="head">식물 습도 관리 페이지</div>
				<div id="nava"></div>
				<div id="sider">
				<% if(humid > 70) {%>
					<img id="emoji" src="./img/heartEmoji.png">
				<%} else if(humid > 60) {%>
					<img id="emoji" src="./img/smileEmoji.png">
				<%} else if(humid > 50) {%>
					<img id="emoji" src="./img/normalEmoji.png">
				<%} else if(humid > 40) {%>
					<img id="emoji" src="./img/cryEmoji.png">
				<%} else {%>
					<img id="emoji" src="./img/deathEmoji.png">
				<%} %>
				</div>
				<div id="sec1">습도</div>
				<div id="sec2"><%=humid%>%</div>
				<div id="foot">
					<input type="hidden" value="<%=pt_num %>" name="pt_num" id="pt_num" autocomplete="off" required>
					<button id="ledCheck" type="submit" class="btn btn-default">물주기</button>
				</div>
				</div>
				<script type="text/javascript">
				$(function(){ 
					$.ajax({
						url : "GetSensor",
						type : "get",
						dataType : "json",
						success : function(data){
							$('#result').html("현재 모터 상태 : " + data.mysensor);
						},
						error : function(){
							alert('1');
						}
					});
				});
				
					$("#ledCheck").on('click',function(){
						var mysensor = $('#mysensor').val();
						count++;
						if(count%2==0){
							count=0;
						}
						$.ajax({
							url : "InputSensor",
							type : "get",
							data : {"mysensor": count},
							dataType : "json",
							success : function(data){
								$('#result').html("현재 모터 상태 : " + data.mysensor);
							},
							error : function(){
								alert('2');
							}
						});
					});
				
				</script>
		<%-- 	</div>
			<div class="water_sensor">
				<h1>습도</h1>
				<h1 class="humidity"><%=humid%>%</h1>
				<img class="logo2" src="./img/Main_logo.png">
				<div class="int-area">
				</div>
				<div class="btn-area">
					<button id="ledCheck" type="submit" class="btn btn-default">전송</button>
				</div> --%>
		</form>
	</div>
	<footer>
		<div>LOGO</div>
		<div>
			CEO. 김태석<br> Addr. 광주광역시 동구 예술길 31-15 3층 스마트인재개발원<br>
			010-0000-0000<br> COPYRIGHT 2021 우리머만들조. ALL RIGHT RESERVED.
		</div>
	</footer>

	</div>
</body>
</html>