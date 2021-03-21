package com.example.clouddemo.product.entity;

import com.google.common.base.MoreObjects;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Product
 *
 * @author: Xugang Song
 * @create: 2021/3/21
 */
@Entity
@Table(name = "t_product")
@Getter
@Setter
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品数据库主键
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品封面图片
     */
    private String coverImage;
    /**
     * 商品价格(分)
     */
    private int price;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", getId())
                .add("name", getName()).toString();
    }
}
