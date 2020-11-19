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