package com.forest.image.controller;

import com.forest.image.base.ResultData;
import com.forest.image.dto.UserDTO;
import com.forest.image.service.UserService;
import com.forest.image.util.ResultDataUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户服务
 *
 * @author Forest
 * @date 2020年04月22日 23:35
 */
@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * session过期时间半小时
     */
    private static final int MAX_TIME = 15 * 60;

    /**
     * 用户注册
     * 
     * @param user
     * @return 
     * @author Forest
     * @date 2020/4/28 14:19
    */
    @PostMapping("register")
    public ResultData register(@RequestBody UserDTO user) {
        return userService.register(user);
    }
    
    /**
     * 用户登录
     * 
     * @param request,user
     * @return 
     * @author Forest
     * @date 2020/4/28 18:17
    */
    @PostMapping("login")
    public ResultData login(HttpServletRequest request, @RequestBody UserDTO user) {
        ResultData resultData = userService.login(user);
        if (resultData.isSucceed()) {
            // 登录后设置session过期时间半小时
            HttpSession session = request.getSession();
            session.setAttribute("isLogin", "y");
            session.setAttribute("userName", user.getUserName());
            session.setMaxInactiveInterval(MAX_TIME);
            log.info("用户:{}登录成功", user.getUserName());
        }
        return resultData;
    }

    /**
     * 用户登出
     *
     * @param
     * @return
     * @author Forest
     * @date 2020/5/17 5:36 下午
     */
    @PostMapping("loginOut")
    public ResultData loginOut(HttpServletRequest request) {
        HttpSession session = request.getSession();
        log.info("用户：{}登出成功", session.getAttribute("userName"));
        session.setMaxInactiveInterval(-1);
        return ResultDataUtils.getSuccessResult("登出成功");
    }

    @PostMapping("test")
    public String test(@RequestParam String id) {
        throw new RuntimeException();
    }
}
