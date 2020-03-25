package com.forest.image.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectResult;

import java.io.ByteArrayInputStream;

/**
 * 文件上传工具类
 *
 * @author dongyang
 * @date 2020年03月26日 00:13
 */
public class FileUtils {
    /**
     * 私有构造方法
     */
    private FileUtils(){}

    /**
     * 上传文件
     *
     * @param
     * @return
     * @author dongyang
     * @date 2020/3/26 12:15 上午
     */
    public static void upload() {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "123";
        String accessKeySecret = "123";
        String bucketName = "blog-imag";
        // <yourObjectName>上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        String objectName = "test";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 上传内容到指定的存储空间（bucketName）并保存为指定的文件名称（objectName）。
        String content = "Hello OSS";
        PutObjectResult putObjectResult = ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(content.getBytes()));
        System.err.println(putObjectResult.toString());
        // 关闭OSSClient。
        ossClient.shutdown();
    }

    public static void main(String[] args) {
        upload();
    }
    /**
     * 查询文件
     *
     * @param
     * @return
     * @author dongyang
     * @date 2020/3/26 12:15 上午
     */
    public void query() {

    }

    /**
     * 删除文件
     *
     * @param
     * @return
     * @author dongyang
     * @date 2020/3/26 12:15 上午
     */
    public void remove() {

    }
}
