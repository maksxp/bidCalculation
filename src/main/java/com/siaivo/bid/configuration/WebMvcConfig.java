package com.siaivo.bid.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

@Configuration
//@EnableWebMvc - don't use it. with it css and js etc don't load

@PropertySource("classpath:application.properties")
public class WebMvcConfig implements WebMvcConfigurer {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("/resources/");
	}
    @Bean
	public TemplateResolver templateResolver (){
	ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
	templateResolver.setPrefix("WEB-INF/templates/");
	templateResolver.setSuffix(".html");
	templateResolver.setTemplateMode("HTML5");
	templateResolver.setCharacterEncoding("UTF-8");
	return templateResolver;
}
    @Bean
	public SpringTemplateEngine templateEngine (){
	SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	templateEngine.setTemplateResolver(templateResolver());
	return templateEngine;
}
   @Bean
	public ViewResolver viewResolver () {
	   ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	   viewResolver.setTemplateEngine(templateEngine());
	   viewResolver.setOrder(1);
	   viewResolver.setCharacterEncoding("UTF-8");
	   viewResolver.setContentType("text/html; charset=UTF-8");
	   return viewResolver;
   }

}