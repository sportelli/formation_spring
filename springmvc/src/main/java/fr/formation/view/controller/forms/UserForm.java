package fr.formation.view.controller.forms;

import javax.validation.constraints.Size;

public class UserForm {
	
	// Form Spring MVC gère le JSR 303 (Spéc. Validations)
	
	@Size(min=2, message="Identifiant obligatoire")
	private String login;
	
	@Size(min=2, message="Mot de passe obligatoire")
	private String password;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserForm [login=" + login + ", password=" + password + "]";
	}

	
}
