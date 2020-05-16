DROP TABLE IF EXISTS `common_file`;
CREATE TABLE `common_file`
(
    `id`          bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
    `ip`          varchar(32)     NOT NULL COMMENT '上传主机ip',
    `file_name`   varchar(128)    NULL COMMENT '文件名',
    `file_type`   varchar(64)     NULL COMMENT '文件类型',
    `file_id`     varchar(64)     NULL COMMENT '文件ID',
    `file_url`    varchar(256)    NULL COMMENT '文件地址',
    `creator`     varchar(32)     NOT NULL COMMENT '创建人',
    `create_time` datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT ='文件表';

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`          bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_id`     varchar(64)     NOT NULL COMMENT '用户id',
    `user_name`   varchar(32)     NOT NULL COMMENT '用户名',
    `password`    varchar(128)    NOT NULL COMMENT '用户密码',
    `salt`        varchar(64)     NOT NULL COMMENT '盐值',
    `mobile`      varchar(16)     NULL COMMENT '手机号',
    `email`       varchar(32)     NULL COMMENT '邮箱',
    `wechat`      varchar(32)     NULL COMMENT '微信号',
    `create_time` datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT ='文件表';