<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<form action="memberUpdate.do" method="post" onsubmit="return ckeckSubmit();">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" value="${member.id }"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="passwd" value="${member.passwd}"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" value="${member.name }"></td>
		</tr>
		<tr>
			<td>성별</td>
			<td><input type="radio" name="gender" value="M" ${member.gender = 'M' ? 'checked':'' }>남</td>
			<td><input type="radio" name="gender" value="F" ${member.gender = 'F' ? 'checked':'' }>여</td>
		</tr>
	</table>
</form>

<script>
/* $("#checkId").click(function(){
	var id = $("input[name=id]").val();
	if(id == ''){
		alert("아이디를 입력해 주세요");
		return false;
	}
	$.ajax({
		url: 'memberIdCheck.do',
		type: 'get',
		data: {id : id},
		success: function(data){
			if(data > 0){
				alert("아이디 있음");
			}else{
				alert("조회된 아이디가 없습니다.");
			}
		}
	});
});
 */
function ckeckSubmit(){
	var id = $("input[name=id]").val();
	var pw = $("input[name=passwd]").val();
	var name = $("input[name=name]").val();
	
	if(id == ''){
		alert("아이디를 입력해 주세요");
		return false;
	}else if(pw == ''){
		alert("비밀번호를 입력해 주세요");
		return false;
	}else if(name == ''){
		alert("이름을 입력해 주세요");
		return false;
	}
}
</script>
</body>
</html>