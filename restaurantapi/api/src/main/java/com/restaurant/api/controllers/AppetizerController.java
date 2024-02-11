package com.restaurant.api.controllers;

import com.restaurant.api.dtos.appetizer.DTOS.AppetizerRequestDTO;
import com.restaurant.api.dtos.appetizer.DTOS.AppetizerResponseDTO;
import com.restaurant.api.services.AppetizerService;
import com.restaurant.api.utils.CustomResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appetizers")
@Tag(name = "Appetizer REST API Endpoints")
public class AppetizerController {

    @Autowired
    private AppetizerService appetizerService;

    @GetMapping
    @Operation(summary = "Returns a list of available Appetizers.",
               description = "Returns a list of available Appetizers in the DB.")
    public ResponseEntity<List<AppetizerResponseDTO>> getAllAppetizer(){
        return new ResponseEntity<>(appetizerService.getAllAppetizers(), HttpStatus.OK);
    }

    @GetMapping("/{appetizerId}")
    @Operation(summary = "Returns information of a single Appetizer.",
               description = "Takes an id of a Appetizer and return it's details.")
    public ResponseEntity<?> getAppetizer(@PathVariable("appetizerId") Long appetizerId){
        if(appetizerService.isAppetizerExist(appetizerId)) return new ResponseEntity<>(appetizerService.getAppetizer(appetizerId), HttpStatus.OK);
        else return new ResponseEntity<>(new CustomResponse(String.format("No Appetizer with id %s", appetizerId)), HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @Operation(summary = "Saves an Appetizer information to the DB.",
               description = "Populate the required request body fields.")
    public ResponseEntity<?> saveAppetizer(@RequestBody AppetizerRequestDTO appetizerRequestDTO){
        return new ResponseEntity<>(appetizerService.saveAppetizer(appetizerRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{appetizerId}")
    @Operation(summary = "Update an Appetizer information to the DB.",
               description = "Provide the Appetizer id and populate the required request body fields.")
    public ResponseEntity<?> updateAppetizer(@PathVariable("appetizerId") Long appetizerId, @RequestBody AppetizerRequestDTO appetizerRequestDTO){
        if(appetizerService.isAppetizerExist(appetizerId)) return new ResponseEntity<>(appetizerService.updateAppetizer(appetizerId, appetizerRequestDTO), HttpStatus.OK);
        else return new ResponseEntity<>(new CustomResponse(String.format("No Appetizer with id %s", appetizerId)), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{appetizerId}")
    @Operation(summary = "Delete an Appetizer information to the DB.",
               description = "Provide the Appetizer id you wish to delete.")
    public ResponseEntity <?> deleteAppetizer (@PathVariable("appetizerId") Long appetizerId){
        if(appetizerService.isAppetizerExist(appetizerId))
            return new ResponseEntity<>(new CustomResponse(appetizerService.deleteAppetizer(appetizerId)), HttpStatus.OK);
        else return new ResponseEntity<>(new CustomResponse(String.format("No Appetizer with id %s", appetizerId)), HttpStatus.NOT_FOUND);
    }

}
