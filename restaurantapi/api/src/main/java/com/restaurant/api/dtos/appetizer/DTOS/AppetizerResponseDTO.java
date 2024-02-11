package com.restaurant.api.dtos.appetizer.DTOS;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppetizerResponseDTO {
    @JsonProperty("appetizer_id")
    private Long id;

    @JsonProperty("appetizer_name")
    private String name;

    @JsonProperty("appetizer_description")
    private String description;

    @JsonProperty("appetizer_image")
    private String image;

    @JsonProperty("appetizer_price")
    private double price;
}
