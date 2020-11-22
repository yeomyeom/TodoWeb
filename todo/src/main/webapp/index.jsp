<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<style>
.category{
  float: left;
  display: inline;
}
.category .tag{
  background: #0489B1;
  display: block;
  color: white;
  width: 300px;
  font-size: 20px;
  margin: 10px;
}
.category .card{
  color: black;
  display: block;
  background: #CEF6F5;
  width: 300px;
  height: 90px;
  margin: 10px;
}
.category .card #title{
  font-weight: bold;
  font-size: 15pt;
}
.category .card #detail{
  font-size:10pt;
  color
}
</style>
<script>
function upgrade(title, type){
	var xhr = new XMLHttpRequest();
	xhr.open('POST','http://localhost:8080/todo/upgradetype');
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("title="+title+"&type="+type);
	location.reload();
}
</script>
</head>
<body>
<button>새로운 TODO 등록</button>
<div class = category>	
    <div class = tag>	
        <span>TODO</span> 
    </div>
    <c:forEach var="todoListTODO" items="${todoListTODO}">
		<div class = card>
			<div id = title><span>${todoListTODO.getTitle()}</span></div>
			<div id = detail>
			  <span>${todoListTODO.getRegdate()}</span>
			  <span>${todoListTODO.getName()}</span>
			  <span>${todoListTODO.getSequence()}</span>
			  <button onclick="upgrade('${todoListTODO.getTitle()}','${todoListTODO.getType()}')">→</button>
			</div>
		</div>
	</c:forEach>
  </div>
  
  <div class = category>	
    <div class = tag>	
        <span>DOING</span> 
    </div>
    <c:forEach var="todoListDOING" items="${todoListDOING}">
		<div class = card>
			<div id = title><span>${todoListDOING.getTitle()}</span></div>
			<div id = detail>
			  <span>${todoListDOING.getRegdate()}</span>
			  <span>${todoListDOING.getName()}</span>
			  <span>${todoListDOING.getSequence()}</span>
			  <button onclick="upgrade('${todoListDOING.getTitle()}','${todoListDOING.getType()}')">→</button>
			</div>
		</div>
	</c:forEach>
  </div>
  
  <div class = category>	
    <div class = tag>	
        <span>DONE</span> 
    </div>
    <c:forEach var="todoListDONE" items="${todoListDONE}">
		<div class = card>
			<div id = title><span>${todoListDONE.getTitle()}</span></div>
			<div id = detail>
			  <span>${todoListDONE.getRegdate()}</span>
			  <span>${todoListDONE.getName()}</span>
			  <span>${todoListDONE.getSequence()}</span>
			  <button>삭제</button>
			</div>
		</div>
	</c:forEach>
  </div>

</body>
</html>
