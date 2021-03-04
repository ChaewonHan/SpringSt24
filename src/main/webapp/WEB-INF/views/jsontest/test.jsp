<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(function(){
		$('#test1').on('click', function(){
			$.ajax({
				url: "test1.do",
				type:'post',
				data:{"name":"신사임당","age":22},
				success: function(result){
					if(result == 'ok'){
						alert('성공')
					}else{
						alert('전송실패');
					}
				}
				
			});
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
<input type="button" id="test1" value="ajax text1">
</body>
</html>