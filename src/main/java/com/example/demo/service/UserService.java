package com.example.demo.service;

import com.example.demo.dto.UserReqDto;
import com.example.demo.dto.UserRespDto;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
@Data
public class UserService {
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepository;

    public UserService(ModelMapper modelMapper, UserRepo userRepository){
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }
    public Boolean add (UserReqDto userReqDto) {
//        User u = new User();
//        u.setAddress(userReqDto.getAddress());
//        u.setEmail(userReqDto.getEmail());
//        u.setPhone(userReqDto.getPhone());
//        u.setFirstName(userReqDto.getFirstName());
//        u.setLastName(userReqDto.getLastName());
//        userRepository.save(u);
        User users = modelMapper.map(userReqDto, User.class);
        userRepository.save(users);

        Map response = new HashMap();
        response.put("response", Boolean.TRUE);
        return Boolean.TRUE;
    }
    public List<UserRespDto> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        UserRespDto userRespDto = null;
        List list = new ArrayList();
        for(User users : userRepository.findAll(pageable)){
            userRespDto = modelMapper.map(users,UserRespDto.class);
            list.add(userRespDto);
        }
        return list;
    }
    public UserRespDto getById(String userId){
        Optional<User> u = userRepository.findById(Integer.valueOf(userId));
        if(!u.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,userId+"  "+"doesn't exist");
        }
        return modelMapper.map(u.get(), UserRespDto.class);
    }
    public ResponseEntity edit(String userId, UserReqDto userReqDto){
        Optional<User> s = userRepository.findById(Integer.valueOf(userId));

        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        if(s.isPresent()){
            User users = modelMapper.map(userReqDto, User.class);
            users.setUserId(Integer.parseInt(userId));
            userRepository.save(users);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,userId);
        }
        Map response=new HashMap();
        response.put("response",Boolean.TRUE);
        return  ResponseEntity.ok().body(response);

    }
}
