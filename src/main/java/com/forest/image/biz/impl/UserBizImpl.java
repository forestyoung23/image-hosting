package com.forest.image.biz.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.forest.image.base.ResultData;
import com.forest.image.biz.UserBiz;
import com.forest.image.dto.UserDTO;
import com.forest.image.mapper.UserMapper;
import com.forest.image.model.UserModel;
import com.forest.image.util.ResultDataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 用户注册Biz实现
 *
 * @author Forest
 * @date 2020年04月22日 23:53
 */
@Component
public class UserBizImpl implements UserBiz {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户注册
     * 
     * @param user
     * @return 
     * @author Forest
     * @date 2020/4/28 14:39
    */
    @Override
    public void register(UserDTO user) {
        UserModel model = new UserModel();
        // 生成用户id
        String userId = IdUtil.fastSimpleUUID();
        // 生成盐值
        String salt = RandomUtil.randomNumbers(4);
        model.setSalt(salt);
        model.setUserId(userId);
        model.setUserName(user.getUserName());
        // 加密密码
        String password = encryPassword(user.getPassword(), salt, userId);
        model.setPassword(password);
        model.setCreateTime(new Date());
        userMapper.insert(model);
    }

    /**
     * 密码加密
     * 生成规则(MD5(明文密码 + 4位随机数(随机数) + 用户id后四位))
     *
     * @param password,userId,salt
     * @return 
     * @author Forest
     * @date 2020/4/28 17:45
    */
    private String encryPassword(String password, String salt, String userId) {
        return SecureUtil.md5(password + salt + userId.substring(userId.length() - 5));
    }

    /**
     * 判断用户名是否已注册
     * 
     * @param userName
     * @return 
     * @author Forest
     * @date 2020/4/28 14:39
    */
    @Override
    public boolean isExistByName(String userName) {
        QueryWrapper<UserModel> wrapper = new QueryWrapper<UserModel>().eq("user_name", userName);
        return ObjectUtil.isNotEmpty(userMapper.selectOne(wrapper));
    }

    /**
     * 用户登录
     * 
     * @param user
     * @return 
     * @author Forest
     * @date 2020/4/28 18:20
    */
    @Override
    public ResultData login(UserDTO user) {
        QueryWrapper<UserModel> wrapper = new QueryWrapper<UserModel>().eq("user_name", user.getUserName());
        UserModel model = userMapper.selectOne(wrapper);
        if (ObjectUtil.isEmpty(model)) {
            return ResultDataUtils.getErrorResult("2001", "用户名或密码错误");
        }
        if (!checkPassword(user.getPassword(), model)) {
            return ResultDataUtils.getErrorResult("2001", "用户名或密码错误");
        }
        return ResultDataUtils.getSuccessResult("登录成功");
    }


    /**
     * 校验密码
     * 密码生成规则(MD5(明文密码 + 4位随机数 + 用户id后四位))
     *
     * @param
     * @return
     * @author Forest
     * @date 2020/4/22 11:54 下午
     */
    private boolean checkPassword(String password, UserModel model) {
        String encryPassWord = encryPassword(password, model.getSalt(), model.getUserId());
        return model.getPassword().equals(encryPassWord);
    }
}
