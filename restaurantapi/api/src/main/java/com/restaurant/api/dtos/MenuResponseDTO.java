package com.restaurant.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.restaurant.api.dtos.appetizer.DTOS.AppetizerResponseDTO;
import com.restaurant.api.dtos.drinkDTOS.DrinkResponseDTO;
import com.restaurant.api.dtos.maincourseDTOS.MainCourseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MenuResponseDTO {

    @JsonProperty(value = "appetizers")
    private List<AppetizerResponseDTO> appetizerResponseDTOList;

    @JsonProperty(value = "drinks")
    private List<DrinkResponseDTO> drinkResponseDTOList;

    @JsonProperty(value = "main-courses")
    private List<MainCourseResponseDTO> mainCourseResponseDTOList;
}
