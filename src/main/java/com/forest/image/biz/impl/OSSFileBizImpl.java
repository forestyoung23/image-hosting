package com.forest.image.biz.impl;

import com.aliyun.oss.OSSClient;
import com.forest.image.biz.OSSFileBiz;
import com.forest.image.dto.OriginalFileDTO;
import com.forest.image.mapper.CommonFileMapper;
import com.forest.image.model.CommonFileModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.UUID;

/**
 * @author Forest
 * @date 2020年04月02日 16:31
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class OSSFileBizImpl implements OSSFileBiz {

    @Autowired
    private CommonFileMapper mapper;

    @Autowired
    private OSSClient ossClient;

    @Value("${oss.bucket_name}")
    private String bucketName;

    @Value("${oss.domain_name}")
    private String ossDomainName;

    /**
     * 文件上传
     *
     * @param file
     * @return
     * @author Forest
     * @date 2020/4/2 4:42 下午
     */
    @Override
    public void upload(OriginalFileDTO file) throws Exception {
        // 1.使用UUID生成唯一文件名，便于查询使用
        StringBuilder sb = new StringBuilder();
        String fileId = sb.append(UUID.randomUUID().toString().replaceAll("-", "")).append(getFileExtension(file.getFileName())).toString();
        // 2.上传文件到OSS
        upload2OSS(file.getFileBytes(), fileId);
        // 3.获取文件对应数据库实体
        CommonFileModel fileModel = convertCommonFileModel(file, fileId);
        // 4.保存文件信息到数据库
        save2DB(fileModel);
    }

    private void save2DB(CommonFileModel fileModel) {
        mapper.insert(fileModel);
    }

    /**
     * 转换为数据库实体
     *
     * @param file
     * @return
     * @author Forest
     * @date 2020/4/3 11:03 上午
     */
    private CommonFileModel convertCommonFileModel(OriginalFileDTO file, String fileId) {
        CommonFileModel model = new CommonFileModel();
        model.setFileId(fileId);
        model.setFileName(file.getFileName());
        model.setFileType(file.getFileType());
        model.setFileUrl(ossDomainName + fileId);
        model.setCreateTime(new Date());
        return model;
    }

    /**
     * 获取文件扩展名
     *
     * @param fileName
     * @return
     * @author Forest
     * @date 2020/4/2 5:01 下午
     */
    private String getFileExtension(String fileName) {
        return fileName.substring(fileName.indexOf("."));

    }

    /**
     * 上传文件到OSS
     *
     * @param fileBytes,fileId
     * @return
     * @author Forest
     * @date 2020/4/2 4:45 下午
     */
    private void upload2OSS(byte[] fileBytes, String fileId) {
        ossClient.putObject(bucketName, fileId, new ByteArrayInputStream(fileBytes));
    }
}
