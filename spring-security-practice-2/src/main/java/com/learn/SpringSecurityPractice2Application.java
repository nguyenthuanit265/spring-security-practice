package com.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
@SpringBootApplication
public class SpringSecurityPractice2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityPractice2Application.class, args);
    }

}
