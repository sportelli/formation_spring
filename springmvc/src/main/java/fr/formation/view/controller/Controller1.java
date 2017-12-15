package fr.formation.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.model.User;

@Controller
public class Controller1 {

	@GetMapping("/page1.htm")
	public String page1() {
		System.out.println("PAGE 1");
		return "page1"; // Vue à appeler
	}
	
	@GetMapping("/page2.htm")
	public String page2(Model model) {
		model.addAttribute("prenom", "felix");
		
		User u = new User();
		u.setLogin("monLogin");
		u.setPassword("monPassword");
		model.addAttribute("user", u);
		
		return "page2";
	}
	
}
