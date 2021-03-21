package com.example.clouddemo.user.repository;

import com.example.clouddemo.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 *
 * @author: Xugang Song
 * @create: 2021/3/21
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
