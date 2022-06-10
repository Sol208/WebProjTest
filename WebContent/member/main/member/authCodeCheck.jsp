<%@page import="Cert.model.ShareVar_login"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String result = "false";
	String authCode = ShareVar_login.authEamilCode;
	String inputedCode = request.getParameter("inputedCode");
	
	if(authCode.equals(inputedCode)){
		result = "true";
	}
%>

<script type="text/javascript">
	var result = "true";
	var inputedCode = "<%=inputedCode%>";
	
	if (inputedCode == ""){
		alert("인증번호가 올바르지 않습니다.");
		opener.document.getElementById("authPass").value = "false";		/* 인증 유효성검사 추가 */
		self.close();
	}
	if(<%=result%> == true){
		alert("인증이 완료되었습니다.");
		opener.document.getElementById("authPass").value = "true";		/* 인증 유효성검사 추가 */
<!-- ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ -->
		<%ShareVar_login.authEamilCode = null;%> // 인증번호 초기화
<!-- ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ -->
		console.log("<%=result%>");
		
		self.close();
	} else {
		alert("인증번호가 올바르지 않습니다.");
		opener.document.getElementById("authPass").value = "false";		/* 인증 유효성검사 추가 */
		self.close();
	}

</script>