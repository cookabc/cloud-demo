package com.example.clouddemo.product.dto;

import com.example.clouddemo.product.entity.ProductComment;
import com.example.clouddemo.user.dto.UserDto;
import com.google.common.base.MoreObjects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * ProductCommentDto
 *
 * @author: Xugang Song
 * @create: 2021/3/21
 */
@ApiModel(value = "商品评论信息包")
@NoArgsConstructor
@Getter
@Setter
public class ProductCommentDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评论主键Id")
    private Long id;
    @ApiModelProperty(value = "所属商品")
    private ProductDto product;
    @ApiModelProperty(value = "评论作者")
    private UserDto author;
    @ApiModelProperty(value = "评论内容")
    private String content;
    @ApiModelProperty(value = "创建时间")
    private Date created;

    public ProductCommentDto(ProductComment productComment) {
        this.id = productComment.getId();
        this.content = productComment.getContent();
        this.created = productComment.getCreated();
    }

    @Override
    public String toString() {
        return this.toStringHelper().toString();
    }

    protected MoreObjects.ToStringHelper toStringHelper() {
        return MoreObjects.toStringHelper(this)
                .add("id", getId())
                .add("productId", getProduct());
    }
}
