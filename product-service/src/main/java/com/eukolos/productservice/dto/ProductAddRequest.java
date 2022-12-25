package com.eukolos.productservice.dto;


import com.eukolos.productservice.model.Product;

import java.util.List;

public record ProductAddRequest(
        String name,
        double price,
        double amount,
        List<String> oemList
) {
    public static Product convertToProduct(ProductAddRequest request){
        return new Product(
                request.name,
                request.price,
                request.amount,
                request.oemList
        );
    }
}
