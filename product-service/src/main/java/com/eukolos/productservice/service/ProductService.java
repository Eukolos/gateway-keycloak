package com.eukolos.productservice.service;

import com.eukolos.productservice.dto.ProductAddRequest;
import com.eukolos.productservice.dto.ProductDto;
import com.eukolos.productservice.exception.ProductNotFoundException;
import com.eukolos.productservice.model.Product;
import com.eukolos.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductDto addProduct(ProductAddRequest request) {
        return ProductDto.convertToProductDto(repository.save(ProductAddRequest.convertToProduct(request)));
    }
    public List<ProductDto> getProductList() {
        return ProductDto.convertToProductDtoList(repository.findAll());
    }
    public List<ProductDto> getProductListByOem(String oem) {
        return ProductDto.convertToProductDtoList(repository.findProductByOemListContains(oem)
                .orElseThrow(()-> new ProductNotFoundException("Product which searching by " + oem + " Not Found! " )));
    }
    public ProductDto getProduct(String id) {
        return ProductDto.convertToProductDto(repository.findById(id)
                        .orElseThrow(()-> new ProductNotFoundException("Product Not Found! " + id)));
    }
    public ProductDto updateProduct(String id, ProductAddRequest request) {
        Product product = repository.findById(id)
                .orElseThrow(()-> new ProductNotFoundException("Product Not Found! " + id));
        product.setName(request.name());
        product.setAmount(request.amount());
        product.setPrice(request.price());
        product.setOemList(request.oemList());
        product.setUpdateDate((Date.valueOf(LocalDate.now())));
        return ProductDto.convertToProductDto(product);
    }
    public Boolean deleteProduct(String id){
        Product product = repository.findById(id)
                .orElseThrow(()-> new ProductNotFoundException("Product Not Found! " + id));
        repository.deleteById(product.getId());
        return true;
    }


}
