package com.example.sample.adapter.repository;

import com.example.sample.domain.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * user repository.
 */
@Repository
public class UserRepositoryImpl implements com.example.sample.domain.service.UserRepository {

    private final EntityManager entityManager;

    UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAll() {
        return entityManager.createNativeQuery("SELECT * FROM user", User.class)
                .getResultList();
    }

    @Override
    public User findById(Long userId) {
        return (User) entityManager.createNativeQuery("SELECT * FROM user WHERE id = :id", User.class)
                .setParameter("id", userId)
                .getSingleResult();
    }

    @Override
    public User findByEmail(String email) {
        return (User) entityManager.createNativeQuery("SELECT * FROM user WHERE email = :email", User.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    @Override
    public User create(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public User updateEmail(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public User updatePassword(User user) {
        entityManager.persist(user);
        return user;
    }
}
