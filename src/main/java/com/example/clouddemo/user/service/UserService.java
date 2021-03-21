package com.example.clouddemo.user.service;

import com.example.clouddemo.user.dto.UserDto;
import com.example.clouddemo.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * UserService
 *
 * @author: Xugang Song
 * @create: 2021/3/21
 */
public interface UserService {

    /**
     * 获取商品配置的分页数据
     *
     * @param pageable 分页参数
     * @return 分页数据
     */
    Page<User> getPage(Pageable pageable);

    /**
     * 加载指定的用户信息
     *
     * @param id 用户主键
     * @return 用户信息
     */
    User load(Long id);

    /**
     * 保存/更新用户
     *
     * @param userDto 用户
     * @return 用户信息
     */
    User save(UserDto userDto);

    /**
     * 删除指定的用户
     *
     * @param id 所要删除的用户主键
     */
    void delete(Long id);

}
