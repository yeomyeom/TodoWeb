package com.todo.TodoDto;

public class Todo {
	//DTO 역할을 수행한다.
	//private Integer todoId;
	private String title;
	private String name;
	private int sequence; // 우선순위
	private String type;// TODO -> DOING -> DONE
	private String regdate; // 등록한 시간
	
	public Todo(String title, String name, int sequence, String type, String date) {
		super();
		this.title = title;
		this.name = name;
		this.sequence = sequence;
		this.type = type;
		this.regdate = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

}
