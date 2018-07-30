package com.example.reactive.reactivetest.dao;

import com.example.reactive.reactivetest.model.WeatherInfo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface WeatherRepository extends ReactiveMongoRepository<WeatherInfo, String> {
    Flux<WeatherInfo> findByCityAndState(String city, String state);
}
