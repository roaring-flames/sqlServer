package com.example.sqlserver.service;

import com.example.sqlserver.dao.UserMapper;
import com.example.sqlserver.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public boolean addUser(User user) {
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setCreatedTime(form.format(new Date()));
        return userMapper.addUser(user);
    }

    @Override
    public boolean deleteUser(User user) {
        return userMapper.deleteUser(user);
    }

    @Override
    public boolean updatePerson(User user) {

        return userMapper.updatePerson(user);
    }

    public static void main(String[] args) {
        int a=5;
        int b=3;
        double f1 = new BigDecimal((float)a/b).setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("ddd==="+f1);

    }
}
