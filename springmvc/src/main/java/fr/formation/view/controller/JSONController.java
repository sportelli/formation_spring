package fr.formation.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.model.User;
import fr.formation.services.UserServices;

@RestController
public class JSONController {

	@Autowired
	UserServices userServices;
	
	@GetMapping("/users/")
	public List<User> getAllUsers(){
		return this.userServices.getAll();
	}
	
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable("id") Integer id){
		return this.userServices.getUserById(id);
	}
	
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		return this.userServices.create(user);
	}

//	@DeleteMapping
	
}
