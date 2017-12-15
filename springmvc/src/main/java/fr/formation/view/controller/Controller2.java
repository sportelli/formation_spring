package fr.formation.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.model.User;
import fr.formation.services.UserServices;

@Controller
public class Controller2 {

	@Autowired
	UserServices userServices;
	
	@GetMapping("/page3.htm")
	public String page3(Model model) {
		//System.out.println(this.userServices.getAll());
		List<User> users = 
				this.userServices.getAll();
		model.addAttribute("users", users);
		
		return "page3";
	}

	public UserServices getUserServices() {
		return userServices;
	}

	public void setUserServices(UserServices userServices) {
		this.userServices = userServices;
	}
	
}
