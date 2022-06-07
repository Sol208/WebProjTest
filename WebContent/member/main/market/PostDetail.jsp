<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>PostDetail</h2>

<table border="">
	<tr>
		<td colspan="2" align="right">
			<button onclick="location.href='PostDelete_Reg?post_id=${dto.post_id }&page=${nowPage }'">삭제</button>
			<button onclick="location.href='PostModify?post_id=${dto.post_id }&page=${nowPage }'">수정</button>
		</td>
	</tr>
	<tr>
		<td colspan="2">${dto.title }</td>
	</tr>
	<tr>
		<th>판매자 아이디</th>
		<td>${dto.user_id }</td>
	</tr>
	<tr>
		<th>판매자 이메일</th>
		<td>${dto.user_email }</td>
	</tr>
	<tr>
		<th>판매자 번호</th>
		<td>${dto.user_num }</td>
	</tr>
	<tr>
		<th>상품상태</th>
		<td>${dto.check_quality }</td>
	</tr>
	<tr>
		<th>카테고리</th>
		<td>${dto.l_category } > ${dto.s_category }</td>
	</tr>
	<tr>
		<th>상품가격</th>
		<td>${dto.price }</td>
	</tr>
	<tr>
		<th>거래방법</th>
		<td>${dto.delivery }</td>
	</tr>
	<tr>
		<td colspan="2">
			${dto.content }
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<textarea name="reply" id="" cols="90" rows="5"></textarea>
			<button>댓글입력</button>
		</td>
	</tr>
</table>