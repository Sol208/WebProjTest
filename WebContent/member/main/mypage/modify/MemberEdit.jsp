<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h2>수정하실 정보를 입력 해주세요</h2>


<form action="MemberEdit_Reg" method="post">
	<table border="">
		<tr>
			<th>ID</th>
			<td>
				<input type="text" name="pid" value="${user_data.pid }" readOnly />
				<button>비밀번호 변경</button>
			</td>
		</tr>
		<tr>
			<th>닉네임</th>
			<td><input type="text" name="nick_name"
				value="${user_data.nick_name }" /></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="pname" value="${user_data.pName }" /></td>
		</tr>
		<tr>
			<th>성별</th>
			<!-- 자바스크립트로 이전 선택값을 비교하여 선택 되어 있도록 해야함 -->
			<td>남자<input type="radio" name="gender" value="남자" /> 여자<input
				type="radio" name="gender" value="여자" />
			</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><select name="telecom" class="select_box">
					<option>이동통신</option>
					<option>SKT</option>
					<option>KT</option>
					<option>LGU+</option>
			</select> <input type="text" name="phonenum" maxlength="11" value="${user_data.phoneNum }"/></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="text" name="email1" id="inputEmailForm"
				maxlength="30" value="${email }"> <input type="text"
				style="width: 20px; border: none; background: transparent;"
				value="@" disabled /> <select name="email2" id="selectEmailForm">
					<option value="gmail.com">google.com</option>
					<option value="naver.com">naver.com</option>
					<option value="naver.com">nate.com</option>
			</select>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" name="address" value="${user_data.address }"/></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" value="완료" />
			</td>
		</tr>
	</table>
</form>