package com.shotaroi.multitenantsaastaskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.shotaroi.multitenantsaastaskmanager.repository")
public class MultiTenantSaaSTaskManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiTenantSaaSTaskManagerApplication.class, args);
    }
}
