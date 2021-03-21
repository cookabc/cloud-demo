package com.example.clouddemo.user.service.impl;

import com.example.clouddemo.user.dto.UserDto;
import com.example.clouddemo.user.entity.User;
import com.example.clouddemo.user.repository.UserRepository;
import com.example.clouddemo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserServiceImpl
 *
 * @author: Xugang Song
 * @create: 2021/3/21
 */
@SuppressWarnings("ALL")
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<User> getPage(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }

    @Override
    public User load(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public User save(UserDto userDto) {
        User user = this.userRepository.findById(userDto.getId()).orElse(null);
        if (null == user) {
            user = new User();
        }
        user.setNickname(userDto.getNickname());
        user.setAvatar(userDto.getAvatar());
        return this.userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }

}
