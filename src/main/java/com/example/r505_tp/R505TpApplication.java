package com.example.r505_tp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class R505TpApplication {

    public static void main(String[] args) {
        SpringApplication.run(R505TpApplication.class, args);
    }

    @GetMapping("/bonjour")
    public String helloWorld() {
        return "Bonjour le monde !";
    }
}
