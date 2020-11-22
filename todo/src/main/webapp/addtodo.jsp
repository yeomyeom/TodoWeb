<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>new todo registration</title>

<script>
function checkForm(){
	if(document.addtodo.title.value.length > 24){
		alert("제목은 24자 까지 적어주세요.");
		return false;
	}
	if(document.addtodo.name.value.length > 6){
		alert("이름은 6자 이하로 해주세요.");
		return false;
	}
	alert("통과");
}
</script>
</head>
<body>
	<form name="addtodo" method="post" action="/todo/add" onsubmit="return checkForm();">
	어떤일인가요? <br> <input type="text" name="title" value="어떤 일인가요?">
	누가 할일인가요? <br> <input type="text" name="name" value="누가 할일인가요?">
	우선순위를 선택해주세요 <br>
	1순위 <input type="radio" name="sequence" value = 1 checked>
	2순위 <input type="radio" name="sequence" value = 2>
	3순위 <input type="radio" name="sequence" value = 3>
	
	<input type="button" value="<이전" onclick="location.href='/todo/index'">
	<input type="submit" value="제출">
	<input type="reset" value="내용지우기">
	</form>
</body>
</html>