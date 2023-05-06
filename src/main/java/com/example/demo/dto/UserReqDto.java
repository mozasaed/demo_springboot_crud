package com.example.demo.dto;

import lombok.Data;

@Data
public class UserReqDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private int roleId;
}
