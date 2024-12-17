package com.tekarch.usermangementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UsermanagementserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsermanagementserviceApplication.class, args);
	}

}
