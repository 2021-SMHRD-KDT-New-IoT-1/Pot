<%@page import="com.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="login.css">
    <title>Document</title>
</head>
<body>
	<%
		MemberVO vo = (MemberVO)session.getAttribute("member");
	%>
    <section class="login-form">
        <h1>식물 등록</h1>
        <form action="JoinPlant" method="post">
        	<%if(vo==null) { %>
				<p>로그인을 해주세요.</p>
			<%} else { %>
            <div class="int-area">
            	<p align="center">접속한 닉네임 : <%=vo.getNick() %></p>
            </div>
            <div class="int-area">
                <input type="text" name="ptNick" id="ptNick"
                autocomplete="off" required>
                <label for="ptNick">Plant NickName</label>
            </div>
            <div class="int-area">
                <input type="text" name="comment" id="comment"
                autocomplete="off" required>
                <label for="comment">COMMENT</label>
            </div>
            <div class="int-area">
                <input type="hidden" value="<%=vo.getMem_num() %>" name="mem_num" id="mem_num"
                autocomplete="off" required>
            </div>
            <div class="btn-area">
                <button id="btn"
                type="submit">식물 등록하기</button>
            </div>
			<%} %>
        </form>
    </div>
</section>
</body>
</html>