package com.forest.image.service;

import com.forest.image.base.ResultData;
import com.forest.image.dto.UserDTO;

/**
 * 用户服务
 *
 * @author Forest
 * @date 2020年04月22日 23:52
 */
public interface UserService {

    /**
     * 用户注册
     * 
     * @param user
     * @return 
     * @author Forest
     * @date 2020/4/28 14:27
    */
    ResultData register(UserDTO user);

    /**
     * 用户登录
     * 
     * @param user
     * @return 
     * @author Forest
     * @date 2020/4/28 18:17
    */
    ResultData login(UserDTO user);
}
