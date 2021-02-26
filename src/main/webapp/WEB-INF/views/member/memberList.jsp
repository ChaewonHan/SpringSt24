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
		<th>삭제</th>
		<th>수정</th>
		<th>회원가입</th>
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
		<td><a href="memberDel.do?id=${member.id}">삭제</a></td>
		<td><a href="memberUpdateForm.do?id=${member.id}">수정</a>
		<td><a href="memberInsertForm.do">가입</a>
	</tr>	
</c:forEach>
</table>
</body>
</html>