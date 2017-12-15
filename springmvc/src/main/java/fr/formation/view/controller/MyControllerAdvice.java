package fr.formation.view.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import fr.formation.view.exceptions.UserUnknownException;

@ControllerAdvice
public class MyControllerAdvice {

	@ExceptionHandler(Exception.class)
	public String gererMonException(Exception e) {
		return "error";
	}	

	@ExceptionHandler(UserUnknownException.class)
	public String gestionUtilisateurInconnu(UserUnknownException e) {
		return "redirect:/login.htm";
	}	
	
}
