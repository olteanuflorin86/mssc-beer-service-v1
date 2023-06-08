package com.olteanuflorin86.msscbeerservicev1;

import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisAutoConfiguration;

@SpringBootApplication(exclude = ArtemisAutoConfiguration.class)
public class MsscBeerServiceV1Application {

	public static void main(String[] args) {
		SpringApplication.run(MsscBeerServiceV1Application.class, args);
	}

}
