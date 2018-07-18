package com.afkghouri.UsedGraphenee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Primary;

@SpringBootApplication 
@Primary
public class UsedGrapheneeApplication {

	public static void main(String[] args) {
		System.out.println("main");
		SpringApplication.run(UsedGrapheneeApplication.class, args);
	}
}
