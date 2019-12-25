package com.example.backend.pojo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @GetMapping(value = "/hello")
    public Object hello(){
        return "Hello Spring";
    }

}
