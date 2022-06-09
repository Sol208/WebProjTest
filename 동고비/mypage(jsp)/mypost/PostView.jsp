<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <button onclick="moveOn('대회')">대회</button>
    <button onclick="moveOn('자유게시판')">자유게시판</button>
    <button onclick="moveOn('구인구팀')">구인구팀</button>
    <button onclick="moveOn('장터')">장터</button>
    <button onclick="moveOn('레슨')">레슨</button>


<script>
	function moveOn(board){
		console.log(board)
		var title =  new Object();
		title.title = board;
		  
		  $.ajax({
				url:'',
				data:title,
				type:'POST',
				success: function(result){
					console.log(userData)
				},
				error:function(e){
					console.log(e);
				}
		  })
	}

	

</script>