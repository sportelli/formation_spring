package fr.formation.view.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlleur4 {
	// Récupération de la session HTTP
	@Autowired
	private HttpSession session;
		
	@GetMapping("/page5.htm")
	public String page5(Model model) {
		Integer nbVisites = 0;
		if (this.session.getAttribute("nbVisites") != null)
			nbVisites = (Integer) this.session.getAttribute("nbVisites");
		model.addAttribute("nbVisites", ++nbVisites);
		this.session.setAttribute("nbVisites", nbVisites);
		return "page5";
	}
	
	@GetMapping("/page6.htm")
	public String page6() {
		Integer a = 2/0;
		return "page6";
	}
	
	@GetMapping("/page7.htm")
	public String page7() {
		return "forward:/page5.htm";
	}

	@GetMapping("/page8.htm")
	public String page8() {
		return "redirect:/page5.htm";
	}
	
}
