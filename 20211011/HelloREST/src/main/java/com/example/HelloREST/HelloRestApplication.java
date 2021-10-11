package com.example.HelloREST;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloRestApplication {

	@Value("${my.property:unset}")
	String internalProperty;

	@GetMapping("/hello")
	public String sayHello(){

		return "Guten Morgen, Esslingen "+internalProperty;
		
	}

	@PostMapping("/setProperty/{paramProperty}")
	public String setProporty(@PathVariable String paramProperty){

		internalProperty = paramProperty;
		return internalProperty;
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloRestApplication.class, args);
	}

}
