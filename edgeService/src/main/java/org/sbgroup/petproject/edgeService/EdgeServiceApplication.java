package org.sbgroup.petproject.edgeService;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("org.sbgroup.petproject.edgeService")
public class EdgeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdgeServiceApplication.class, args);
	}

}
