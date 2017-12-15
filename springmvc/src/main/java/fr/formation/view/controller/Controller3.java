package fr.formation.view.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.formation.model.User;
import fr.formation.services.UserServices;
import fr.formation.view.controller.forms.UserForm;

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
	
	@GetMapping("/page4validation.htm")
	public String page4validation() { 
		return "page4validation";
	}
	
	@PostMapping("/page4validation.htm")
	public String page4validation(@Valid UserForm userForm, 
									BindingResult bindingResult,
									Model model
								) {
		System.out.println("userForm=" + userForm); 
		System.out.println("Y a-t-il des erreurs ? => " + bindingResult.hasErrors());

		List<String> erreurs = new ArrayList<String>();
		
		if (bindingResult.hasErrors()) {
			for(ObjectError error : bindingResult.getAllErrors()) {
				erreurs.add("Erreur: " + error.getDefaultMessage()); 
			}
		}
		
		model.addAttribute("erreurs", erreurs);
		
		return "page4validation";
	}
	
}
