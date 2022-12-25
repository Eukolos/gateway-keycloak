package com.eukolos.productservice.controller;

import com.eukolos.productservice.dto.ProductAddRequest;
import com.eukolos.productservice.dto.ProductDto;
import com.eukolos.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/product")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto addProduct(@RequestBody ProductAddRequest request){
        return service.addProduct(request);
    }
    @GetMapping
    public List<ProductDto> getProductList(){
        return service.getProductList();
    }
    @GetMapping("/oems/{oem}")
    public List<ProductDto> getProductListByOem(@PathVariable String oem){
        return service.getProductListByOem(oem);
    }
    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable String id){
        return service.getProduct(id);
    }
    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable String id, @RequestBody ProductAddRequest request){
        return service.updateProduct(id, request);
    }
    @DeleteMapping("/{id}")
    public Boolean deleteProduct(@PathVariable String id){
        return service.deleteProduct(id);
    }
}
