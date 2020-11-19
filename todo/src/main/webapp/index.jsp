<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="com.todo.TodoDao.TodoDao"%>
<%@ page import="com.todo.TodoDto.Todo" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
</head>
<body>
	<h2>Hello World!</h2>
	<%
	ArrayList<Todo> todoList = new ArrayList<Todo>();
	todoList = TodoDao.allTodoList(); 
	if(todoList != null){
		for(int i=0; i<todoList.size(); i++){
	%>
	<span>제목 : <%=todoList.get(i).getTitle()%></span>
	<span>이름 : <%=todoList.get(i).getName()%></span>
	<span>우선순위 : <%=todoList.get(i).getSequence()%></span>
	<span>타입 : <%=todoList.get(i).getType()%></span>
	<span>날짜 : <%=todoList.get(i).getRegdate()%></span>
	<%
		}
	}
	%>
</body>
</html>
