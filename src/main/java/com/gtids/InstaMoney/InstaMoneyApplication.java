package com.gtids.InstaMoney;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class InstaMoneyApplication implements CommandLineRunner{

	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(InstaMoneyApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		// Testing purpose to verify in startup 
		
		String password = "Test@123";
		//System.out.println(">>>>"+encoder().encode(password));
		
		BCrypt bCrypt = new BCrypt();
		
		System.out.println("2>>>"+bCrypt.hashpw(password, BCrypt.gensalt()));
		String hash= "$2y$12$xE8mFrOITDNrgkwM.8JEju7lpct3KRbxoGS5uE2PzyVdZk8Jnzrdy";
		
		
		boolean s = BCrypt.checkpw(password, hash);
		System.out.println("result >>"+s);
		
		
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
