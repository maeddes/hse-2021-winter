package com.example.HelloREST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private Logger logger = LoggerFactory.getLogger(HelloRestApplication.class);

	@Value("${my.property:unset}")
	String internalProperty;

	@GetMapping("/hello")
	public String sayHello(){

		//logger.info("Current internal Property {}", internalProperty);
		logger.warn("Internal Property {}", internalProperty);
		System.out.println("In method hello. Internal Property = " + this.internalProperty);
		return "Guten Morgen, Esslingen "+ internalProperty;
		
	}

	@PostMapping("/setProperty/{paramProperty}")
	public String setProperty(@PathVariable String paramProperty){

		logger.info("Old property {} New Property {} ", internalProperty, paramProperty);	
		internalProperty = paramProperty;
		logger.info("");
		System.out.println(" In set Property. New internal property: "+internalProperty);
		return internalProperty;
	}

	//@PutMapping
	//@DeleteMapping
	//@RequestMapping(method = POST, )

	public static void main(String[] args) {
		SpringApplication.run(HelloRestApplication.class, args);
	}

}
