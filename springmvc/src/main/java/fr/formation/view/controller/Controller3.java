package fr.formation.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.formation.model.User;
import fr.formation.services.UserServices;

@Controller
public class Controller3 {

	@Autowired
	UserServices userServices;
	
	@GetMapping("/page4.htm")
	public String page4(Model model) {
		return "page4";
	}

	@PostMapping("/page4.htm")
	public String page4(@ModelAttribute("prenom") String prenom , Model model) {
		System.out.println("prénom reçu=" + prenom);
		return "page4";
	}

	@GetMapping("/page4objet.htm")
	public String page4objet(Model model) {
		return "page4objet";
	}
	
	@PostMapping("/page4objet.htm")
	public String page4objet(@ModelAttribute("user") User user , Model model) {
		System.out.println("user reçu=" + user);
		return "page4objet";
	}
	
	
}
