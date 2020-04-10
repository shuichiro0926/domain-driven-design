package com.example.sample.adapter.api;

import com.example.sample.adapter.api.dto.user.CreateUserDto;
import com.example.sample.adapter.api.form.user.CreateUserForm;
import com.example.sample.application.UserService;
import com.example.sample.domain.entity.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }
    /**
     * 新規ユーザー登録.
     */
    @Validated
    public CreateUserDto createUser(CreateUserForm createUserForm) {
        User user = userService.createUser(createUserForm);
        return new CreateUserDto(user.getId(), user.getName(), user.getEmail());
    }

}
