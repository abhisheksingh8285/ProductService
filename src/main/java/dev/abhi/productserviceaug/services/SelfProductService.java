package dev.abhi.productserviceaug.services;

import dev.abhi.productserviceaug.dtos.CreateProductRequestDto;
import dev.abhi.productserviceaug.models.Product;
import dev.abhi.productserviceaug.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("SelfProductService")
public class SelfProductService implements ProductService{
    private ProductRepository productRepository;
    SelfProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public Product getSingleProduct(Long productId) {
        return null;
    }

    @Override
    public List<Product> getProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(String title, String description,
                                 String category, double price, String image) {
        Product product = new Product();

        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(image);


        return productRepository.save(product);



    }

    @Override
    public Product createProductV2(CreateProductRequestDto requestDto) {
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {

    }

    @Override
    public void updateProduct(Long productId, CreateProductRequestDto updateRequest) {

    }
}
