package com.restaurant.api.config;

import com.restaurant.api.entities.Appetizer;
import com.restaurant.api.entities.Drink;
import com.restaurant.api.entities.MainCourse;
import com.restaurant.api.repositories.AppetizerRepository;
import com.restaurant.api.repositories.DrinkRepository;
import com.restaurant.api.repositories.MainCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.restaurant.api.utils.Helper.loadDataFromJsonFile;

/**
 FOR DEV PURPOSE ONLY
**/

@Component
public class InitializeData implements CommandLineRunner {

    @Autowired
    private AppetizerRepository appetizerRepository;

    @Autowired
    private DrinkRepository drinkRepository;

    @Autowired
    private MainCourseRepository mainCourseRepository;

    @Override
    public void run(String... args) throws Exception {
        appetizerRepository.saveAll(loadDataFromJsonFile("/restaurant-api-data/", "appetizers.json", Appetizer.class));
        drinkRepository.saveAll(loadDataFromJsonFile("/restaurant-api-data/", "drinks.json", Drink.class));
        mainCourseRepository.saveAll(loadDataFromJsonFile("/restaurant-api-data/", "main-courses.json", MainCourse.class));
    }
}
