package com.spring.projetinhoSpringBoot3.unit.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.projetinhoSpringBoot3.domain.model.ProductModel;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.request.OrderRequest;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.request.OrdersItemRequest;
import com.spring.projetinhoSpringBoot3.infrastructure.resource.request.ProductRequest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MockHelper {

    public static String buildStringFromJsonFile(final String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get("./src/test/java/com/spring/projetinhoSpringBoot3/unit/json/" + filename)));
    }

}
