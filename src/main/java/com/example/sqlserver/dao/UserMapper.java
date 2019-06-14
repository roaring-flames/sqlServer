package com.example.sqlserver.dao;

import com.example.sqlserver.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    List<User> getAllUsers();

    boolean addUser(User user);

    boolean deleteUser(User user);

    boolean updatePerson(User user);

}
