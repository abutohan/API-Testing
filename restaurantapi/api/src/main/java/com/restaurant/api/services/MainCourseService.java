package com.restaurant.api.services;

import com.restaurant.api.dtos.maincourseDTOS.MainCourseRequestDTO;
import com.restaurant.api.dtos.maincourseDTOS.MainCourseResponseDTO;
import com.restaurant.api.entities.MainCourse;

import java.util.List;

public interface MainCourseService {

    MainCourseResponseDTO getMainCourse(Long mainCourseId);

    List<MainCourseResponseDTO> getAllMainCourse();

    MainCourseResponseDTO saveMainCourse(MainCourseRequestDTO mainCourseRequestDTO);

    MainCourseResponseDTO updateMainCourse(Long mainCourseId, MainCourseRequestDTO mainCourseRequestDTO);

    String deleteMainCourse(Long mainCourseId);

    boolean isMainCourseExist (Long mainCourseId);
}
