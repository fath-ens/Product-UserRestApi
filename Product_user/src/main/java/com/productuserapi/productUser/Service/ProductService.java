package com.productuserapi.productUser.Service;

import com.productuserapi.productUser.Entity.Product;
import com.productuserapi.productUser.Entity.User;
import com.productuserapi.productUser.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }


    public List<Product> getUserID(User user) {
        return user.getProduct();
    }

    public void saveNewProduct(Product product) {
        productRepository.save(product);
    }

    public Product editProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> getProductID(Integer id) {
        return productRepository.findById(id);
    }
}
