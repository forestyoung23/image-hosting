package com.forest.image.controller;

import com.forest.image.base.ResultData;
import com.forest.image.dto.UserDTO;
import com.forest.image.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户服务
 *
 * @author Forest
 * @date 2020年04月22日 23:35
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * 
     * @param user
     * @return 
     * @author Forest
     * @date 2020/4/28 14:19
    */
    @RequestMapping("/register")
    public ResultData register(@RequestBody UserDTO user) {
        return userService.register(user);
    }
    
    /**
     * 用户登录
     * 
     * @param user
     * @return 
     * @author Forest
     * @date 2020/4/28 18:17
    */
    @RequestMapping("/login")
    public ResultData login(@RequestBody UserDTO user) {
        return userService.login(user);
    }

}
