package com.gtids.InstaMoney.security;

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
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    private MyBasicAuthenticationEntryPoint authenticationEntryPoint;
 
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}
 
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        // authentication manager (see below)
    	auth.inMemoryAuthentication()
        .withUser("user1").password(encoder.encode("user1Pass"))
        .authorities("ROLE_USER");
    	
    	/*auth.inMemoryAuthentication()
        .withUser("user1").password("user11").roles("USER")
        .and()
        .withUser("user2").password("user22").roles("USER")
        .and()
        .withUser("user3").password("user33").roles("USER");*/
    }
 
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // http builder configurations for authorize requests and form login (see below)
    	
    	http.authorizeRequests()
        //.antMatchers("/","/onboard","/todayLoanDetails","/login","/dashBoard","/about","/contact","/logout","/rest/**","/app-assets/**").permitAll()
    	.antMatchers("/","/onboard","/todayLoanDetails","/login","/dashBoard","/about","/contact","/logout","/app-assets/**").permitAll() // TODO: Removed rest service calls from here , required basic auth security 
        .anyRequest().authenticated()
        //.and().formLogin().loginPage("/").permitAll() //TODO : without permitAll method
        .and().formLogin().loginPage("/")
        .and().logout().logoutSuccessUrl("/")
        .invalidateHttpSession(true)
        .deleteCookies("JSESSIONID")
        //.permitAll() //TODO : without permitAll method
    	.and().httpBasic().authenticationEntryPoint(authenticationEntryPoint);

    	http.sessionManagement().invalidSessionUrl("/");
    	  

    	
    	http.csrf().disable();
    	http.headers().frameOptions().disable();
    }
}