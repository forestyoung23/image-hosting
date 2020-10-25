package com.forest.image.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 邮件服务配置
 *
 * @author Forest
 * @date 2020年10月25日 18:11
 */
@Data
@ConfigurationProperties(prefix = "mail")
public class MailProperties {
    /**
     * 接收方
     */
    private String sendTo;

    /**
     * 发送方
     */
    private String sendFrom;
}
