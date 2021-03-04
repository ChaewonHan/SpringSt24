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
				},
				error : function(request, satus, errorData){
					alert("error code : "+request.status+"\n"
							+"message : "+request.responseTest
							+"\n"+"error: "+errorData);
				}
				
			});
		});
		$('#test2').on('click',function(){
				$.ajax({
					url : 'test2.do',
					type: 'post',
					dataType: 'json',
					success : function(data){
						$('#d2').html(
								"번호 : "+data.no
								+"<br>제목: "+data.title
								+"<br>작성자: "+decodeURIComponent(data.writer)
								+"<br>내용:"+decodeURIComponent(data.content.replace(/\+/g, " "))
								);
					},
					error : function(request, satus, errorData){
						alert("error code : "+request.status+"\n"
								+"message : "+request.responseTest
								+"\n"+"error: "+errorData);
					}
				});
		});
		$('#test3').on('click', function(){
			$.ajax({
				url: 'test3.do',
				type: 'post',
				dataType: 'json',
				success : function(data){
					var jsonStr = JSON.stringify(data);
					var json = JSON.parse(jsonStr);				
					var values = $('#d3').html();

					for(var i in json.list){
						values += json.list[i].userId+", "
						+json.list[i].userPwd+", "
						+decodeURIComponent(json.list[i].userName)+", "
						+json.list[i].age+", "
						+json.list[i].email+"<br>"
					}
					
					// valuse에 담은 값을 id가 d3인 div에 출력한다.
					$('#d3').html(values);
				},
				error : function(request, satus, errorData){
					alert("error code : "+request.status+"\n"
							+"message : "+request.responseTest
							+"\n"+"error: "+errorData);
				}
			});
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
<input type="button" id="test1" value="ajax text1">
<input type="button" id="test2" value="ajax text2">
<input type="button" id="test3" value="ajax test3">
<div id="d2"></div>
<div id="d3"></div>
</body>
</html>