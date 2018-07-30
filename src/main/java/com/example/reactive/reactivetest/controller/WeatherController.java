package com.example.reactive.reactivetest.controller;

import com.example.reactive.reactivetest.dao.WeatherRepository;
import com.example.reactive.reactivetest.model.WeatherInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class WeatherController {

    @Autowired
    WeatherRepository weatherRepository;

    @GetMapping(path = {"weathers"})
    public Flux<WeatherInfo> getWeather() {
        return weatherRepository.findAll();
    }

    @PostMapping(value = "weathers", consumes = "application/json")
    public Mono<WeatherInfo> create(ServerRequest request){
         return weatherRepository.insert(request.bodyToMono(WeatherInfo.class)).single().delayElement(Duration.ofMillis(100));
    }

}
