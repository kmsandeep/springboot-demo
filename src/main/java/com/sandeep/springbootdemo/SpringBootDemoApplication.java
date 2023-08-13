package com.sandeep.springbootdemo;

import com.sandeep.springbootdemo.enums.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootDemoApplication {
    @Bean
    protected CommandLineRunner runner() {
        return (args) -> {
            System.out.println("App running: " + User.USER);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

}
