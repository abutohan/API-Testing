package com.restaurant.api.controllers;

import com.restaurant.api.dtos.MenuResponseDTO;
import com.restaurant.api.dtos.maincourseDTOS.MainCourseResponseDTO;
import com.restaurant.api.services.MenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menus")
@Tag(name = "Menu REST API Endpoint")
@CrossOrigin(origins = "*")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping
    @Operation(summary = "Returns all available selections in the Menu",
            description = "Returns all available selections in the Menu")
    public ResponseEntity<MenuResponseDTO> getMenu(){
        return new ResponseEntity<>(menuService.getMenu(), HttpStatus.OK);
    }
}
