package com.restaurant.api.services.impl;

import com.restaurant.api.dtos.MenuResponseDTO;
import com.restaurant.api.services.AppetizerService;
import com.restaurant.api.services.DrinkService;
import com.restaurant.api.services.MainCourseService;
import com.restaurant.api.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private DrinkService drinkService;

    @Autowired
    private AppetizerService appetizerService;

    @Autowired
    private MainCourseService mainCourseService;


    @Override
    public MenuResponseDTO getMenu() {
        MenuResponseDTO menuResponseDTOList = new MenuResponseDTO();

        menuResponseDTOList.setDrinkResponseDTOList(drinkService.getAllDrinks());
        menuResponseDTOList.setAppetizerResponseDTOList(appetizerService.getAllAppetizers());
        menuResponseDTOList.setMainCourseResponseDTOList(mainCourseService.getAllMainCourse());
        return menuResponseDTOList;

    }
}
