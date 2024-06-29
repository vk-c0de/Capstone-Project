package org.npci.services;

import java.util.List;
import org.npci.entities.Todo;

public interface TodoServiceContract {

	List<Todo> getAllUsers();
//	Todo getTodoById();
	Todo createTodo(Todo todo);
	Todo updateTodo(Long id,Todo todo);
//	Todo deleteTodo(Long id);
	Todo getTodoById(Long id);
//	Todo completeTodo(Long id,Todo todo);
	long getTodoCount();
    Todo deleteById(Long id);
    boolean existsById(Long id);
//    Todo titleTodo(Long id,Todo todo);
    Todo patchTodo(Long id,Todo todo);
//    Todo descriptionTodo(Long id,Todo todo);
//    Todo compTodo(Long id,Todo todo);
}
