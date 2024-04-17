package com.fungtech.todolist.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")

public class HelloWorldController {
  @GetMapping
  public String getHelloWorld() {
    // System.err.println("Hello World!");
    return "Hello World";
  }
}
