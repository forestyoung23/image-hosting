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