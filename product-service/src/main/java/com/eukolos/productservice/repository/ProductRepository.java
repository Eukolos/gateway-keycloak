package com.eukolos.productservice.repository;

import com.eukolos.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    Optional<List<Product>> findProductByOemListContains(String oem);
}

