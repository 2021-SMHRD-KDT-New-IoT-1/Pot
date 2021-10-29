<%@page import="com.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="ko">
 <head>
   <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="Main.css">
 </head>
    
 <body>
	<%
		request.setCharacterEncoding("euc-kr");
		
		MemberVO vo = (MemberVO)session.getAttribute("member");
	%>
  <div class="wrap">
   <div class="intro_bg">
     <div class="header">
       <img src="./img/Main_logo.png">
       <ul class="nav">
          <li><a href="#">Ȩ</a></li>
          <li><a href="/Ķ����.html">�Ĺ� Ķ����</a></li>
          <li><a href="/������ �Ĺ��ϱ�.html">������ �Ĺ��ϱ�</a></li>
          <li><a href="/�Ĺ���������.html">�Ĺ���������</a></li>
        <%if (vo==null) { %>
          <li><a href="login.jsp">�α���/ȸ������</a></li>
		<% } else { %>
		  <li><a href="LogoutService">�α׾ƿ�</a></li>
		<% } %>
        </ul>
      </div>
      <div class="intro_text">
      		<%if (vo==null) { %>
				<h2>WE MAKE POT</h1>
			<% } else { %>
				<h2><%=vo.getNick() %> ����</h1>
			<% } %>
          <h1>������ �Ĺ��� ���� ����Ʈ�ϰ�!</h1>
          <h4 class="contens1">������ �Ĺ��� Ű��������!</h4>
      </div>
    </div>
    
     
   <!-------------------------->
   <ul class="amount">
    <li>
     <div>
      <div class= "contens1">�ȶ��� ȭ�� IO-OT</div>
      <div class= "contens2">�� �������� �����ϰ� �۵�!</div>
     </div> 
    </li>
    <li>
     <div>
      <div class= "contens1">LED ����� ����</div>
      <div class= "contens2">�ǳ������� ��������~</div>
     </div> 
    </li>
    <li>
     <div>
      <div class= "contens1">�˾Ƽ� ���� �ִ� �ȶ��� ȭ��</div>
      <div class= "contens2">IO-OT�� �˾Ƽ� ���� �ݴϴ�</div>
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
      <div class="contens1_bold">���� ����</div>
      <div class="contens3">���� ���� �ȶ��� ȭ�� IO-OT��<br>������ ��������� ������ݴϴ�.</div>
   </li>
   
     <li>
         <div class="icon_img">
          <img src="./img/MainG88.png">  
         </div>
         <div class="contens1_bold">���� �� 1�Ⱓ ���� A/S</div>
         <div class="contens3">���峪�� �������������� 365�� A/S����ڰ� ����� �Դϴ�.</div>  
     </li>
     <li>
         <div class="icon_img">
          <img src="./img/MainG89.png">  
         </div>
         <div class="contens1_bold">��ٸ���������</div>
         <div class="contens3">12�� ���� �ֹ��� ���Ϲ��!</div>  
     </li>
   
    </ul>
   </div>
    <div class="main_text1">
      <h1>Ű��������!</h1>
      <div class="contens1">���� ȿ���� �������ݴϴ�! </div>
      <div class="service">
        <div class="photo1">
          <img src="./img/MainplantHoldMan.png">
        </div>
        <div class="contens4">
          <h3>�ݷ��Ĺ��� ���� ȿ��!</h3>
          ����� �ٵ� ���� ȭ���� Ű���� ������ �����Ű���?<br>
          �����鿩 Ű�� ���� ȭ�п��� ���ɽ��� ����� �� ������ �� ������ �Ƹ��� �������� ���� á�� �̴ϴ�.<br><br>
          �ڷγ� 19���� ���� ������ �ð��� ������ ������� �þ�鼭 ������ �ݷ����� �Ӹ��� �ƴ� '�ݷ��Ĺ�'�� �Ҹ� ������ �αⰡ �޺λ� �ϸ鼭 �ݷ��Ĺ���
          �츮�� ������ ���� �� �ִ� ���� �Ͽ����� �ڸ� ��ҽ��ϴ�.<br><br>
          ����� 1�ΰ��� ��� 330���� ������� ������ ���� 92%�� ��ﰨ �� �ܷο� �ؼҿ� ������ �Ǿ��ٰ� ���ߴµ���,
          ��ó�� �ݷ��Ĺ��� �ɸ��� �������� �ƴ϶� ���� ���� ��ȭ ȿ�� �� ���׸������ �ϼ������� ȿ���� ������ �ִ� �ݷ��Ĺ�!
          <strong>����Ʈȭ�� 'IO-OT''�� �ϻ��� ��ſ��� ����������!</strong>
        </div>
      </div>
                        
          
      <div class="main_text2"></div>
      <footer>
        <div>LOGO</div>
        <div>CEO. ���¼�<br>
          Addr. ���ֱ����� ���� ������ 31-15 3�� ����Ʈ���簳�߿�<br>
          010-0000-0000<br>
          COPYRIGHT 2021 �츮�Ӹ�����. ALL RIGHT RESERVED.
        </div>
      </footer>  
    </div>
  </div>
</body>
</html>