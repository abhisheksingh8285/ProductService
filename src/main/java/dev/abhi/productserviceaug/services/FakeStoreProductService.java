package dev.abhi.productserviceaug.services;

import dev.abhi.productserviceaug.dtos.FakeStoreProductDto;
import dev.abhi.productserviceaug.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;
 public FakeStoreProductService(RestTemplate restTemplate) {
     this.restTemplate = restTemplate;
 }
    @Override
    public Product getSingleProduct(Long productId) {
        FakeStoreProductDto fakeStoreProduct=restTemplate.getForObject(
                "https://fakestoreapi.com/products/" +productId,
                FakeStoreProductDto.class
        );

        return fakeStoreProduct.toProduct();
    }

    @Override
    public List<Product> getProducts() {
        return List.of();
    }
}
