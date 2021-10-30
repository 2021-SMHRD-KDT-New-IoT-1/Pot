<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Document</title>
    <link rel="stylesheet" href="Member_Join_success.css" />
    <link
      href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap"
      rel="stylesheet"
    />
    <style type="text/css"> 
	a { text-decoration:none } 
</style> 
  </head>
  <body>
  		<%
			String nick = (String)request.getAttribute("nick");
		%>
    <div class="wrapper">
      <nav>
        <ul>
          <li><h1>환영합니다!</h1></li>
          <li><%=nick %> 님의<br>회원가입을 축하합니다.</li>
          <br><br>
          <li><a href="Main.jsp">홈으로</a></li>
        </ul>
      </nav>
    </div>
  </body>
</html>