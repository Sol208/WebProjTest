<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form action="InsertReg" method="post">
	<table border="">
		<tr>
			<td>ID</td>
			<td><input type="text" name="pid" value="ood1208" /></td>
		</tr>
		<tr>
			<td>PW</td>
			<td><input type="password" name="pw" /></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="pname" /></td>
		</tr>
		<tr>
			<td>성별</td>
			<td>남자<input type="radio" name="gender" value="남자" /> 여자<input
				type="radio" name="gender" value="여자" />
			</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><select name="telecom" class="select_box">
					<option>이동통신</option>
					<option>SKT</option>
					<option>KT</option>
					<option>LGU+</option>
			</select> <input type="text" name="phonenum1" maxlength="3" /> - <input
				type="text" name="phonenum2" maxlength="4" /> - <input type="text"
				name="phonenum3" maxlength="4" /></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>
			<input type="text" name="email1" />
			<input type="text" style="width: 25px" value="@" disabled />
			<select name="email2">
					<option value="google.com">google.com</option>
					<option value="naver.com">naver.com</option>
					<option value="naver.com">naver.com</option>
			</select></td>
			<td><input type="button" value="이메일 인증" onclick="emailCheck()" /></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" name="address" /></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" name="완료" />
			</td>

		</tr>
	</table>
</form>

<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	
function emailCheck(){
	let clientEmail1 = document.getElementById("email1").value;
	let clientEmail2 = document.getElementById("email2").value;
	let clientEmail = clientEmail1+'@'+clientEmail2
	let emailYN = isEmail(clientEmail)
	
	console.log(clientEmail)
	console.log("emailYN ===> " + emailYN)
	if(emailYN == true){
	  alert("이메일 통과 ㅇㅇ")
	}
}

function isEmail(asValue) {
  var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;

  return regExp.test(asValue);
}

	function checkData() {

		ispassword()

		function isPassword(asValue) {
			var regExp = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,16}$/;

			return regExp.test(asValue); // 형식에 맞는 경우 true 리턴
		}
	}
</script>