package com.example.theauctioncenter.config;

/*
 * Author: Jihad
 * Date: 04/08/2018
 * About: Spring Security Configure Class
 */

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;



import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select email as principal, password as credentials, true from user_entity where email=?")
		.authoritiesByUsernameQuery("select user_email as principal, user_role_name as role from user_roles where user_email=?")
		.passwordEncoder(passwordEncoder()).rolePrefix("ROLE_");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/","/img/lg1.png","/about","/SendEmail","/css/**","/webjars/**","/signup","/login").permitAll()
		.antMatchers("/profile").hasAnyRole("USER","ADMIN")
		.antMatchers("/users","/addTask").hasRole("ADMIN")
		.and().formLogin().loginPage("/login").permitAll()
		.defaultSuccessUrl("/profile").and().logout().logoutSuccessUrl("/login");
	}
}
