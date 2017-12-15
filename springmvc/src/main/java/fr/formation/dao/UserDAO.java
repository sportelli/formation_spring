package fr.formation.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.formation.model.User;

@Repository
public class UserDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<User> findAll(){
		List<User> users = new ArrayList<User>();
//		users.add(new User(1, "sportelli", ""));
//		users.add(new User(2, "heilig", ""));
//		users.add(new User(3, "dupont", ""));
		
		users = this.entityManager.createQuery("From User u").getResultList();
		
		return users;
	}
	
	public User create(User user) {
//		user.setId(1);
//		return user;
		entityManager.persist(user);
		return user;
	}

	public User find(Integer id) {
		return new User(id, "sportelli" + id, "");
	}
	
}
