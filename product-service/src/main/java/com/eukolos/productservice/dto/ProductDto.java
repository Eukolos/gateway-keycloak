package com.eukolos.productservice.dto;

import com.eukolos.productservice.model.Product;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.List;

public record ProductDto(
        String id,
        String name,
        double price,
        double amount,
        List<String>oemList,
        Date createDate,
        Date updateDate

) {
    public static ProductDto convertToProductDto(Product product){
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getAmount(),
                product.getOemList(),
                product.getCreateDate(),
                product.getUpdateDate()
        );
    }
    public static List<ProductDto> convertToProductDtoList(List<Product> productList){
        return productList.stream().map(ProductDto::convertToProductDto).toList();
    }
}
