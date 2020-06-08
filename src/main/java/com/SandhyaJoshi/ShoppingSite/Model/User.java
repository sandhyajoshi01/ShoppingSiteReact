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
    @Column(name="billing_address")
    private String billingAddress;
    @Column(name="ether_address")
    private String etherAddress;

    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private Role role;
    //transient because it won't be stored in database
    @Transient
    private String token;
}
