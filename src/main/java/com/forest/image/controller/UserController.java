package com.forest.image.controller;

import com.forest.image.base.ResultData;
import com.forest.image.dto.UserDTO;
import com.forest.image.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
    @PostMapping("/register")
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
    @PostMapping("/login")
    public ResultData login(HttpServletRequest request, @RequestBody UserDTO user) {
        ResultData resultData = userService.login(user);
        if (resultData.getSucceed()) {
            request.getSession().setAttribute("isLogin", "y");
        }
        return resultData;
    }

    @PostMapping("test")
    public String test(@RequestParam String id) {
        return id;
    }
}
