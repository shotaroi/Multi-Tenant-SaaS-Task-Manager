package com.shotaroi.multitenantsaastaskmanager;

import com.shotaroi.multitenantsaastaskmanager.security.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Import;

@Import(SecurityConfig.class)
@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
public class MultiTenantSaaSTaskManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiTenantSaaSTaskManagerApplication.class, args);
    }
}
