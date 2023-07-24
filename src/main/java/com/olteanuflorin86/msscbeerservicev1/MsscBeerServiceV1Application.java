package com.olteanuflorin86.msscbeerservicev1;

import org.springframework.boot.SpringApplication;    
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsscBeerServiceV1Application {

	public static void main(String[] args) {
		SpringApplication.run(MsscBeerServiceV1Application.class, args);
	}

}
