package com.project.library.bookservice.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestAPI {
    @GetMapping(value = "/hello")
    public String sayHello() {
        return "=D";
    }
}
