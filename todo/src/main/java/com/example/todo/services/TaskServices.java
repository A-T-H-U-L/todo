package com.example.todo.services;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.todo.entity.CustomSequence;
import com.example.todo.entity.Todo;
import com.example.todo.repo.TodoRepos;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;



@Service
public class TaskServices {
	@Autowired
	TodoRepos tr;
    @Autowired
	TaskServices ts;
    @Autowired 
    private MongoOperations mongo;
    
   // public int getNextSequence(String seqName) {
		
//    //	CustomSequence counter = mongo.findAndModify(query(where("_id").is(seqName)),
//    			new Update().inc("seq",1),
//    			options().returnNew(true),CustomSequence.class);
//    	
//    	
//    	return counter.getSeq();
//    	
//    	
//    }
//    
    public int getNextSequence(String seqName)
    {
       
		CustomSequence counter = mongo.findAndModify(
            query(where("_id").is(seqName)),
            new Update().inc("seq",1),
            options().returnNew(true).upsert(true),
            CustomSequence.class);
        return counter.getSeq();
    }

    public Todo saveall(Todo t) {
		
		t.setId(ts.getNextSequence(Todo.SEQUENCE_NAME));
		System.out.println(t.getId());
		t.setStatus("created");
		tr.save(t);
		return t;
		
	}
    
    public List<Todo> getall(){
    	List<Todo> li= tr.findAll();
    	return li;
    }
    
    public Todo findallname(String task) {
    	
    	List<Todo> li=tr.findAllByTask(task);
    	
    	return li.get(0);
    }
    
    public Todo update(Todo t) {
    	tr.delete(t);
    	
    	return tr.insert(t);
    }
    
    
    public void deletetask(Todo t) {
    	
    	tr.delete(t);
    }
}


    
