package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;

    private String password;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "roleId", referencedColumnName = "roleId")
    private Role role;
}
