<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
<tr>
		<th>id</th>
		<th>password</th>
		<th>name</th>
		<th>email</th>
		<th>gender</th>
		<th>age</th>
		<th>phone</th>
		<th>address</th>
		<th>date</th>
</tr>
<c:forEach var="member" items="${memberList}">
	<tr>
		<td><a href="memberView.do?id=${member.id }">${member.id }</a></td>
		<td>${member.passwd }</td>
		<td>${member.name }</td>
		<td>${member.email }</td>
		<td>${member.gender }</td>
		<td>${member.age }</td>
		<td>${member.phone }</td>
		<td>${member.address }</td>
		<td>${member.enrollDate }</td>
	</tr>	
</c:forEach>
</table>
</body>
</html>