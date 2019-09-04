package com.zcq.weShould;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.zcq.weShould.repository")
@SpringBootApplication
public class WeShouldApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeShouldApplication.class, args);
    }

}
