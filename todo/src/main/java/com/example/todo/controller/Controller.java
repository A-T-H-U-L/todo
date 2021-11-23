package com.example.todo.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.entity.Todo;
import com.example.todo.services.TaskServices;
@CrossOrigin(origins="http://localhost:3000")
@RestController
public class Controller {

	
	@Autowired
	TaskServices ts;
	@RequestMapping( value="/save", method=RequestMethod.POST)
	public Todo saveTack(@RequestBody Todo t) {
		System.out.print(t);
		Todo t1= ts.saveall(t);
		
		return t1;  
		
	
	
	}
	@RequestMapping( value="/viewall", method=RequestMethod.GET)
	public List<Todo> getall(){
		
		
		return ts.getall();
		
		
	}
	@RequestMapping( value="/updatebyname",method=RequestMethod.POST)
	public Todo updatetask(@RequestBody Todo t) {
		Todo t1=ts.findallname(t.getTask());
		t1.setStatus("completed");
		ts.update(t1);
		return t1;
	}
	@RequestMapping( value="/deletetask",method=RequestMethod.POST)
	public String deletetask(@RequestBody Todo t) {
		Todo t1 =ts.findallname(t.getTask());
		ts.deletetask(t1);
		
		
		return "success";
		
		
	}
	
}
