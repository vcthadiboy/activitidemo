package com.copart.g1.services.contracts;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ActivitiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivitiDemoApplication.class, args);
	}
	
	  @Bean
	    public CommandLineRunner init(final UserService myService) {

	        return new CommandLineRunner() {
	            public void run(String... strings) throws Exception {
	                myService.createDemoUsers();
	            }
	        };

	    }
}
