package com.maronecom.first;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class HelloController {
    private static final String template = "Hello, %s!";
    private final AtomicLong cont = new AtomicLong();

    
    public String requestMethodName(@RequestParam String param) {
        return new String();
    }

    @RequestMapping("/hello")
    public HelloSpring helloSpring(@RequestParam(value = "name", defaultValue = "noName")String name){
        return new HelloSpring(cont.incrementAndGet(), String.format(template, name));
    }
}
