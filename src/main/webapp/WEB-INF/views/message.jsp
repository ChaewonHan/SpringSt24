<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
${data1 }
${data2 }
<fmt:formatDate value="${date}" pattern="yyyy년 MM월 dd일 E요일"/>
${date }
</body>
</html>