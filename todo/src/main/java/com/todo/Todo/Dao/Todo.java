package com.todo.Todo.Dao;

import java.sql.Timestamp;

public class Todo {
	private Integer todoId;
	private String title;
	private String name;
	private Integer sequence; // 우선순위
	private String type;
	private Timestamp regdate; // 등록한 시간
	
	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getTodoId() {
		return todoId;
	}
	public void setTodoId(Integer todoId) {
		this.todoId = todoId;
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
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
}
