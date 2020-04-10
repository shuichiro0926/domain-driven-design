package com.example.sample.domain.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Id;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.Date;

/**
 * User
 */
@Entity(name = "user")
public class User {

    private final String emailFormat = "";
    private final String passwordFormat = "";

    /**
     * ID
     */
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    /**
     * 名前
     */
    @Column(name = "name")
    private String name;

    /**
     * Email
     */
    @Column(name = "email")
    private String email;

    /**
     * encrypted password
     */
    @Column(name = "encrypted_password")
    private String encryptedPassword;

    /**
     * 作成日時
     */
    @CreationTimestamp
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新日時
     */
    @UpdateTimestamp
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * ユーザー作成.
     */
    public User(String name, String email, String password) {
        if(name == null || email == null || password == null) {
            throw new IllegalArgumentException("必須項目を設定してください。");
        }

        if(!email.matches(emailFormat)) {
            throw new IllegalArgumentException("emailの形式を確認してください。");
        }

        if(!password.matches(passwordFormat)) {
            throw new IllegalArgumentException("passwordの形式を確認してください。");
        }

        this.name = name;
        this.email = email;

        this.encryptedPassword = encryptPassword(password);

    }

    /**
     * email変更.
     */
    public void setEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("必須項目を設定してください。");
        }

        if(!email.matches(emailFormat)) {
            throw new IllegalArgumentException("emailの形式を確認してください。");
        }
        this.email = email;
    }

    /**
     * passwordリセット.
     */
    public void setPassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("必須項目を設定してください。");
        }

        if(!password.matches(passwordFormat)) {
            throw new IllegalArgumentException("passwordの形式を確認してください。");
        }
        this.encryptedPassword = encryptPassword(password);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    /**
     * password encoder.
     */
    private String encryptPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

}