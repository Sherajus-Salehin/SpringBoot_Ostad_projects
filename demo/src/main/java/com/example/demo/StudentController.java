package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
public class StudentController {
 //map /info /goal /learning-summary /review:
    @GetMapping("/info")
    public String getInfo(){
        LocalDate date=LocalDate.now();
        String today= date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return "<h1>Sherajus Salehin<br>Spring Boot Development<br>"+today+"<br>Hello, fellow developers!<h1>";
    }
    @GetMapping("/goal")
    public String knowGoal(){
        return "My goal is to be and survive this market as a JAVA developer";
    }
    @GetMapping("/learning-summary")
    public String summary(){
        return "virtual threading, springboot initialization, rest-api basics";
    }
    @GetMapping("/review")
    public String review(){
        return "Projects created: 1\nProject class was fine, could use more planning for more efficient class.";
    }
}
