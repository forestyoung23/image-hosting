package com.forest.image.dto;

import lombok.Data;

/**
 * 用户实体
 *
 * @author Forest
 * @date 2020年04月28日 14:14
 */
@Data
public class UserDTO {
    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;
}
