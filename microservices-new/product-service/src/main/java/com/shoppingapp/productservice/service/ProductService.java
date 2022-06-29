package com.shoppingapp.productservice.service;


import com.shoppingapp.productservice.model.entity.Product;
import com.shoppingapp.productservice.model.mapper.ProductMapper;
import com.shoppingapp.productservice.model.request.ProductRequest;
import com.shoppingapp.productservice.model.response.ProductResponse;
import com.shoppingapp.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

//    POST
    public void createProduct(ProductRequest productRequest){
        Product myProduct = productMapper.toEntity(productRequest);
        productRepository.save(myProduct);
        log.info("Product {} saved OK", myProduct.getId() );
    }

//    GET ALL
    public List<ProductResponse> getAllProducts() {
        List<Product> myProducts = productRepository.findAll();
        return myProducts.stream()
                .map(product -> productMapper.toDTO(product))
                .collect(Collectors.toList());
    }

}
