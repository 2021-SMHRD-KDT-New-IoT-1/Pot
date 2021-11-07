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
    <link rel="stylesheet" href="style(Plantdiary).css">
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
    <div class="board_wrap">
        <div class="board_title">
            <strong>식물일기</strong>
            <p>나만의 식물 일상을 적어보세요!.</p>
        </div>
        <div class="board_view_wrap">
            <div class="board_view">
                <div class="title">
                   <%=bList.get(bo_num).getTitle() %>
                </div>
                <div class="info">
                    <dl>
                        <dt>번호</dt>
                        <dd><%=num %></dd>
                    </dl>
                    <dl>
                        <dt>글쓴이</dt>
                        <dd><%=vo.getNick() %></dd>
                    </dl>
                    <dl>
                        <dt>작성일</dt>
                        <dd><%=bList.get(bo_num).getDate().substring(0, 10) %></dd>
                    </dl>
                </div>
                <div class="cont">
                    <%=bList.get(bo_num).getContent() %>
                </div>
            </div>
            <div class="bt_wrap">
                <a href="PlantDiaryMain.jsp" class="on">목록</a>
                <a href="PlantDiaryEdit.jsp?bo_num=<%=get_bo_num %>&num=<%=get_num %>">수정</a>
            </div>
        </div>
    </div>
</body>
</html>