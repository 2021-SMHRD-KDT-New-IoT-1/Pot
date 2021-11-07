<%@page import="com.model.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>식물일기</title>
<style type="text/css">
@import url("style(Plantdiary).css");

@import url("media(Plantdiary).css");
</style>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	
		MemberVO vo = (MemberVO)session.getAttribute("member");
	
		ArrayList<BoardVO> bList = (ArrayList)session.getAttribute("board");
		
		String get_bo_num = request.getParameter("bo_num");
		String get_num = request.getParameter("num");
		
		int bo_num = Integer.parseInt(get_bo_num);
		int num = Integer.parseInt(get_num);
	%>
	<form action="DEditService" method="post">
		<div class="board_wrap">
			<div class="board_title">
				<strong>식물일기</strong>
				<p>나만의 식물 일상을 적어보세요!</p>
			</div>
			<div class="board_write_wrap">
				<div class="board_write">
					<div class="title">
						<dl>
							<dt>제목</dt>
							<dd>
								<input name="title" type="text" value="<%=bList.get(bo_num).getTitle() %>">
							</dd>
						</dl>
					</div>
					<div class="info">
						<dl>
							<dt>글쓴이</dt>
							<dd>
								<input type="text" value="<%=vo.getNick()%>">
							</dd>
						</dl>
					</div>
					<div class="cont">
						<textarea name="content">
						 <%=bList.get(bo_num).getContent() %>
					</textarea>
					</div>
				</div>
				<div class="bt_wrap">
					<input type="hidden" value="<%=bo_num %>" name="bo_num"
						id="mem_num" autocomplete="off" required>
					<button id="btn" type="submit" class="on">수정</button> 
					<a href="PlantDiaryMain.jsp">취소</a>
				</div>
			</div>
		</div>
	</form>
</body>
</html>