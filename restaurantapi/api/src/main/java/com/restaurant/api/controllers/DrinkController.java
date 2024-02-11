package com.restaurant.api.controllers;

import com.restaurant.api.dtos.drinkDTOS.DrinkRequestDTO;
import com.restaurant.api.dtos.drinkDTOS.DrinkResponseDTO;
import com.restaurant.api.services.DrinkService;
import com.restaurant.api.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drinks")
public class DrinkController {

    @Autowired
    private DrinkService drinkService;

    @GetMapping
    public ResponseEntity<List<DrinkResponseDTO>> getAllDrinks(){
        return new ResponseEntity<>(drinkService.getAllDrinks(), HttpStatus.OK);
    }

    @GetMapping("/{drinkId}")
    public ResponseEntity<?> getDrink(@PathVariable("drinkId") Long drinkId){
        if(drinkService.isDrinkExist(drinkId)) return new ResponseEntity<>(drinkService.getDrink(drinkId), HttpStatus.OK);
        else return new ResponseEntity<>(new CustomResponse(String.format("No Drink found with id %s", drinkId)), HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> saveDrink(@RequestBody DrinkRequestDTO drinkRequestDTO){
        return new ResponseEntity<>(drinkService.saveDrink(drinkRequestDTO), HttpStatus.CREATED);
    }
}
