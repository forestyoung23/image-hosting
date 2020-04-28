package com.forest.image.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author Forest
 * @date 2020年04月22日 23:29
 */
@Data
@TableName("user")
public class UserModel {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码(加密后，规则MD5(明文密码+盐+id后5位))
     */
    private String password;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 微信
     */
    private String wechat;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;
}
