package com.restaurant.api.services;

import com.restaurant.api.dtos.drinkDTOS.DrinkRequestDTO;
import com.restaurant.api.dtos.drinkDTOS.DrinkResponseDTO;

import java.util.List;

public interface DrinkService {

    DrinkResponseDTO getDrink(Long drinkId);

    List<DrinkResponseDTO> getAllDrinks();

    DrinkResponseDTO saveDrink(DrinkRequestDTO drinkRequestDTO);

    DrinkResponseDTO updateDrink(Long drinkId, DrinkRequestDTO drinkRequestDTO);

    boolean isDrinkExist (Long drinkId);

}
