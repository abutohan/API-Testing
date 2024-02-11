package com.restaurant.api.controllers;

import com.restaurant.api.dtos.maincourseDTOS.MainCourseRequestDTO;
import com.restaurant.api.dtos.maincourseDTOS.MainCourseResponseDTO;
import com.restaurant.api.services.MainCourseService;
import com.restaurant.api.utils.CustomResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/main-courses")
@Tag(name = "Main Course REST API Endpoints")
public class MainCourseController {

    @Autowired
    private MainCourseService mainCourseService;

    @GetMapping
    @Operation(summary = "Returns a list of available Main Course.",
               description = "Returns a list of available Main Course in the DB.")
    public ResponseEntity<List<MainCourseResponseDTO>> getAllMainCourse(){
        return new ResponseEntity<>(mainCourseService.getAllMainCourse(), HttpStatus.OK);
    }

    @GetMapping("/{mainCourseId}")
    @Operation(summary = "Returns information of a single Main Course.",
            description = "Takes an id of a Main Course and return it's details.")
    public ResponseEntity<?> getMainCourse(@PathVariable("mainCourseId") Long mainCourseId){
        if (mainCourseService.isMainCourseExist(mainCourseId)) return new ResponseEntity<>(mainCourseService.getMainCourse(mainCourseId), HttpStatus.OK);
        else return new ResponseEntity<>(new CustomResponse(String.format("No Main Course found with id %s.", mainCourseId)),HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @Operation(summary = "Saves a Main Course information to the DB.",
            description = "Populate the required request body fields.")
    public ResponseEntity<?> saveMainCourse(@RequestBody MainCourseRequestDTO mainCourseRequestDTO){
        return new ResponseEntity<>(mainCourseService.saveMainCourse(mainCourseRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{mainCourseId}")
    @Operation(summary = "Update a Main Course information to the DB.",
            description = "Provide the Main Course id and populate the required request body fields.")
    public ResponseEntity<?> updatedMainCourse(@PathVariable("mainCourseId") Long mainCourseId, @RequestBody MainCourseRequestDTO mainCourseRequestDTO){
        if (mainCourseService.isMainCourseExist(mainCourseId)) return new ResponseEntity<>(mainCourseService.updateMainCourse(mainCourseId, mainCourseRequestDTO), HttpStatus.OK);
        else return new ResponseEntity<>(new CustomResponse(String.format("No Main Course found with id %s.", mainCourseId)), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{mainCourseId}")
    @Operation(summary = "Delete a Main Course information to the DB.",
            description = "Provide the Main Course id you wish to delete.")
    public ResponseEntity<?> deleteMainCourse(@PathVariable("mainCourseId") Long mainCourseId){
        if (mainCourseService.isMainCourseExist(mainCourseId)) return new ResponseEntity<>(new CustomResponse(mainCourseService.deleteMainCourse(mainCourseId)), HttpStatus.OK);
        else return new ResponseEntity<>(new CustomResponse(String.format("No Main Course found with id %s", mainCourseId)), HttpStatus.NOT_FOUND);
    }
}
