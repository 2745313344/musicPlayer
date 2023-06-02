package com.example.qqmusic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan("com.example")
@Configuration
public class Starter {
    public static void main(String[] args) {
        SpringApplication.run(Starter.class,args);
    }
}
