package io.javabrains.sec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@EnableWebSecurity //tells spring security - this is a Web Security Configuration
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override //Authentication
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("blah").password("blah").password("gringa").roles("USER")
			.and()
			.withUser("ibby").password(genPassEncoder().encode("123")).roles("USER")
			.and()
			.withUser("ayunas").password(genPassEncoder().encode("pass123!")).roles("ADMIN");
	}

	@Override //Authorization
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/**").hasRole("USER"); //all urls need to be accessible by someone with the user role
	}

//	@Bean
//	public PasswordEncoder encodePassword() {
//		return new BCryptPasswordEncoder();
//	}

	@Bean
	public PasswordEncoder genPassEncoder() {
		return NoOpPasswordEncoder.getInstance(); //red flag to devs to not do this in real app.
	}
}
