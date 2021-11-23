package com.example.todo.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="task")
public class Todo {
	public static final String SEQUENCE_NAME ="Sequence";
	
	@Id
	private int id;
	private String task;
	private String status;
	

	@Override
	public String toString() {
		return "Todo [id=" + id + ", task=" + task + ", status=" + status + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTask() {
		return task;
	}


	public void setTask(String task) {
		this.task = task;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	
}
