package com.xworkz.rto.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan("com.xworkz")
public class RtoConfiguration {

	public RtoConfiguration() {
		System.out.println("RtoConfiguration constructor");
	}

	@Bean
	public ViewResolver viewResolver() {
		System.out.println("viewResolver bean is created");
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class); /////
		resolver.setPrefix("/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean bean() {
		System.out.println("LocalContainerEntityManagerFactoryBean started");
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		System.out.println("bean created" + bean);
		return bean;
	}

}
