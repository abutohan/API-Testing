package com.restaurant.api.services.impl;

import com.restaurant.api.dtos.appetizer.DTOS.AppetizerRequestDTO;
import com.restaurant.api.dtos.appetizer.DTOS.AppetizerResponseDTO;
import com.restaurant.api.entities.Appetizer;
import com.restaurant.api.repositories.AppetizerRepository;
import com.restaurant.api.services.AppetizerService;
import com.restaurant.api.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class AppetizerServiceImpl implements AppetizerService {

    @Autowired
    private AppetizerRepository appetizerRepository;

    @Override
    public AppetizerResponseDTO getAppetizer(Long appetizerId) {
        return ObjectMapperUtils.map(appetizerRepository.findById(appetizerId), AppetizerResponseDTO.class);
    }

    @Override
    public List<AppetizerResponseDTO> getAllAppetizers() {
        List<Appetizer> appetizer = appetizerRepository.findAll();
        appetizer.sort(Comparator.comparing(Appetizer::getId).reversed());
        return ObjectMapperUtils.mapAll(appetizer, AppetizerResponseDTO.class);
    }

    @Override
    public AppetizerResponseDTO saveAppetizer(AppetizerRequestDTO appetizerRequestDTO) {
        Appetizer appetizer = ObjectMapperUtils.map(appetizerRequestDTO, Appetizer.class);
        return ObjectMapperUtils.map(appetizerRepository.save(appetizer), AppetizerResponseDTO.class);
    }

    @Override
    public AppetizerResponseDTO updateAppetizer(Long appetizerId, AppetizerRequestDTO appetizerRequestDTO) {
        Appetizer updatedAppetizer = ObjectMapperUtils.map(appetizerRequestDTO, Appetizer.class);
        Appetizer appetizer = appetizerRepository.findById(appetizerId).get();

        appetizer.setName(updatedAppetizer.getName());
        appetizer.setDescription(updatedAppetizer.getDescription());
        appetizer.setImage(updatedAppetizer.getImage());
        appetizer.setPrice(updatedAppetizer.getPrice());

        return ObjectMapperUtils.map(appetizerRepository.save(appetizer), AppetizerResponseDTO.class);
    }

    @Override
    public String deleteAppetizer(Long appetizerId) {
        appetizerRepository.deleteById(appetizerId);

        return String.format("Appetizer with id %s deleted.", appetizerId);
    }

    @Override
    public boolean isAppetizerExist(Long appetizerId) {
        return appetizerRepository.existsById(appetizerId);
    }
}
