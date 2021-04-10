package com.jobreadyprogrammer.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource db; //autowire the h2 in memory database by default.  must have the jdbc starter added to POM

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		define authentication mechanism (in-memory, jdbc from DB, or LDAP, spring-data-jpa)

		auth.jdbcAuthentication().dataSource(db)
				.withDefaultSchema() //add this with the jdbc authentication.  add the jdbc spring starter
				.withUser("sample-user")
				.password("pass")
				.roles("USER")
				.and()
				.withUser("ayunas")
				.password("pass")
				.roles("USER")
				.and()
				.withUser("admin")
				.password("pass-admin")
				.roles("ADMIN");
	}


//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////		define authentication mechanism (in-memory, jdbc from DB, or LDAP, spring-data-jpa)
//		auth.inMemoryAuthentication()
//			.withUser("sample-user")
//				.password("pass")
//				.roles("USER")
//			.and()
//			.withUser("ayunas")
//				.password("pass")
//				.roles("USER")
//			.and()
//			.withUser("admin")
//				.password("pass-admin")
//				.roles("ADMIN");
//	}




	@Bean
	public PasswordEncoder genPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance(); //fooling system to think there is a password encoder
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/admin-talk").hasRole("ADMIN")
			.antMatchers("/anyone-talk").hasRole("USER")
			.antMatchers("/h2_console/**").permitAll()
			.antMatchers("/").authenticated().and().formLogin();
		http.csrf().disable(); //needed to access h2-console web page
		http.headers().frameOptions().disable(); //same as above
	}
}
