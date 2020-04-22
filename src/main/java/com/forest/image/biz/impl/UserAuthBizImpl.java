package com.forest.image.biz.impl;

import com.forest.image.biz.UserAuthBiz;

/**
 * @author Forest
 * @date 2020年04月22日 23:53
 */
public class UserAuthBizImpl implements UserAuthBiz {

    /**
     * 校验密码
     * 密码生成规则(MD5(明文密码 + 4位随机数 + 用户id后四位))
     *
     * @param
     * @return
     * @author Forest
     * @date 2020/4/22 11:54 下午
     */
    private boolean checkPassword() {
        return true;
    }
}
