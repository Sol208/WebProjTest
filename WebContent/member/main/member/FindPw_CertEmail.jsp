<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>회원가입시 등록한 이메일을 입력해주세요</h2>
<!-- ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ -->
<form name="findPwForm" action="FindPwReg" method="post" onsubmit="return authCheck();"> <!-- onsubmit 추가 -->
<!-- ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ -->
	<table border="">
		<tr>
			<th>이메일</th>
			<td>
				<input type="text" name="email" id="inputEmailForm" />
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
			<td colspan="2">
				<input type="submit" value="다음" />
				<input type="hidden" name="memberkind" value="${memberkind }" />
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

  	var email = document.findPwForm.email.value;
    // console.log(email)
	var userData =  new Object();
        	  userData.email = email;
        	  userData.requestPage = "FindPw";
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
	var url = "/member/Cert/authCodeCheck?inputedCode=" + document.findPwForm.authCode.value;
	open(url, "confirm",
			"toolbar=no, location=no,menubar=no,scrollbars=no,resizable=no,width=300,height=200");
}
</script>