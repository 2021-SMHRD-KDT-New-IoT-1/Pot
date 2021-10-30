<%@page import="com.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
 <head>
   <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="Main.css">
 </head>
    
 <body>
	<%
		request.setCharacterEncoding("UTF-8");
		
		MemberVO vo = (MemberVO)session.getAttribute("member");
	%>
  <div class="wrap">
   <div class="intro_bg">
     <div class="header">
       <img src="./img/Main_logo.png">
       <ul class="nav">
          <li><a href="#">식물 등록</a></li>
          <li><a href="/캘린더.html">식물 캘린더</a></li>
          <li><a href="/나만의 식물일기.html">나만의 식물일기</a></li>
          <li><a href="/식물원격제어.html">식물원격제어</a></li>
        <%if (vo==null) { %>
          <li><a href="login.jsp">로그인/회원가입</a></li>
		<% } else { %>
		  <li><a href="LogoutService">로그아웃</a></li>
		<% } %>
        </ul>
      </div>
      <div class="intro_text">
      		<%if (vo==null) { %>
				<h2>WE MAKE POT</h1>
			<% } else { %>
				<h2><%=vo.getNick() %> 님의</h1>
			<% } %>
          <h1>소중한 식물을 더욱 스마트하게!</h1>
          <h4 class="contens1">나만의 식물을 키워보세요!</h4>
      </div>
    </div>
    
     
   <!-------------------------->
   <ul class="amount">
    <li>
     <div>
      <div class= "contens1">똑똑한 화분 IO-OT</div>
      <div class= "contens2">웹 연동으로 간편하게 작동!</div>
     </div> 
    </li>
    <li>
     <div>
      <div class= "contens1">LED 상생빔 장착</div>
      <div class= "contens2">실내에서도 문제없이~</div>
     </div> 
    </li>
    <li>
     <div>
      <div class= "contens1">알아서 물을 주는 똑똑한 화분</div>
      <div class= "contens2">IO-OT는 알아서 물을 줍니다</div>
     </div> 
    </li>
    <li>
     <div>
      <div class= "contens1"></div>
      <div class= "contens2"></div>
     </div> 
    </li>
    </ul>
    <!-----------amount end--------------->
    
   <div class="main_text0">
     <h1>ABOUT</h1>
     <div class="contens1"></div>

       
    <ul class="icon">
   <li>
      <div class="icon_img">
       <img src="./img/MainG90.png">  
      </div>
      <div class="contens1_bold">요즘 갬성</div>
      <div class="contens3">감성 까지 똑똑한 화분 IO-OT는<br>집안을 사랑스럽게 만들어줍니다.</div>
   </li>
   
     <li>
         <div class="icon_img">
          <img src="./img/MainG88.png">  
         </div>
         <div class="contens1_bold">구입 후 1년간 무상 A/S</div>
         <div class="contens3">고장나도 걱정하지마세요 365일 A/S기술자가 대기중 입니다.</div>  
     </li>
     <li>
         <div class="icon_img">
          <img src="./img/MainG89.png">  
         </div>
         <div class="contens1_bold">기다리지마세요</div>
         <div class="contens3">12시 이전 주문시 당일배송!</div>  
     </li>
   
    </ul>
   </div>
    <div class="main_text1">
      <h1>키워보세요!</h1>
      <div class="contens1">놀라운 효과를 가져다줍니다! </div>
      <div class="service">
        <div class="photo1">
          <img src="./img/MainplantHoldMan.png">
        </div>
        <div class="contens4">
          <h3>반려식물의 놀라운 효과!</h3>
          어린시절 다들 작은 화분을 키워본 경험이 있으신가요?<br>
          정성들여 키운 작은 화분에서 조심스레 모습을 들어낸 새싹을 본 마음은 아마도 설렘으로 가득 찼을 겁니다.<br><br>
          코로나 19사태 이후 집에서 시간을 보내는 사람들이 늘어나면서 이제는 반려동물 뿐만이 아닌 '반려식물'로 불릴 정도로 인기가 급부상 하면서 반려식물은
          우리와 교감을 나눌 수 있는 삶의 일원으로 자리 잡았습니다.<br><br>
          서울시 1인가구 어르신 330명을 대상으로 조사결과 무려 92%가 우울감 및 외로움 해소에 도움이 되었다고 답했는데요,
          이처럼 반려식물은 심리적 안정감뿐 아니라 집안 공기 정화 효과 및 인테리어까지 일석이조의 효과를 가져다 주는 반려식물!
          <strong>스마트화분 'IO-OT''로 일상의 즐거움을 느껴보세요!</strong>
        </div>
      </div>
                        
          
      <div class="main_text2"></div>
      <footer>
        <div>LOGO</div>
        <div>CEO. 김태석<br>
          Addr. 광주광역시 동구 예술길 31-15 3층 스마트인재개발원<br>
          010-0000-0000<br>
          COPYRIGHT 2021 우리머만들조. ALL RIGHT RESERVED.
        </div>
      </footer>  
    </div>
  </div>
</body>
</html>