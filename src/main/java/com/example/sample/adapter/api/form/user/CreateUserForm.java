package com.example.sample.adapter.api.form.user;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * create user form.
 */
public class CreateUserForm {

    // Todo リクエストの例外ハンドリングクラス定義
    // Todo ValidationはFormで確認できる？できない場合はドメインで確認してBadRequest?

    @NotNull
    @Max(value = 20)
    private String name;

    @NotNull
    @Max(value = 20)
    private String email;

    @NotNull
    @Max(value = 12)
    private String password;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
