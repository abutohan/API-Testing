package com.restaurant.api.dtos.drinkDTOS;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DrinkRequestDTO {

    @JsonProperty("drink_id")
    private Long id;

    @JsonProperty("drink_name")
    private String name;

    @JsonProperty("drink_description")
    private String description;

    @JsonProperty("drink_image")
    private String image;

    @JsonProperty("drink_price")
    private double price;
}

