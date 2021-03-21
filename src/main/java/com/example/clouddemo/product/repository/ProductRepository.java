package com.example.clouddemo.product.repository;

import com.example.clouddemo.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ProductRepository
 *
 * @author: Xugang Song
 * @create: 2021/3/21
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
