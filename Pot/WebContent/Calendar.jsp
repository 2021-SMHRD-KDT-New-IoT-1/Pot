<%@page import="com.model.MemberVO"%>
<%@page import="com.model.CalendarVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.CalendarDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<!-- 화면 해상도에 따라 글자 크기 대응(모바일 대응) -->
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<!-- jquery CDN -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- fullcalendar CDN -->
<link
	href="https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.css"
	rel="stylesheet" />
<script
	src="https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.js"></script>
<!-- fullcalendar 언어 CDN -->
<script
	src="https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/locales-all.min.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="Main.css">
<style>
/* body 스타일 */
html, body {
	overflow: hidden;
	font-family: "Noto Sans KR", sans-serif;
	font-size: 16px;
	/* background-color: #DCFFDC; */
}

/* 캘린더 위의 해더 스타일(날짜가 있는 부분) */
.fc-header-toolbar {
	padding-top: 1em;
	padding-left: 1em;
	padding-right: 1em;
	margin-top: 100px;
}

.header {
	display: flex;
	width: 1280px;
	margin: auto;
	height: 86px;
}

.header>img {
	width: 167px;
	height: 77px;
	margin-top: 6px;
}

.nav {
	display: flex;
	justify-content: flex-end;
	width: 1280px;
	line-height: 86px;
}

.nav>li {
	list-style-type: none;
	margin-left: 84px;
	color: rgb(0, 0, 0);
	font-size: 25px;
}

.nav>li>a {
	font-size: 24px;
	color: rgb(0, 0, 0);
	text-decoration: none;
}

footer {
	display: flex;
	background: #1f1f1f;
	padding: 30px;
}

footer>div:first-child {
	flex: 3;
	text-align: center;
	color: #fff;
}

footer>div:last-child {
	flex: 9;
	color: #fff;
}

#calendar {
	max-width: 75%;
	margin: 0 auto;
}
</style>
</head>
<body>
	<%
  	request.setCharacterEncoding("UTF-8");
  	
  	String num = request.getParameter("num");
  	
  	System.out.println(num);
	
	MemberVO vo = (MemberVO)session.getAttribute("member");
  	
	CalendarDAO dao = new CalendarDAO();
	ArrayList<CalendarVO> cal = dao.calendar(num);

	System.out.println(cal.size());

	for (int i = 0; i < cal.size(); i++) {
		if (cal.get(i).getState().equals("10")) {
			cal.get(i).setState("물");
		}
		if (cal.get(i).getState().equals("20")) {
			cal.get(i).setState("LED");
		}
		if (cal.get(i).getState().equals("1")) {
			cal.get(i).setState("사용자 물 공급");
		}
		if (cal.get(i).getState().equals("0")) {
			cal.get(i).setState("사용자 물 공급");
		}
	}
	%>

	<!-- Wrapper -->

	<div id="wrapper">
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
	</div>
	<hr id="topLine" color="darkgray" size="3px" width="100%">

	<!-- Menu -->
	<div class="a">
		<nav id="Update"></nav>
		<!-- calendar 태그 -->
		<div id="calendar-container">
			<div id="calendar"></div>
		</div>
	</div>
	<div class="main_text2"></div>
	<footer>
		<div>LOGO</div>
		<div>
			CEO. 김태석<br /> Addr. 광주광역시 동구 예술길 31-15 3층 스마트인재개발원<br />
			010-0000-0000<br /> COPYRIGHT 2021 우리머만들조. ALL RIGHT RESERVED.
		</div>
	</footer>
	</div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/jquery.scrollex.min.js"></script>
	<script src="assets/js/skel.min.js"></script>
	<script src="assets/js/util.js"></script>
	<!--[if lte IE 8
      ]><script src="assets/js/ie/respond.min.js"></script
    ><![endif]-->
	<script src="assets/js/main.js"></script>
	<script>
      (function () {
        $(function () {
          // calendar element 취득
          var calendarEl = $("#calendar")[0];
          // full-calendar 생성하기
          var calendar = new FullCalendar.Calendar(calendarEl, {
            height: "750px", // calendar 높이 설정
            expandRows: true, // 화면에 맞게 높이 재설정
            slotMinTime: "07:00", // Day 캘린더에서 시작 시간
            slotMaxTime: "19:00", // Day 캘린더에서 종료 시간
            // 해더에 표시할 툴바
            headerToolbar: {
              left: "prev,next",
              center: "title",
              right: "today", // ,timeGridWeek,timeGridDay,listWeek
            },
            initialView: "dayGridMonth", // 초기 로드 될때 보이는 캘린더 화면(기본 설정: 달)
            initialDate: null, // 초기 날짜 설정 (설정하지 않으면 오늘 날짜가 보인다.)
            navLinks: false, // 날짜를 선택하면 Day 캘린더나 Week 캘린더로 링크
            editable: false, // 수정 가능?
            selectable: false, // 달력 일자 드래그 설정가능
            nowIndicator: true, // 현재 시간 마크
            dayMaxEvents: true, // 이벤트가 오버되면 높이 제한 (+ 몇 개식으로 표현)
            locale: "ko", // 한국어 설정
          });
          // calendar에 이벤트 추가
          <%for (int i = 0; i < cal.size(); i++) {%>
			             <%for (int j = 0; i < cal.size(); i++) {%>
							calendar.addEvent({
			              	title: "<%=cal.get(i).getState()%>",
								<%if (cal.get(i).getState().equals("물")) {%>
									start: "<%=cal.get(i).getDate()%>", // 시작시간
									end: "<%=cal.get(i).getDate()%>", // 끝나는 시간
									backgroundColor:"blue"
						 		<%}
								if (cal.get(i).getState().equals("LED")) {%>
									start: "<%=cal.get(i).getDate()%>", // 시작시간	
									end: "<%=cal.get(i).getDate()%>", // 끝나는 시간	
									backgroundColor:"orange"
						 		<%}
								if (cal.get(i).getState().equals("사용자 물 공급")) {%>
								start: "<%=cal.get(i).getDate()%>", // 시작시간	
								end: "<%=cal.get(i).getDate()%>", // 끝나는 시간	
								backgroundColor:"skyblue"
					 			<%}%> 
							})				
			            <%}%>
		            <%}%>

          //String[] arr = {"test1", "test2", "test3"};

          // 1. DB -> 21/10/27 -> replace() 이런 메소드 -> / : -
          // '20' + '21-10-27;'
          // --> 2021-10-27

          // 2. event > ArrayList<VO>
          // for문 써서 반복하기

          // 캘린더 랜더링
          calendar.render();
        });
      })();
    </script>
</body>
</html>