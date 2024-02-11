package com.restaurant.api.services;

import com.restaurant.api.dtos.maincourseDTOS.MainCourseRequestDTO;
import com.restaurant.api.dtos.maincourseDTOS.MainCourseResponseDTO;

import java.util.List;

public interface MainCourseService {

    List<MainCourseResponseDTO> getAllMainCourse();

    MainCourseResponseDTO saveMainCourse(MainCourseRequestDTO mainCourseRequestDTO);
}
