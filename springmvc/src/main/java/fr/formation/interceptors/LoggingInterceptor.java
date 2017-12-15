package fr.formation.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoggingInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
									Object handler, Exception exception)
			throws Exception {
		System.out.println("REQUETE TERMINEE"); // Fermer la base de données, la transaction ... 
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, 
							ModelAndView modelView)
			throws Exception {
		System.out.println("APRES APPEL CONTROLLEUR");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
				throws Exception {
		System.out.println("AVANT APPEL CONTROLLEUR");
		return true;
	}


}
