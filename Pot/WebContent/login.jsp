<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="login.css">
    <script src="/img/JQUERY/jquery-3.6.0.js"></script>
</head>
<body>
    <section class="login-form">
        <h1>로그인하세요</h1>
        <form action="LoginService" method="post">
            <div class="int-area">
                <input type="text" name="email" id="email"
                autocomplete="off" required>
                <label for="id">USER EMAIL</label>
            </div>
            <div class="int-area">
                <input type="password" name="pw" id="pw"
                autocomplete="off" required>
                <label for="pw">PASSWORD</label>
            </div>
            <div class="btn-area">
                <button id="btn" type="submit">LOGIN</button>
            </div>
        </form>
        <div class="caption">
            <a href="join_member.html">회원가입하기</a>
        </div>
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