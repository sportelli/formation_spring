package fr.formation.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringInit implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		// Permet de mapper notre classe de config
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(SpringConfig.class);
		ctx.setServletContext(container);
		
		// Configurer le Dispatcher Spring MVC (équivalent web.xml)
		ServletRegistration.Dynamic servlet = 
				container.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}

}
