package com.example.sqlserver.service;

import com.example.sqlserver.domain.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    boolean addUser(User user);

    boolean deleteUser(User user);

    boolean updatePerson(User user);
}
