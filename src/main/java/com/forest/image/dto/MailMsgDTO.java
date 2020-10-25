package com.forest.image.dto;

import lombok.Data;

/**
 * 邮件信息实体
 *
 * @author Forest
 * @date 2020年10月25日 18:08
 */
@Data
public class MailMsgDTO {
    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String text;
}
