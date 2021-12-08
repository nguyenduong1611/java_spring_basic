package com.example.trainningspring.btvn.repository.database;

import com.example.trainningspring.btvn.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDB extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * FROM user where username= ?1 AND password = ?2", nativeQuery = true)
    User findUser(String username, String password);

    @Query(value = "insert into user (username, password) values (?1,?2)",nativeQuery = true)
    User insertNewUser(String username, String password);

//    @Query(value = "insert into user (username, password) values (?1,?2)",nativeQuery = true)
//    void insertData;

//    @Override
//    <S extends User> S save(S s);
}
