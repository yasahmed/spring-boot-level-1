package com.example;

import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApp implements CommandLineRunner {

    private UserService userService;

    MainApp(UserService userService)
    {
        this.userService=userService;
    }

    public static void main(String[] args)
    {
        SpringApplication.run(MainApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userService.createOrderForUserById(1L);
    }
}
