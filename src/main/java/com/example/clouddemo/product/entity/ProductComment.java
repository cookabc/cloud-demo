package com.example.clouddemo.product.entity;

import com.google.common.base.MoreObjects;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * ProductComment
 *
 * @author: Xugang Song
 * @create: 2021/3/21
 */
@Entity
@Table(name = "t_product_comment")
@Getter
@Setter
public class ProductComment implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 商品评论数据库主键
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 所示商品的Id
     */
    private Long productId;
    /**
     * 评论作者的Id
     */
    private Long authorId;
    /**
     * 评论的具体内容
     */
    private String content;
    /**
     * 评论创建时间
     */
    private Date created;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", getId())
                .add("productId", getProductId())
                .add("authorId", getAuthorId())
                .add("content", getContent()).toString();
    }
}
