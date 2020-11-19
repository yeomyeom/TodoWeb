<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
	<c:forEach var="todoList" items="${todoList}">
	<span>${todoList.getTitle()}</span>
	<span>${todoList.getName()}</span>
	<span>${todoList.getSequence() }</span>
	</c:forEach>
</body>
</html>
