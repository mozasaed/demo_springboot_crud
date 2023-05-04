package com.example.demo.controller.api;

import com.example.demo.dto.UserReqDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/user")
public interface UserApi {
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity addUser(@ModelAttribute UserReqDto userReqDto );

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getUsers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size);

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getUserById(@PathVariable("id") String id);

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public ResponseEntity editUser(@PathVariable("id") String id, @RequestBody UserReqDto userReqDto);


}
