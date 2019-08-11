package com.SandhyaJoshi.ShoppingSite.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="user")
public class User implements Serializable {
    @Id  //ID will be a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //auto increase generated value
    @Column(name = "user_id")
    private int user_id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name="lastname")
    private String lastname;
    @Column(name="email")
    private String email;
    @Column(name = "username")
    private String username;
    @Column(name="password")
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private Role role;
}
