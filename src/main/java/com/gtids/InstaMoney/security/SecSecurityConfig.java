package com.gtids.InstaMoney.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}
 
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        // authentication manager (see below)
    	
    	auth.inMemoryAuthentication()
        .withUser("user1").password("user11").roles("USER")
        .and()
        .withUser("user2").password("user22").roles("USER")
        .and()
        .withUser("user3").password("user33").roles("USER");
    }
 
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // http builder configurations for authorize requests and form login (see below)
    	
    	http.authorizeRequests()
        .antMatchers("/","/todayLoanDetails","/login","/dashBoard","/about","/contact","/logout","/rest/**","/app-assets/**").permitAll()
        .anyRequest().authenticated()
        .and().formLogin().loginPage("/").permitAll()
        .and().logout().logoutSuccessUrl("/")
        .invalidateHttpSession(true)
        .deleteCookies("JSESSIONID")
        
        .permitAll();
    	
    	http.sessionManagement().invalidSessionUrl("/");
    	  

    	
    	http.csrf().disable();
    	http.headers().frameOptions().disable();
    }
}