package com.example.reactive.reactivetest.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor @AllArgsConstructor
@Document
@ToString
@Builder
public class WeatherInfo  implements Serializable {

    @Id
    private String id;

    private String city;

    private String state;

    private Float temprature;

}
