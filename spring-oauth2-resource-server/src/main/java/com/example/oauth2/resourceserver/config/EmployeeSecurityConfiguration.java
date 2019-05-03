package com.example.oauth2.resourceserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class EmployeeSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;}
	
	@Autowired
	 PasswordEncoder passwordEncoder;
	 
	
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/getEmployeesList")
            .hasAnyRole("ADMIN").anyRequest().authenticated().and().formLogin()
            .permitAll().and().logout().permitAll();

        http.csrf().disable();
    }
    
  
    @Override
    @Autowired
    public void configure(AuthenticationManagerBuilder authenticationMgr) throws Exception {
    		String password = "admin"; 
    	    String encodedPassword = passwordEncoder.encode(password);  
               
        authenticationMgr.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser("admin").password(encodedPassword)
        .authorities("ROLE_ADMIN");
    
 
    }
    
}