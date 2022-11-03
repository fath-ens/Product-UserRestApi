package com.productuserapi.productUser.Repository;

import com.productuserapi.productUser.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
