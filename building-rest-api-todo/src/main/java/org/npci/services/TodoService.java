package org.npci.services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.npci.entities.Todo;
import org.npci.exceptions.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.npci.Repository.JPARepository;
import org.npci.services.TodoServiceContract;
import org.npci.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

@Service
public class TodoService implements TodoServiceContract {

	@Autowired
	private TodoRepository repository;


	@Override
	public List<Todo> getAllUsers() {
		// TODO Auto-generated method stub
  //       return null;
		return repository.findAll();
	}


	@Override
	public Todo getTodoById(Long id) {
		return repository.findById(id).orElse(null);
//		return null;
	}

	@Override
	public Todo createTodo(Todo todo) {
//		System.out.println(todo.getCreatedAt());
		todo.setCreatedAt(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
//		System.out.println(todo.getCreatedAt());
		return repository.save(todo);
	}

	@Override
	public Todo updateTodo(Long id,Todo todo) {
		// TODO Auto-generated method stub
		   Todo existingTodo = repository.findById(id).orElse(null); 
	        if (existingTodo != null) { 
	            existingTodo.setTitle(todo.getTitle()); 
	            existingTodo.setDescription(todo.getDescription()); 
	            existingTodo.setCompleted(todo.isCompleted()); 
	            return repository.save(existingTodo); 
	        } else { 
	            return null; 
	        } 

	}
/*
	@Override
	 public Todo deleteTodo(Long id) { 
		repository.deleteById(id);
//		   return repository.deleteById(id);
		return null;

    }
*/	
	@Override
	public Todo deleteById(Long id) {
		repository.deleteById(id);
		return null;
	}
	
	@Override
	public boolean existsById(Long id) {
		if(!repository.existsById(id))
	       return false;
		else {
			return true;
    }
	
	}
	
	@Override
	public long getTodoCount() {
       return repository.count();
 
    }
/*	
    @Override
    public Todo completeTodo(Long id) {

        Todo todo = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id : " + id));

        todo.setTitle(todo.getTitle());

        Todo completeTodo = repository.save(todo);
//       return repository.save(todo);
        return repository.save(todo);
    }
  
	@Override
	public Todo completeTodo(Long id,Todo todo) {
		// TODO Auto-generated method stub
		   Todo existingTodo = repository.findById(id).orElse(null); 
	        if (existingTodo != null) { 
	        	if (existingTodo.getTitle() != null) {
	        		existingTodo.setTitle(todo.getTitle());
	        	}
	        	if (existingTodo.getDescription() != null) {
	        		existingTodo.setDescription(todo.getDescription());
	        	}
	        	if (existingTodo.isCompleted() ) {
	        		existingTodo.setCompleted(todo.isCompleted());
	        	}
	            return repository.save(existingTodo); 
	        } else { 
	            return null; 
	        } 

	}
	
	@Override
	public Todo titleTodo(Long id,Todo todo) {
		// TODO Auto-generated method stub
		   Todo existingTodo = repository.findById(id).orElse(null); 
	        if (existingTodo != null) { 
	        	System.out.println("titleTodo inside service1");
	        	if (existingTodo.getTitle() != null) {
	        		System.out.printf("titleTodo  inside service2",todo.getTitle());
	        		existingTodo.setTitle(todo.getTitle());
	        	}
	            return repository.save(existingTodo); 
	        } else { 
	            return null; 
	        } 

	}
	@Override
	public Todo descriptionTodo(Long id,Todo todo) {
		// TODO Auto-generated method stub
		   Todo existingTodo = repository.findById(id).orElse(null); 
	        if (existingTodo != null) { 
	        	if (existingTodo.getDescription() != null) {
	        		existingTodo.setDescription(todo.getDescription());
	        	}
	            return repository.save(existingTodo); 
	        } else { 
	            return null; 
	        } 

	}
	@Override
	public Todo compTodo(Long id,Todo todo) {
		// TODO Auto-generated method stub
		   Todo existingTodo = repository.findById(id).orElse(null); 
	        if (existingTodo != null) { 
	        	if (existingTodo.isCompleted() ) {
	        		existingTodo.setCompleted(todo.isCompleted());
	        	}
	            return repository.save(existingTodo); 
	        } else { 
	            return null; 
	        } 

	}
	 */ 
	
	@Override
	public Todo patchTodo(Long id,Todo todo) {
		// TODO Auto-generated method stub
		   Todo existingTodo = repository.findById(id).orElse(null); 
	        if (existingTodo != null) { 
//	        	System.out.println("titleTodo inside service1");
	        	if (todo.getTitle() != null) {
//	        		System.out.printf(" inside service2.1",todo.getTitle());
	        		existingTodo.setTitle(todo.getTitle());
	        	}
	        	else if (todo.getDescription() != null) {
//	        		System.out.printf("  inside service2.2",todo.getDescription());
	        		existingTodo.setDescription(todo.getDescription());
	        	}
	        	else if (todo.isCompleted()) {
//	        		System.out.printf("titleTodo  inside service2.3",todo.isCompleted());
	        		existingTodo.setCompleted(todo.isCompleted());
	        	}
	            return repository.save(existingTodo); 
	        } else { 
	            return null; 
	        } 

	}

}
