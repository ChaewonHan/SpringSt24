<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="param3.do" method="get">
		<input type="text" name="code" value=""><br/>
		<input type="text" name="memberName" value=""><br/>
		<input type="text" name="price" value=""><br/>		
		<input type="text" name="number" value=""><br/>
		<c:set var="date" value=${date }/>
		<c:if test="${date != null}">
			<input type="hidden" name="date" value="${date}">
		</c:if>
		<input type="submit">
	</form>
</body>
</html>