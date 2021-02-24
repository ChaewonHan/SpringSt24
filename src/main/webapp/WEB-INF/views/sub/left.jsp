<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form name="loginFrm" action="loginProc.jsp">
	<table width="150" border="1">
		<tr>
			<td >아이디</td><td><input type="text" name="id" size="8"></td>
		</tr>
		<tr>
			<td>암호</td><td><input type="password" name="pass" size="8"></td>
		</tr>
		<tr align="center"><td colspan="2"><input type="submit" value="로그인"></td></tr>
	</table>

</form>
</body>
</html>