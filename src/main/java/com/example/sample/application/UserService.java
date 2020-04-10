package com.example.sample.application;

import com.example.sample.adapter.api.form.user.CreateUserForm;
import com.example.sample.domain.entity.User;
import com.example.sample.domain.service.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 新規ユーザー登録.
     */
    public User createUser(CreateUserForm createUserForm) {
        User user = new User(createUserForm.getName(), createUserForm.getEmail(), createUserForm.getPassword());
        return userRepository.create(user);
    }

}
