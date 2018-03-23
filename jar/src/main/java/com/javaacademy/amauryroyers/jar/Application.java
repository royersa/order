package com.javaacademy.amauryroyers.jar;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication(scanBasePackages = {"com.javaacademy.amauryroyers"})
public class Application {
    public static void main(String[] args) {
        run(Application.class, args);
    }
}
