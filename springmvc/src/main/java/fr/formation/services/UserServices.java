package fr.formation.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import fr.formation.dao.UserDAO;
import fr.formation.model.User;

@Service
public class UserServices {

	@Autowired
	private UserDAO userDAO;
	
	public List<User> getAll(){
		return userDAO.findAll();
	}

	public User getUserById(Integer id) {
		return userDAO.find(id);
	}

	@Transactional
	public User create(User user) {
		return userDAO.create(user);
	}
	
}
