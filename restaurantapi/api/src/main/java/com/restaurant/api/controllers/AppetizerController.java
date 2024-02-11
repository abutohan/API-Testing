package com.restaurant.api.controllers;

import com.restaurant.api.dtos.appetizer.DTOS.AppetizerRequestDTO;
import com.restaurant.api.dtos.appetizer.DTOS.AppetizerResponseDTO;
import com.restaurant.api.services.AppetizerService;
import com.restaurant.api.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appetizers")
public class AppetizerController {

    @Autowired
    private AppetizerService appetizerService;

    @GetMapping
    public ResponseEntity<List<AppetizerResponseDTO>> getAllAppetizer(){
        return new ResponseEntity<>(appetizerService.getAllAppetizers(), HttpStatus.OK);
    }

    @GetMapping("/{appetizerId}")
    public ResponseEntity<?> getAppetizer(@PathVariable("appetizerId") Long appetizerId){
        if(appetizerService.isAppetizerExist(appetizerId)) return new ResponseEntity<>(appetizerService.getAppetizer(appetizerId), HttpStatus.OK);
        else return new ResponseEntity<>(new CustomResponse(String.format("No Appetizer with id %s", appetizerId)), HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> saveAppetizer(@RequestBody AppetizerRequestDTO appetizerRequestDTO){
        return new ResponseEntity<>(appetizerService.saveAppetizer(appetizerRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{appetizerId}")
    public ResponseEntity<?> updateAppetizer(@PathVariable("appetizerId") Long appetizerId, @RequestBody AppetizerRequestDTO appetizerRequestDTO){
        if(appetizerService.isAppetizerExist(appetizerId)) return new ResponseEntity<>(appetizerService.updateAppetizer(appetizerId, appetizerRequestDTO), HttpStatus.OK);
        else return new ResponseEntity<>(new CustomResponse(String.format("No Appetizer with id %s", appetizerId)), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{appetizerId}")
    public ResponseEntity <?> deleteAppetizer (@PathVariable("appetizerId") Long appetizerId){
        if(appetizerService.isAppetizerExist(appetizerId))
            return new ResponseEntity<>(new CustomResponse(appetizerService.deleteAppetizer(appetizerId)), HttpStatus.OK);
        else return new ResponseEntity<>(new CustomResponse(String.format("No Appetizer with id %s", appetizerId)), HttpStatus.NOT_FOUND);
    }

}
