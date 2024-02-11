package com.restaurant.api.controllers;

import com.restaurant.api.dtos.drinkDTOS.DrinkRequestDTO;
import com.restaurant.api.dtos.drinkDTOS.DrinkResponseDTO;
import com.restaurant.api.services.DrinkService;
import com.restaurant.api.utils.CustomResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drinks")
@Tag(name = "Drink REST API Endpoints")
public class DrinkController {

    @Autowired
    private DrinkService drinkService;

    @GetMapping
    @Operation(summary = "Returns a list of available Drinks.",
               description = "Returns a list of available Drinks in the DB.")
    public ResponseEntity<List<DrinkResponseDTO>> getAllDrinks(){
        return new ResponseEntity<>(drinkService.getAllDrinks(), HttpStatus.OK);
    }

    @GetMapping("/{drinkId}")
    @Operation(summary = "Returns information of a single Drink.",
               description = "Takes an id of a Drink and return it's details.")
    public ResponseEntity<?> getDrink(@PathVariable("drinkId") Long drinkId){
        if(drinkService.isDrinkExist(drinkId)) return new ResponseEntity<>(drinkService.getDrink(drinkId), HttpStatus.OK);
        else return new ResponseEntity<>(new CustomResponse(String.format("No Drink found with id %s", drinkId)), HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @Operation(summary = "Saves a Drink information to the DB.",
               description = "Populate the required request body fields.")
    public ResponseEntity<?> saveDrink(@RequestBody DrinkRequestDTO drinkRequestDTO){
        return new ResponseEntity<>(drinkService.saveDrink(drinkRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{drinkId}")
    @Operation(summary = "Update a Drink information to the DB.",
            description = "Provide the Drink id and populate the required request body fields.")
    public ResponseEntity<?> updateDrink(@PathVariable("drinkId") Long drinkId , @RequestBody DrinkRequestDTO drinkRequestDTO){
        if(drinkService.isDrinkExist(drinkId)) return new ResponseEntity<>(drinkService.updateDrink(drinkId, drinkRequestDTO), HttpStatus.OK);
        else return new ResponseEntity<>(new CustomResponse(String.format("No Drink found with id %s.", drinkId)), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{drinkId}")
    @Operation(summary = "Delete a Drink information to the DB.",
            description = "Provide the Drink id you wish to delete.")
    public ResponseEntity<?> deleteDrink(@PathVariable("drinkId") Long drinkId){
        if (drinkService.isDrinkExist(drinkId)) return new ResponseEntity<>(new CustomResponse(drinkService.deleteDrink(drinkId)), HttpStatus.OK);
        else return new ResponseEntity<>(new CustomResponse(String.format("No Drink found with id %s.", drinkId)), HttpStatus.NOT_FOUND);
    }

}
