package com.example.demo.controller;

import com.example.demo.controller.api.UserApi;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.UserReqDto;
import com.example.demo.service.UserService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
public class UserController implements UserApi {
    private final UserService userService;

    public ResponseEntity addUser(UserReqDto userReqDto) {
        return ResponseEntity.ok().body(userService.add(userReqDto));
    }

    public ResponseEntity getUsers(int page, int size) {
        return ResponseEntity.ok().body(userService.getAll(page, size));
    }

    public ResponseEntity getUserById(Integer id) {

        return ResponseEntity.ok().body(userService.getById(id));
    }
    public ResponseEntity editUser(Integer id, UserReqDto userReqDto) {
        return ResponseEntity.ok().body(userService.edit(id, userReqDto));
    }
    public ResponseEntity deleteUser(Integer id) {
        return ResponseEntity.ok().body(userService.delete(id));
    }

    public ResponseEntity login(LoginDto loginDto) {
        return ResponseEntity.ok().body(userService.doLogin(loginDto));

    }
}
