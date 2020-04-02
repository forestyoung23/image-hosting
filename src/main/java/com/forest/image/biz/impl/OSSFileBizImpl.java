package com.forest.image.biz.impl;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.IOUtils;
import com.forest.image.biz.OSSFileBiz;
import com.forest.image.dto.OSSFileDTO;
import com.forest.image.mapper.CommonFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @author dongyang
 * @date 2020年04月02日 16:31
 */
@Component
public class OSSFileBizImpl implements OSSFileBiz {
    @Autowired
    private CommonFileMapper mapper;

    @Autowired
    private OSSClient ossClient;

    @Value("${oss.bucket_name}")
    private String bucketName;

    /**
     * 文件上传
     *
     * @param file
     * @return
     * @author dongyang
     * @date 2020/4/2 4:42 下午
     */
    @Override
    public void upload(MultipartFile file) throws Exception {
        // 转换为OSS文件实体
        OSSFileDTO dto = convertOSSFileDTO(file);
        // 1.上传文件到OSS
        upload2OSS(dto);
        // 2.保存文件信息到数据库
        save2DB();
    }

    /**
     * file转换为OSS文件实体
     *
     * @param file
     * @return
     * @author dongyang
     * @date 2020/4/2 4:48 下午
     */
    private OSSFileDTO convertOSSFileDTO(MultipartFile file) throws IOException {
        OSSFileDTO dto = new OSSFileDTO();
        StringBuilder sb = new StringBuilder();
        // 使用UUID生成唯一的文件名，便于查询使用
        dto.setFileName(sb.append(UUID.randomUUID().toString().replaceAll("-", "")).append(".").append(getFileExtension(file.getOriginalFilename())).toString());
        dto.setFileBytes(file.getBytes());
        return dto;
    }

    /**
     * 获取文件扩展名
     *
     * @param fileName
     * @return
     * @author dongyang
     * @date 2020/4/2 5:01 下午
     */
    private String getFileExtension(String fileName) {
        return fileName.substring(fileName.indexOf(".") + 1);

    }

    /**
     * 上传文件到OSS
     *
     * @param dto
     * @return
     * @author dongyang
     * @date 2020/4/2 4:45 下午
     */
    private void upload2OSS(OSSFileDTO dto) {
        ossClient.putObject(bucketName, dto.getFileName(), new ByteArrayInputStream(dto.getFileBytes()));
        IOUtils.checkFile()
    }
}
