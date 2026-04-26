package com.example.product_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.product_service.Entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

    
} 