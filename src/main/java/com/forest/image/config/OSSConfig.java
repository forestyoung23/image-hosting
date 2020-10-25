package com.forest.image.config;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.forest.image.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * OSS服务配置
 *
 * @author Forest
 * @date 2020年04月02日 15:57
 */
@Configuration
@EnableConfigurationProperties(OSSProperties.class)
public class OSSConfig implements WebMvcConfigurer {

    @Autowired
    private OSSProperties properties;

    /**
     * 创建OSSClient
     *
     * @param
     * @return
     * @author Forest
     * @date 2020/5/17 4:41 上午
     */
    @Bean
    public OSSClient ossClient() {
        return (OSSClient) new OSSClientBuilder().build(properties.getEndpoint(), properties.getAccessKeyId(), properties.getAccessKeySecret());
    }

    /**
     *
     *
     * @param
     * @return
     * @author Forest
     * @date 2020/5/17 4:41 上午
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor()).excludePathPatterns("/user/login");
    }
}
