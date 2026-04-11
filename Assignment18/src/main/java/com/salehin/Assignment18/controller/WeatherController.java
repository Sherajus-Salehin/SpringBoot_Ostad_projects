package com.salehin.Assignment18.controller;

import com.salehin.Assignment18.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherController {
    private final GreetingService greetingService;
//    public WeatherController(GreetingService greetingService) {
//        this.greetingService = greetingService;
//    }
    @GetMapping("/weather")
    public String getWeatherMessage(){
        return greetingService.getMessage();
    }
}
