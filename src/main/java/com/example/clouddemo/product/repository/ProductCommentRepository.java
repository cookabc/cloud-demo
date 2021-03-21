package com.example.clouddemo.product.repository;

import com.example.clouddemo.product.entity.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * ProductCommentRepository
 *
 * @author: Xugang Song
 * @create: 2021/3/21
 */
public interface ProductCommentRepository extends JpaRepository<ProductComment, Long> {

    /**
     * 根据商品ID找到评论，并按创建时间排序
     *
     * @param productId 商品ID
     * @return 评论列表
     */
    List<ProductComment> findByProductIdOrderByCreated(Long productId);

}