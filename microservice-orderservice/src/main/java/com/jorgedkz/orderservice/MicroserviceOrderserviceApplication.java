package com.jorgedkz.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceOrderserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceOrderserviceApplication.class, args);
	}

}
