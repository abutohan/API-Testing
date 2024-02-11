package com.restaurant.api.controllers;

import com.restaurant.api.dtos.maincourseDTOS.MainCourseRequestDTO;
import com.restaurant.api.dtos.maincourseDTOS.MainCourseResponseDTO;
import com.restaurant.api.services.MainCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/main-courses")
public class MainCourseController {

    @Autowired
    private MainCourseService mainCourseService;

    @GetMapping
    public ResponseEntity<List<MainCourseResponseDTO>> getAllMainCourse(){
        return new ResponseEntity<>(mainCourseService.getAllMainCourse(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveMainCourse(@RequestBody MainCourseRequestDTO mainCourseRequestDTO){
        return new ResponseEntity<>(mainCourseService.saveMainCourse(mainCourseRequestDTO), HttpStatus.CREATED);
    }
}
