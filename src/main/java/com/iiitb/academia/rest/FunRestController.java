package com.iiitb.academia.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @GetMapping("/")
    public String sayHello() {
        return "hello world";
    }

    @GetMapping("/greet")
    public String sayGreet() {
        return "hello world greet";
    }
}
