package com.restaurant.api.controllers;

import com.restaurant.api.utils.CustomResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
@Tag(name = "Status REST API Endpoint")
@CrossOrigin(origins = "*")
public class StatusController {

    @GetMapping
    @Operation(summary = "This is only used to check the status of API",
            description = "This is only used to check the status of API")
    public ResponseEntity<?> checkAPIStatus(){
        return new ResponseEntity<>(new CustomResponse("Welcome to Restaurant API."), HttpStatus.OK);
    }
}
