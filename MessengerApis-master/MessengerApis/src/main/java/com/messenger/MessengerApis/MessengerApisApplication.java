package com.messenger.MessengerApis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class MessengerApisApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessengerApisApplication.class, args);
	}

}
