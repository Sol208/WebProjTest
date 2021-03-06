<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%=session.getAttribute("User") %>
<h1>이메일을 입력해주세요.</h1>

<!-- ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ -->
<form name="findIdForm" action="FindIdReg" method="post" onsubmit="return authCheck();"> <!-- onsubmit 추가 -->
<!-- ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ -->
	<table>
		<tr>
    		<td>
    			개인회원<input type="radio" name="memberkind" value="개인회원" checked/>
    			법인회원<input type="radio" name="memberkind" value="법인회원"/>
    		</td>
   		</tr>
		<tr>
			<th>이메일</th>
			<td>
				<input type="text" name="email" id="inputEmailForm"/>
				<button onclick="emailAuthentication()" id="eamilAuthBtn"
					type="button">인증 메일 보내기</button>
			</td>
			
		</tr>
		<tr>
			<th>인증번호 입력</th>
			<td colspan="2">
				<input type="text" name="authCode" id="inputAuthCode" maxlength="10">
				<button onclick="authCodeCheck()" id="authCodeCheckBtn" type="button" class="btnChk">인증</button> 
				<input type="hidden" name="authPass" id="authPass" value="false">
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="아이디 확인하기"/>
			</td>
		</tr>
	</table>
</form>

<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
<!-- ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ -->
function authCheck(){	/* 인증 유효성검사 */
	var reg= document.getElementById("authPass").value;
	
	if(reg=="true"){
		return true
	} else if(reg=="false"){
		alert("이메일 인증을 해주세요")
		return false;
	}
}
<!-- ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ -->

function emailAuthentication(){

  	var email = document.findIdForm.email.value;
  	var memberkind = document.findIdForm.memberkind.value;
    // console.log(email)
	var userData =  new Object();
        	  userData.email = email;
        	  userData.memberkind = memberkind;
        	  userData.requestPage = "FindId";
	$.ajax({
		url:'/member/Cert/MailReg',
		data:userData,
		type:'POST',
		success: function(result){
			console.log(userData)
		},
		error:function(e){
			console.log(e);
		}
  })
}

function authCodeCheck(){
	var url = "/member/Cert/authCodeCheck?inputedCode=" + document.findIdForm.authCode.value;
	open(url, "confirm",
			"toolbar=no, location=no,menubar=no,scrollbars=no,resizable=no,width=300,height=200");
}
</script>