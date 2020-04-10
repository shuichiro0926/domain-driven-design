package com.example.sample.adapter.api.dto.user;

/**
 * create user dto.
 */
public class CreateUserDto {

    private Long id;

    private String name;

    private String email;

    public CreateUserDto(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
