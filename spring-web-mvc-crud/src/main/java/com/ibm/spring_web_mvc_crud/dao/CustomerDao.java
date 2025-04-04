package com.ibm.spring_web_mvc_crud.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ibm.spring_web_mvc_crud.dto.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
@Repository
public class CustomerDao {

	private EntityManager em=Persistence.createEntityManagerFactory("mvc").createEntityManager();
	private EntityTransaction et=em.getTransaction();
	
	public User saveCustomerDao(User user) {
		if(findById(user.getId()).equals(user))
		et.begin();
		em.persist(user);
		et.commit();
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUser(){
		return em.createQuery("from User").getResultList();
		
	}
	
	public User findById(int id) {
		return em.find(User.class, id);
	}
	
	public void deleteById(int id) {
		et.begin();
		em.remove(findById(id));
		et.commit();
	}
	
	public User updateUser(User user) {
		et.begin();
		em.merge(user);
		et.commit();
		return user;
	}
}
