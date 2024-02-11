package com.restaurant.api.services.impl;

import com.restaurant.api.dtos.drinkDTOS.DrinkRequestDTO;
import com.restaurant.api.dtos.drinkDTOS.DrinkResponseDTO;
import com.restaurant.api.entities.Drink;
import com.restaurant.api.repositories.DrinkRepository;
import com.restaurant.api.services.DrinkService;
import com.restaurant.api.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkServiceImpl implements DrinkService{

    @Autowired
    private DrinkRepository drinkRepository;

    @Override
    public DrinkResponseDTO getDrink(Long drinkId) {
        return ObjectMapperUtils.map(drinkRepository.findById(drinkId), DrinkResponseDTO.class);
    }

    @Override
    public List<DrinkResponseDTO> getAllDrinks() {
        return ObjectMapperUtils.mapAll(drinkRepository.findAll(), DrinkResponseDTO.class);
    }

    @Override
    public DrinkResponseDTO saveDrink(DrinkRequestDTO drinkRequestDTO) {
        Drink drink = ObjectMapperUtils.map(drinkRequestDTO, Drink.class);

        return ObjectMapperUtils.map(drinkRepository.save(drink), DrinkResponseDTO.class);
    }

    @Override
    public DrinkResponseDTO updateDrink(Long drinkId, DrinkRequestDTO drinkRequestDTO) {
        Drink updateDrink = ObjectMapperUtils.map(drinkRequestDTO, Drink.class);
        Drink drink = drinkRepository.findById(drinkId).get();

        drink.setName(updateDrink.getName());
        drink.setDescription(updateDrink.getDescription());
        drink.setImage(updateDrink.getImage());
        drink.setPrice(updateDrink.getPrice());

    return ObjectMapperUtils.map(drinkRepository.save(drink), DrinkResponseDTO.class);
    }

    @Override
    public boolean isDrinkExist(Long drinkId) {
        return drinkRepository.existsById(drinkId);
    }
}
