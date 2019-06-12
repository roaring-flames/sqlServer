package com.example.sqlserver.service;

import com.example.sqlserver.domain.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    int addUser( User user );
    int deleteUser( User user );
}
