package com.forest.image.config;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OSS服务配置
 *
 * @author Forest
 * @date 2020年04月02日 15:57
 */
@Configuration
@EnableConfigurationProperties(OSSProperties.class)
public class OSSConfig {

    @Autowired
    private OSSProperties properties;

    @Bean
    public OSSClient ossClient() {
        return (OSSClient) new OSSClientBuilder().build(properties.getEndpoint(), properties.getAccessKeyId(), properties.getAccessKeySecret());
    }
}
