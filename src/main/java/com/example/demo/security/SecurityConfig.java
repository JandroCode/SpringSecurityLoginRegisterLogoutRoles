package com.example.demo.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("SELECT username,password,enabled from Usuarios where username=?")
		.authoritiesByUsernameQuery("SELECT u.username,p.nombre from usuarios_perfiles up "+
		"inner join Usuarios u on u.id = up.usuario_id  " +
		"inner join Perfiles p on p.id = up.perfiles_id " +
		"where u.username = ?");
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/","/register/**","/login").permitAll()
		// Asignar permisos a URLs por ROLES
		.antMatchers("/admin/**").hasAnyAuthority("ADMIN")
		.antMatchers("/usuarios/**").hasAnyAuthority("USER","ADMINISTRADOR")
			.anyRequest().authenticated()
		.and()
			.formLogin().loginPage("/login").defaultSuccessUrl("/home",true).failureUrl("/login?error=true").permitAll()
			
			
		.and()
			.logout().logoutUrl("/logout").logoutSuccessUrl("/");
		
		
		
	
	}
		
	
	}
	
	

	
	

}
