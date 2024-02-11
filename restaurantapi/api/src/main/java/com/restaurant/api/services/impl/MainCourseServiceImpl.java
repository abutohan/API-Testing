package com.restaurant.api.services.impl;

import com.restaurant.api.dtos.maincourseDTOS.MainCourseRequestDTO;
import com.restaurant.api.dtos.maincourseDTOS.MainCourseResponseDTO;
import com.restaurant.api.entities.MainCourse;
import com.restaurant.api.repositories.MainCourseRepository;
import com.restaurant.api.services.MainCourseService;
import com.restaurant.api.utils.ObjectMapperUtils;
import com.sun.tools.javac.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainCourseServiceImpl implements MainCourseService {

    @Autowired
    private MainCourseRepository mainCourseRepository;

    @Override
    public MainCourseResponseDTO getMainCourse(Long mainCourseId) {
        return ObjectMapperUtils.map(mainCourseRepository.findById(mainCourseId), MainCourseResponseDTO.class);
    }

    @Override
    public List<MainCourseResponseDTO> getAllMainCourse() {
        return ObjectMapperUtils.mapAll(mainCourseRepository.findAll(), MainCourseResponseDTO.class);
    }

    @Override
    public MainCourseResponseDTO saveMainCourse(MainCourseRequestDTO mainCourseRequestDTO) {
        MainCourse mainCourse = ObjectMapperUtils.map(mainCourseRequestDTO, MainCourse.class);
        return ObjectMapperUtils.map(mainCourseRepository.save(mainCourse), MainCourseResponseDTO.class);
    }

    @Override
    public MainCourseResponseDTO updateMainCourse(Long mainCourseId, MainCourseRequestDTO mainCourseRequestDTO) {
        MainCourse updatedMainCourse = ObjectMapperUtils.map(mainCourseRequestDTO, MainCourse.class);
        MainCourse mainCourse = mainCourseRepository.findById(mainCourseId).get();

        mainCourse.setName(updatedMainCourse.getName());
        mainCourse.setDescription(updatedMainCourse.getDescription());
        mainCourse.setImage(updatedMainCourse.getImage());
        mainCourse.setPrice(updatedMainCourse.getPrice());

        return ObjectMapperUtils.map(mainCourseRepository.save(mainCourse), MainCourseResponseDTO.class);
    }

    @Override
    public String deleteMainCourse(Long mainCourseId) {
        mainCourseRepository.deleteById(mainCourseId);
        return String.format("Main Course with id %s deleted.", mainCourseId);
    }

    @Override
    public boolean isMainCourseExist(Long mainCourseId) { return mainCourseRepository.existsById(mainCourseId);
    }
}
