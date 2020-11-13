package com.ego.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EgoRegistryApplication {
    public static void main(String[] args) {
        SpringApplication.run(EgoRegistryApplication.class, args);
    }
}

