package com.security.jdbcBasedSec.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by nitin on Wednesday, February/19/2020 at 11:13 PM
 */

@RestController
public class GreetingsController {

    @GetMapping("/")
    public String healthCheck() {
        return "Hello, World!!";
    }

    @GetMapping("/inMemoryGreetings")
    public String InMemoryGreetings(Principal principal){
        return "Hello, " + principal.getName() + "!!";
    }
}
