package com.restaurant.api.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 FOR DEV PURPOSE ONLY
**/

public class Helper {

    public static <T> List<T> loadDataFromJsonFile(String filePath, String filename, Class<T> targetType) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = new ClassPathResource(filePath + filename).getInputStream();
        return objectMapper.readValue(inputStream, objectMapper.getTypeFactory().constructCollectionType(List.class, targetType));
    }
}
