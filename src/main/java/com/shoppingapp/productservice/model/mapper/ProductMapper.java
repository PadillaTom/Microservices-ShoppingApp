package com.shoppingapp.productservice.model.mapper;

import com.shoppingapp.productservice.model.entity.Product;
import com.shoppingapp.productservice.model.request.ProductRequest;
import com.shoppingapp.productservice.model.response.ProductResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

//    To DTO
    public ProductResponse toDTO(Product ent){
        return ProductResponse.builder()
                .id(ent.getId())
                .name(ent.getName())
                .description(ent.getDescription())
                .price(ent.getPrice())
                .build();
    }

//    To Entity
    public Product toEntity(ProductRequest dto){
       return Product.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .build();
    }
}
