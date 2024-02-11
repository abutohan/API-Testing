package com.restaurant.api.dtos.maincourseDTOS;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MainCourseResponseDTO {

    @JsonProperty("main_course_id")
    private Long id;

    @JsonProperty("main_course_name")
    private String name;

    @JsonProperty("main_course_description")
    private String description;

    @JsonProperty("main_course_image")
    private String image;

    @JsonProperty("main_course_price")
    private double price;
}
