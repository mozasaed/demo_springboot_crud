package com.example.demo.repo;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    @Query("SELECT u.password FROM User u WHERE u.userName = :userName")
    String findPasswordByUserName(@Param("userName") String userName);

    Optional<User> findByUserName(String userName);
}
