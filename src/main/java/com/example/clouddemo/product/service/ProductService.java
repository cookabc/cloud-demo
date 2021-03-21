package com.example.clouddemo.product.service;

import com.example.clouddemo.product.entity.Product;
import com.example.clouddemo.product.entity.ProductComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * ProductService
 *
 * @author: Xugang Song
 * @create: 2021/3/21
 */
public interface ProductService {

    /**
     * 获取商品配置的分页数据
     *
     * @param pageable 分页参数
     * @return 分页数据
     */
    Page<Product> getPage(Pageable pageable);

    /**
     * 加载指定的商品配置
     *
     * @param id 商品配置ID
     * @return 商品
     */
    Product load(Long id);

    /**
     * 加载指定商品的评论列表
     *
     * @param productId 商品配置ID
     * @return 商品评论
     */
    List<ProductComment> findAllByProduct(Long productId);

}
