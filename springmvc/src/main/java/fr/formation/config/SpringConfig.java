package fr.formation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import fr.formation.interceptors.CalculateTimeInterceptor;
import fr.formation.interceptors.LoggingInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan("fr.formation")
public class SpringConfig extends WebMvcConfigurerAdapter{
	
	// Gestion de la vue
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// On ajoute notre LoggingInterceptor au registre des intercepteurs
		registry.addInterceptor(new LoggingInterceptor());
		registry.addInterceptor(new CalculateTimeInterceptor())
						.addPathPatterns("/*.htm") // Se lance sur tous les .htm
						.excludePathPatterns("/page1.htm"); // sauf page1.htm
	}

	//TODO : Appeler le gestionnaire de session d'Hibernate

}
