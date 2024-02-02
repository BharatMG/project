package com.xworkz.rto.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

	// BCryptPasswordEncoder encoder=

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/*
	 * @Autowired DBAuthenticationService DBAauthenticationService;
	 * 
	 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
	 * throws Exception {
	 * auth.userDetailsService(dbAauthenticationService).passwordEncoder(
	 * passwordEncoder1());
	 * 
	 * }
	 * 
	 * @Bean public PasswordEncoder passwordEncoder() { PasswordEncoder encoder =
	 * new BCryptPasswordEncoder(); return encoder; }
	 */

}
