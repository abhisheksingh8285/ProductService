package dev.abhi.productserviceaug.services;

import dev.abhi.productserviceaug.dtos.CreateProductRequestDto;
import dev.abhi.productserviceaug.dtos.FakeStoreProductDto;
import dev.abhi.productserviceaug.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
@Service("fakeStoreProductService")
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
        FakeStoreProductDto[] fakeStoreProducts =
                restTemplate.getForObject(
                        "https://fakestoreapi.com/products",
                        FakeStoreProductDto[].class
                );

        List<Product> products = new ArrayList<>();

        for (FakeStoreProductDto fakeStoreProduct: fakeStoreProducts) {
            products.add(fakeStoreProduct.toProduct());
        }

        return products;
    }

  @Override
//
  public Product createProduct(String title,
                               String description,
                               String category,
                               double price,
                               String image) {
      FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
      fakeStoreProductDto.setTitle(title);
      fakeStoreProductDto.setCategory(category);
      fakeStoreProductDto.setPrice(price);
      fakeStoreProductDto.setImage(image);
      fakeStoreProductDto.setDescription(description);

      FakeStoreProductDto response = restTemplate.postForObject(
              "https://fakestoreapi.com/products", // url
              fakeStoreProductDto, // request body
              FakeStoreProductDto.class // data type of response
      );



     return response.toProduct();
 }

    @Override
    public Product createProductV2(CreateProductRequestDto requestDto) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(requestDto.getTitle());
        fakeStoreProductDto.setCategory(requestDto.getCategory());
        fakeStoreProductDto.setPrice(requestDto.getPrice());
        fakeStoreProductDto.setImage(requestDto.getImage());
        fakeStoreProductDto.setDescription(requestDto.getDescription());


        FakeStoreProductDto response = restTemplate.postForObject(
                "https://fakestoreapi.com/products", // url
                fakeStoreProductDto, // request body
                FakeStoreProductDto.class // data type of response
        );



        return response.toProduct();
    }

    @Override
    public void deleteProduct(Long productId) {
        URI uri = null;
        try {
            uri = new URI("https://fakestoreapi.com/products/"+productId);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        restTemplate.delete(uri);
    }

    @Override
    public void updateProduct(Long productId, CreateProductRequestDto updateRequest) {
        try {
            URI uri = new URI("https://fakestoreapi.com/products/"+productId);
            restTemplate.put(uri, updateRequest);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
