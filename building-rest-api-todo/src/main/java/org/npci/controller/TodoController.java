package org.npci.controller;

import java.util.List;
import java.util.Optional;

import org.npci.entities.Todo;
import org.npci.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class TodoController {
	@Autowired
	private TodoService todoService;
	
	@GetMapping(path="/Todo")
	public ResponseEntity<List<Todo>> getAllUsers(){
		List<Todo> todo =todoService.getAllUsers();
//		return getAllUsers(HttpStatus.OK);
		System.out.println(todo);
		return new ResponseEntity<>(todo,HttpStatus.OK);
	}

	@GetMapping(path="/Todo/{id}")
	public Todo getTodoById(@PathVariable Long id) { 
        return todoService.getTodoById(id); 
    } 
	  @GetMapping("/Todo/findById")
	    public ResponseEntity<?> findById(Integer id) {
	        return new ResponseEntity<>(todoService.getTodoCount(), HttpStatus.OK);
	    }
/*	
    @PutMapping("/Todo/{id}") 
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) { 
        return todoService.updateTodo(id, todo); 
    }
*/
	  @PutMapping("/Todo/{id}")
	    public ResponseEntity<String> updateUserById(@PathVariable Long id, @RequestBody Todo todo) {
			
			if (!todoService.existsById(id)) {
	          return new ResponseEntity<String>("User with id " + id + " doesn't exists", HttpStatus.NOT_FOUND);
	            }
			else {  
	         todoService.updateTodo(id,todo);
	         return new ResponseEntity<String>("User updated successfully", HttpStatus.OK);
	       }	
		}
	  
	@PostMapping(path="/Todo")
	public ResponseEntity<Todo> createuser(@RequestBody Todo todo){
		Todo todoCreated = todoService.createTodo(todo);
		return new ResponseEntity<>(todoCreated, HttpStatus.CREATED);
				}
	@DeleteMapping(path = "/Todo/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id) {
		
		if (!todoService.existsById(id)) {
          return new ResponseEntity<String>("User with id " + id + " doesn't exists", HttpStatus.NOT_FOUND);
            }
		else {  
         todoService.deleteById(id);
         return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
       }	
	}
/*
	@DeleteMapping("/Todo/{id}") 
    public void deleteTodo(@PathVariable Long id) { 
    	 todoService.deleteTodo(id); 
    } 
/*   
    @PatchMapping("/Todo/{id}")
    public ResponseEntity<Todo> completeTodo(@PathVariable("id") Long id){
        Todo updatedTodo = todoService.completeTodo(id);
//        return ResponseEntity.ok(updatedTodo);
        return todoService.updateTodo(id);
    }
    
    @PatchMapping("/Todo/{id}") 
    public Todo completeTodo(@PathVariable Long id, @RequestBody Todo todo) { 
          return todoService.completeTodo(id,todo); 
}
*/   
    @PatchMapping(path = "/Todo/{id}")
    public ResponseEntity<String> completeTodo(@PathVariable Long id,@RequestBody Todo todo) {
    	System.out.println(todo);
		if (!todoService.existsById(id)) {
          return new ResponseEntity<String>("User with id " + id + " doesn't exists", HttpStatus.NOT_FOUND);
            }
		else {
			todoService.patchTodo(id,todo);
			return new ResponseEntity<String>("patch data updated successfully", HttpStatus.OK);
		}
         
 
}
}