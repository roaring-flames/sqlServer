package com.example.sqlserver.controller;

import com.example.sqlserver.domain.User;
import com.example.sqlserver.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sqlServer")
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "查询所有", notes = "所有信息")
    @RequestMapping(value = "/getAllUser")
    public List<User> getAllUser() {
        List<User> users = userService.getAllUsers();
        return users;
    }

    @ApiOperation(value = "添加用户", notes = "添加用户")
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public boolean addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @ApiOperation(value = "删除用户", notes = "删除用户")
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public boolean deleteUser(@RequestBody User user) {
        return userService.deleteUser(user);
    }


    @ApiOperation(value = "更新用户", notes = "更新用户")
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public boolean updateUser(@RequestBody User user) {
        System.out.println("+++++++----------"+user.getSex());
        return userService.updatePerson(user);
    }


}
