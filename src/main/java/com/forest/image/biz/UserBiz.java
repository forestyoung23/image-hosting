package com.forest.image.biz;

import com.forest.image.base.ResultData;
import com.forest.image.dto.UserDTO;

/**
 * 用户注册Biz
 *
 * @author Forest
 * @date 2020年04月22日 23:53
 */
public interface UserBiz {
    /**
     * 用户注册
     * 
     * @param user
     * @return 
     * @author Forest
     * @date 2020/4/28 14:35
    */
    void register(UserDTO user);

    /**
     * 判断用户名是否已存在
     * 
     * @param userName
     * @return 
     * @author Forest
     * @date 2020/4/28 14:38
    */
    boolean isExistByName(String userName);

    /**
     * 用户登录
     * 
     * @param user
     * @return 
     * @author Forest
     * @date 2020/4/28 18:19
    */
    ResultData login(UserDTO user);
}
