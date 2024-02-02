package com.xworkz.rto.configuration;

import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RtoWebInit extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {

	private int maxUploadSizeInMb = 5 * 1024 * 1024; // 5 MB

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		log.info("Running getServletConfigClasses");
		// System.out.println("Running getServletConfigClasses");
		return new Class[] { RtoConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] { "/" };
	}

	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {

		File uploadDirectory = new File(System.getProperty("java.io.tmpdir"));

		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(uploadDirectory.getAbsolutePath(),
				maxUploadSizeInMb, maxUploadSizeInMb * 2, maxUploadSizeInMb / 2);

		registration.setMultipartConfig(multipartConfigElement);

	}

}
