package dev.abhi.productserviceaug.controllers;

import dev.abhi.productserviceaug.dtos.CreateProductRequestDto;
import dev.abhi.productserviceaug.models.Product;
import dev.abhi.productserviceaug.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;
    private RestTemplate restTemplate;

    public ProductController(@Qualifier("SelfProductService") ProductService productService
    , RestTemplate restTemplate) {
        this.productService = productService;
        this.restTemplate = restTemplate;
    }


     @PostMapping("/products")
     public Product createProduct(@RequestBody CreateProductRequestDto request) {
         return productService.createProduct(
                 request.getTitle(),
                 request.getDescription(),
                 request.getCategory(),
                 request.getPrice(),
                 request.getImage()
         );
     }



    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") Long productId)  {
        return productService.getSingleProduct(productId);
    }

    @GetMapping("/products")
    public List<Product> getAllProduct() {
    return productService.getProducts();
    }

    @PutMapping("products/{id}")
    public void updateProduct(@PathVariable("id") Long productId,@RequestBody CreateProductRequestDto updateRequest) {
      productService.updateProduct(productId,updateRequest);
    }
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") Long productId) {
     productService.deleteProduct(productId);
    }
}
