<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form name="signUpForm" action="CorpMemberEdit_Reg" method="post" onsubmit="return authCheck();">
	<table border="">
		<tr>
			<th>아이디</th>
			<td><input type="text" name="pid" value="${user_data.pid }" readOnly/></td>
		</tr>
		<tr>
			<th>닉네임</th>
			<td><input type="text" name="nick_name" value="${user_data.nick_name }"/></td>
		</tr>
		<tr>
			<th>회사명</th>
			<td><input type="text" name="corp_name" value="${user_data.corp_name }"/></td>
		</tr>
		<tr>
			<th>사업자등록번호</th>
			<td><input type="text" name="corp_regnum" value="${user_data.corp_regnum }"/>
			<button type="button" value="사업자 등록번호 확인" name="checkRegNum" onclick="corpRegNumCheck()">인증</button></td>
			<input type="hidden" name="corpAuthPass" id="corpAuthPass" value="false"></td>
		</tr>
		<tr>
			<th>회사주소</th>
			<td><input type="text" name="corp_address" value="${user_data.corp_address }"/></td>
		</tr>
		<tr>
			<th>담당자이름</th>
			<td><input type="text" name="manager_name" value="${user_data.manager_name }"/></td>
		</tr>
		<tr>
			<th>담당자전화번호</th>
			<td><input type="text" name="manager_num" value="${user_data.manager_num }"/></td>
		</tr>
		<tr>
			<th>담당자이메일</th>
			<td>
				<input type="text" name="email1" id="inputEmailForm" value="${email }"/>
				<input type="text" style="width: 20px; border: none; background: transparent;" value="@" disabled /> 
				<select name="email2" id="selectEmailForm">
					<option value="gmail.com">google.com</option>
					<option value="naver.com">naver.com</option>
					<option value="nate.com">naver.com</option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" value="완료" /></td>
		</tr>
	</table>
</form>

<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
function authCheck(){
	var corpReg = document.getElementById("corpAuthPass").value;
	
	if(corpReg=="true" ){
		return true
	} else if(corpReg=="false"){
		alert("사업자 인증을 해주세요")
		return false;
	}
}

function corpRegNumCheck(){
    var inputRegNum = document.signUpForm.corp_regnum.value;
   //  console.log(inputRegNum);

    var data = {
    "b_no": [inputRegNum]
    }; 
    
    console.log(data)

    $.ajax({
      url: "https://api.odcloud.kr/api/nts-businessman/v1/status?serviceKey=TSCYgkMUJNavMzzHkbBTAvLHLaj1RrxOpBZ6BGHm49jIZIs%2FWtYi41K96uUEnIDmbtL7F7x900D14CVoDKpsNA%3D%3D",  // serviceKey 값을 xxxxxx에 입력
      type: "POST",
      data: JSON.stringify(data), // json 을 string으로 변환하여 전송
      dataType: "JSON",
      contentType: "application/json",
      accept: "application/json",
      success: function(result) {
    	  var b_stt = result.data[0].b_stt;
    	  
    	  if(b_stt=="" || b_stt=="폐업자" || b_stt=="휴업자"){
    		  alert("잘못된 등록번호 입니다.")
    	 	  document.getElementById("corpAuthPass").value = false;
    	  }else if(b_stt=="계속사업자"){
    		  alert("인증되었습니다.")
    	 	  document.getElementById("corpAuthPass").value = true;

    		  corpCheck = true;
    	  }else{
    		  alert("잘못된 등록번호 입니다.")
    	  }
    	  console.log(result)
          
      },
      error: function(result) {
          console.log(result.responseText); //responseText의 에러메세지 확인
      }
    });
 }
</script>