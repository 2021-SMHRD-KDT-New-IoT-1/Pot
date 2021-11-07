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

	MemberVO vo = (MemberVO) session.getAttribute("member");
	%>
	<form action="WriteService" method="post">
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
								<input name="title" type="text" placeholder="제목 입력">
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
						<!-- <dl>
                        <dt>비밀번호</dt>
                        <dd><input type="password" placeholder="비밀번호 입력"></dd>
                    </dl> -->
					</div>
					<div class="cont">
						<textarea name="content" placeholder="내용 입력"></textarea>
					</div>
				</div>
				<div class="bt_wrap">
					<input type="hidden" value="<%=vo.getMem_num()%>" name="mem_num"
						id="mem_num" autocomplete="off" required>
					<button id="btn" type="submit" class="on">등록</button>
					<a href="PlantDiaryMain.jsp">취소</a>
				</div>
			</div>
		</div>
	</form>
</body>
</html>