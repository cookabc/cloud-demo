package com.example.clouddemo.product.dto;

import com.example.clouddemo.product.entity.Product;
import com.google.common.base.MoreObjects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * ProductDto
 *
 * @author: Xugang Song
 * @create: 2021/3/21
 */
@ApiModel(value = "商品信息包")
@NoArgsConstructor
@Getter
@Setter
public class ProductDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品主键Id")
    private Long id;
    @ApiModelProperty(value = "商品名称")
    private String name;
    @ApiModelProperty(value = "商品封面图片")
    private String coverImage;
    @ApiModelProperty(value = "商品价格(单位:分)")
    private int price;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.coverImage = product.getCoverImage();
        this.price = product.getPrice();
    }

    @Override
    public String toString() {
        return this.toStringHelper().toString();
    }

    protected MoreObjects.ToStringHelper toStringHelper() {
        return MoreObjects.toStringHelper(this)
                .add("id", getId())
                .add("name", getName());
    }

}
