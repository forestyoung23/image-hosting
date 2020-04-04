package com.forest.image.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * oss配置信息
 *
 * @author Forest
 * @date 2020年04月02日 16:00
 */
@Data
@ConfigurationProperties(prefix = "oss")
public class OSSProperties {
    /**
     * endpoint
     */
    private String endpoint;

    /**
     * accessKeyId
     */
    private String accessKeyId;

    /**
     * accessKeySecret
     */
    private String accessKeySecret;

    /**
     * bucketName
     */
    private String bucketName;
}
