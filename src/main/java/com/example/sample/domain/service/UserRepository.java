package com.example.sample.domain.service;

import com.example.sample.domain.entity.User;

import java.util.List;

/**
 * user repository interface.
 */
public interface UserRepository {

    /**
     * user List.
     */
    public List<User> findAll();

    /**
     * user.
     */
    public User findById(Long userId);

    /**
     * user.
     */
    public User findByEmail(String email);

    /**
     * create.
     */
    public User create(User user);

    /**
     * update email.
     */
    public User updateEmail(User user);

    /**
     * update password.
     */
    public User updatePassword(User user);
}
