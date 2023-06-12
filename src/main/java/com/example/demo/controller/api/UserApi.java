package com.example.demo.controller.api;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.UserReqDto;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/user")
public interface UserApi {
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody UserReqDto userReqDto );

    @RequestMapping(value = "/auth/", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody LoginDto loginDto );

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getUsers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size);

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getUserById(@PathVariable("id") Integer id);

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public ResponseEntity editUser(@PathVariable("id") Integer id, @RequestBody UserReqDto userReqDto);

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json", consumes = "application/json")
    public ResponseEntity deleteUser(@PathVariable("id") Integer id);

}
