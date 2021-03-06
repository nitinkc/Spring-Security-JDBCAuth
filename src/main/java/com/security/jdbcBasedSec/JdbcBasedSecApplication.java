package com.security.jdbcBasedSec;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;

@SpringBootApplication
public class JdbcBasedSecApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcBasedSecApplication.class, args);
	}

	//JDBC Based Authentication mechanism
	@Bean
	UserDetailsManager x(DataSource dataSource) {
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
		jdbcUserDetailsManager.setDataSource(dataSource);
		return jdbcUserDetailsManager;
	}

	@Bean
	InitializingBean initializerJDBC(UserDetailsManager x) {
		return () -> {
			UserDetails one = User.withDefaultPasswordEncoder().username("jdbcnitin").password("password").roles("USER").build();
			x.createUser(one);

			UserDetails two = User.withDefaultPasswordEncoder().username("jdbckumar").password("password").roles("USER").build();
			x.createUser(two);
		};
	}
}