package com.example.demo.dto;

import lombok.Data;

@Data
public class UserRespDto {
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
}
