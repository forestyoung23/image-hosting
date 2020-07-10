package com.forest.image.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.forest.image.base.ResultData;
import com.forest.image.biz.UserBiz;
import com.forest.image.dto.UserDTO;
import com.forest.image.service.UserService;
import com.forest.image.util.ResultDataUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

/**
 * 用户服务实现
 *
 * @author Forest
 * @date 2020年04月22日 23:52
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserBiz userBiz;

    /**
     * 用户名规则：4到16位可为大小写字母、数字、符号_
     */
    private static final Pattern USER_NAME = Pattern.compile("^[\\w]{4,16}$");

    /**
     * 密码：6到14位可为大小写字母、数字、符号_!@#$%^&*?.
     */
    private static final Pattern PASSWORD = Pattern.compile("^[\\w!@#$%^&*?.]{6,14}$");

    /**
     * 用户注册
     *
     * @param user
     * @return
     * @author Forest
     * @date 2020/4/28 14:28
    */
    @Override
    public ResultData register(UserDTO user) {
        if (ObjectUtil.isEmpty(user)) {
            log.warn("注册失败，缺少必要请求参数，请求参数:{}", user);
            return ResultDataUtils.getErrorResult("2001", "系统异常");
        }
        if (ObjectUtil.hasEmpty(user.getUserName(), user.getPassword())) {
            log.warn("注册失败，用户名和密码必填，请求参数:{}", user);
            return ResultDataUtils.getErrorResult("2002", "用户名和密码必填");
        }
        // 校验用户名和密码格式
        ResultData resultData = checkUserNameAndPasswordPattern(user);
        if (!resultData.isSucceed()) {
            return resultData;
        }
        // 检验用户名是否已注册
        if (userBiz.isExistByName(user.getUserName())) {
            log.warn("注册失败，该用户名已注册，请求参数:{}", user);
            return ResultDataUtils.getErrorResult("2003", "该用户名已注册");
        }
        userBiz.register(user);
        return resultData;
    }

    /**
     * 校验用户名和密码格式
     *
     * @param user
     * @return
     * @author dongyang
     * @date 2020/4/29 19:18
    */
    public ResultData checkUserNameAndPasswordPattern(UserDTO user) {
        if (!USER_NAME.matcher(user.getUserName()).matches()) {
            return ResultDataUtils.getErrorResult("2001", "请输入4到16位大小写字母、数字、符号_的用户名");
        }
        if (!PASSWORD.matcher(user.getPassword()).matches()) {
            return ResultDataUtils.getErrorResult("2001", "请输入6到14位可为大小写字母、数字、符号_!@#$%^&*?.的密码");
        }
        return ResultDataUtils.getSuccessResult();
    }
    /**
     * 用户登录
     * 
     * @param user
     * @return 
     * @author Forest
     * @date 2020/4/28 18:18
    */
    @Override
    public ResultData login(UserDTO user) {
        if (ObjectUtil.isEmpty(user)) {
            log.warn("登录失败，缺少必要请求参数，请求参数:{}", user);
            return ResultDataUtils.getErrorResult();
        }
        if (ObjectUtil.hasEmpty(user.getUserName(), user.getPassword())) {
            log.warn("登录失败，用户名和密码必填，请求参数:{}", user);
            return ResultDataUtils.getErrorResult();
        }
        return userBiz.login(user);
    }
}
