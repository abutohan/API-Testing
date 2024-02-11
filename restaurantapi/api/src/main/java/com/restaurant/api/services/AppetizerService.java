package com.restaurant.api.services;

import com.restaurant.api.dtos.appetizer.DTOS.AppetizerRequestDTO;
import com.restaurant.api.dtos.appetizer.DTOS.AppetizerResponseDTO;

import java.util.List;

public interface AppetizerService {

    AppetizerResponseDTO getAppetizer(Long appetizerId);

    List<AppetizerResponseDTO> getAllAppetizers();

    AppetizerResponseDTO saveAppetizer(AppetizerRequestDTO appetizerRequestDTO);

    AppetizerResponseDTO updateAppetizer(Long appetizerId, AppetizerRequestDTO appetizerRequestDTO);

    String deleteAppetizer(Long appetizerId);

     boolean isAppetizerExist(Long appetizerId);

}
