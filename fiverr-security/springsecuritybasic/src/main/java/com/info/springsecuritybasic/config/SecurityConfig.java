package com.info.springsecuritybasic.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// Securing the urls and allowing role-based access to these urls.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
        	.authorizeRequests()
        	.antMatchers("/**/*/welcome").permitAll()
	        .antMatchers("/**/*/guest").hasRole("USER") // access with user with role USER
	        .antMatchers("/**/*/admin").hasRole("ADMIN") // access with user with role ADMIN
	        .anyRequest().authenticated()
            .and()
            .httpBasic();
    }
    
	
	// In-memory authentication to authenticate the user i.e. the user credentials are stored in the memory.
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.withUser("rajwan")
				.password("{noop}12345").roles("USER") 
				.and()
				.withUser("ayunas")
				.password("{noop}12345").roles("ADMIN");
	}
}
