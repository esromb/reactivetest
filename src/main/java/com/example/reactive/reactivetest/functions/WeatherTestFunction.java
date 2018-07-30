package com.example.reactive.reactivetest.functions;

import com.example.reactive.reactivetest.dao.WeatherRepository;
import com.example.reactive.reactivetest.model.WeatherInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class WeatherTestFunction {
    @Bean
    RouterFunction<?> routes(WeatherRepository weatherRepository) {
        return  nest(RequestPredicates.path("/weather"), route(RequestPredicates.GET("/{city}/{state}"),
                request -> {
                        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(weatherRepository.findByCityAndState(request.pathVariable("city"), request.pathVariable("state")), WeatherInfo.class);
                })
                .andRoute(RequestPredicates.POST("/").and(accept(MediaType.APPLICATION_JSON)), request -> {
                    weatherRepository.insert(request.bodyToMono(WeatherInfo.class)).subscribe();
                    return ServerResponse.ok().build();
                } ));
    }
}
