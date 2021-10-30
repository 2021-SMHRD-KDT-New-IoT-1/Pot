<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Document</title>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="login.css">
<script src="/img/JQUERY/jquery-3.6.0.js"></script>
<style>
select {
	margin-left: 100px;
	margin-bottom: 40px;
	text-align-last: center;
    text-align: center;
	width: 200px;
	padding: .8em .5em;
	border: 1px solid #999;
	font-family: inherit;
	border-radius: 0px;
	-webkit-appearance: none;
	-moz-appearance: none;
	appearance: none;
}

</style>
</head>
<body>
	<section class="login-form">
		<h1>식물을 선택하세요.</h1>
		<form action="SelectPlant" method="post">
			<div class="int-area">
				<select name="plant" required>
					<option value="">식물을 선택하세요.</option>
					<option value="학생">학생</option>
					<option value="회사원">회사원</option>
					<option value="기타">기타</option>
				</select>
			</div>
			<div class="btn-area">
				<button id="btn" type="submit">Select</button>
			</div>
		</form>
	</section>
	<script>
        let id = $('#id');
        let pw = $('#pw');
        let btn = $('#btn');

        $(btn).on('click', function() {
            if($(id).val() == "") {
                $(id).next('label').addClass('warning');
                setTimeout(function() {
                    $('label').removeClass('warning');
                },1500);
            }
            else if($(pw).val() == "") {
                $(pw).next('label').addClass('waring');
                setTimeout(function() {
                    $('label').removeClass('warning');
                },1500);
            }
        });
    </script>
</body>
</html>