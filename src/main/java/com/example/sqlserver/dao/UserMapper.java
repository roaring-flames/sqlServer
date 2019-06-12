package com.example.sqlserver.dao;

import com.example.sqlserver.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> getAllUsers();
    int addUser( User user );
    int deleteUser( User user );
}
