package com.example.clouddemo.product.service.impl;

import com.example.clouddemo.product.entity.Product;
import com.example.clouddemo.product.entity.ProductComment;
import com.example.clouddemo.product.repository.ProductCommentRepository;
import com.example.clouddemo.product.repository.ProductRepository;
import com.example.clouddemo.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ProductServiceImpl
 *
 * @author: Xugang Song
 * @create: 2021/3/21
 */
@SuppressWarnings("ALL")
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    protected ProductRepository productRepository;

    @Autowired
    protected ProductCommentRepository productCommentRepository;

    @Override
    public Page<Product> getPage(Pageable pageable) {
        return this.productRepository.findAll(pageable);
    }

    @Override
    public Product load(Long id) {
        return this.productRepository.findById(id).orElse(null);
    }

    @Override
    public List<ProductComment> findAllByProduct(Long productId) {
        return this.productCommentRepository.findByProductIdOrderByCreated(productId);
    }

}
