package org.example.competenceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CompetenceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompetenceServiceApplication.class, args);
    }
}