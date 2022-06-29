package com.shoppingapp.productservice.repository;

import com.shoppingapp.productservice.model.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends MongoRepository<Product, String> {
}
