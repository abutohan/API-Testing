package com.restaurant.api.services.impl;

import com.restaurant.api.dtos.maincourseDTOS.MainCourseRequestDTO;
import com.restaurant.api.dtos.maincourseDTOS.MainCourseResponseDTO;
import com.restaurant.api.entities.MainCourse;
import com.restaurant.api.repositories.MainCourseRepository;
import com.restaurant.api.services.MainCourseService;
import com.restaurant.api.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainCourseServiceImpl implements MainCourseService {

    @Autowired
    private MainCourseRepository mainCourseRepository;

    @Override
    public List<MainCourseResponseDTO> getAllMainCourse() {
        return ObjectMapperUtils.mapAll(mainCourseRepository.findAll(), MainCourseResponseDTO.class);
    }

    @Override
    public MainCourseResponseDTO saveMainCourse(MainCourseRequestDTO mainCourseRequestDTO) {
        MainCourse mainCourse = ObjectMapperUtils.map(mainCourseRequestDTO, MainCourse.class);

        return ObjectMapperUtils.map(mainCourseRepository.save(mainCourse), MainCourseResponseDTO.class);
    }
}
