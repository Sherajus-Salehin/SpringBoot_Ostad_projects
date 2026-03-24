package com.example.Assignment15.controller;

import com.example.Assignment15.model.Test;
import com.example.Assignment15.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    TestService ts;


    @GetMapping("/basic")
    String basic(){
        return "ok";
    }

    @PostMapping("/add/{b}")
    void setTest(@PathVariable String b){
        ts.construct(b);
    }

    @GetMapping("/all")
    List<Test> getTests(){
        return ts.allData();
    }

}
