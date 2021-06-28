package com.cts.training.bootappjpa.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	// Config the credential
	
	// auto injection of DataSource
	//@Autowired
	//private DataSource dataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// demand specific schema for implementation 
		//auth.jdbcAuthentication().dataSource(dataSource);
		
		
		UserBuilder builder = User.withDefaultPasswordEncoder();
		// create some user
		auth.inMemoryAuthentication()
			.withUser(builder.username("admin").password("admin").roles("ADMIN"))
			.withUser(builder.username("First").password("abc").roles("ADMIN"))
			.withUser(builder.username("Second").password("abc").roles("VISITOR"))
			.withUser(builder.username("Third").password("abc").roles("ADMIN","VISITOR"));
	}
	
	
	// access rule
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.cors() // allows the access from another server
		.and()
			.csrf().disable() // avoid conflict with form security
			.authorizeRequests()
				.antMatchers("/login").hasRole("ADMIN")
				.antMatchers("/api/*").hasRole("ADMIN") // patterns/url to be accessed by which roles
				.antMatchers("/home").permitAll() // patterns/url to be accessed by all
				
		.and()
			.httpBasic(); // type of auth (basic auth token/bearer token)
			
	}
	
	// config JWT/OAuth
	/*@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}*/
}













