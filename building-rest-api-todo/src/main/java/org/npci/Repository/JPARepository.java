package org.npci.Repository;

import org.npci.entities.Todo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.TransactionScoped;
 
@TransactionScoped
@Repository
public class JPARepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public long save(Todo todo) {
		System.out.println(todo);
		return entityManager.merge(todo).getId();
	}

}
