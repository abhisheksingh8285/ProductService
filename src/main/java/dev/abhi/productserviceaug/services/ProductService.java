package dev.abhi.productserviceaug.services;

import dev.abhi.productserviceaug.dtos.CreateProductRequestDto;
import dev.abhi.productserviceaug.models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long productId);

    List<Product> getProducts();

    Product createProduct(String title,
                          String description,
                          String category,
                          double price,
                          String image);


    Product createProductV2(CreateProductRequestDto requestDto);


    void deleteProduct(Long productId);

    void updateProduct(Long productId, CreateProductRequestDto updateRequest);
}
