package com.example.clouddemo.product.controller;

import com.example.clouddemo.product.dto.ProductCommentDto;
import com.example.clouddemo.product.dto.ProductDto;
import com.example.clouddemo.product.entity.Product;
import com.example.clouddemo.product.entity.ProductComment;
import com.example.clouddemo.product.service.ProductService;
import com.example.clouddemo.user.dto.UserDto;
import com.example.clouddemo.user.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ProductController
 *
 * @author: Xugang Song
 * @create: 2021/3/21
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping("/products")
@Api(value = "ProductController", description = "商品管理相关Api")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private UserRepository userRepository;

    /**
     * 获取产品信息列表
     *
     * @return 产品信息列表
     */
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "获取商品分页数据", notes = "获取商品分页数据", httpMethod = "GET", tags = "商品管理相关Api")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页，从0开始，默认为第0页", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每一页记录数的大小，默认为20", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序，格式为:property,property(,ASC|DESC)的方式组织，如sort=firstname&sort=lastname,desc", dataType = "String", paramType = "query")
    })
    public List<ProductDto> list(Pageable pageable) {
        Page<Product> page = this.productService.getPage(pageable);
        if (null != page) {
            return page.getContent().stream().map((product) -> new ProductDto(product)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "获取商品详情数据", notes = "获取商品详情数据", httpMethod = "GET", tags = "商品管理相关Api")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商品的主键", dataType = "int", paramType = "path")
    })
    public ProductDto detail(@PathVariable Long id) {
        Product product = this.productService.load(id);
        if (null == product) {
            return null;
        }
        return new ProductDto(product);
    }

    @RequestMapping(value = "/{id}/comments", method = RequestMethod.GET)
    @ApiOperation(value = "获取商品的评论列表", notes = "获取商品的评论列表", httpMethod = "GET", tags = "商品管理相关Api")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商品的主键", dataType = "int", paramType = "path")
    })
    public List<ProductCommentDto> comments(@PathVariable Long id) {
        List<ProductComment> commentList = this.productService.findAllByProduct(id);
        if (null == commentList || commentList.isEmpty())
            return Collections.emptyList();

        ProductDto productDto = new ProductDto(this.productService.load(id));
        return commentList.stream().map((comment) -> {
            ProductCommentDto dto = new ProductCommentDto(comment);
            dto.setProduct(productDto);
            dto.setAuthor(new UserDto(this.userRepository.findById(comment.getAuthorId()).orElse(null)));
            return dto;
        }).collect(Collectors.toList());
    }

}
