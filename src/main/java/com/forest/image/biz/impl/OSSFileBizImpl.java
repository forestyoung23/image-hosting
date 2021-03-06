package com.forest.image.biz.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.forest.image.biz.OSSFileBiz;
import com.forest.image.dto.FileLinkDTO;
import com.forest.image.dto.OriginalFileDTO;
import com.forest.image.mapper.CommonFileMapper;
import com.forest.image.model.CommonFileModel;
import com.forest.image.util.FileLinkUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * OSS文件处理BizImpl
 *
 * @author Forest
 * @date 2020年04月02日 16:31
 */
@Slf4j
@Component
@Transactional(rollbackFor = Exception.class)
public class OSSFileBizImpl implements OSSFileBiz {

    @Autowired
    private CommonFileMapper mapper;

    /*@Autowired
    private OSSClient ossClient;*/

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
    public FileLinkDTO upload(OriginalFileDTO file) throws Exception {
        // 1.使用UUID生成唯一文件名，便于查询使用
        StringBuilder sb = new StringBuilder();
        String fileId = sb.append(UUID.randomUUID().toString().replaceAll("-", "")).append(getFileExtension(file.getFileName())).toString();
        // 2.上传文件到OSS
        upload2OSS(file.getFileBytes(), fileId);
        // 3.获取文件对应数据库实体
        CommonFileModel fileModel = convertCommonFileModel(file, fileId);
        // 4.保存文件信息到数据库
        save2DB(fileModel);
        // 5.返回文件地址链接
        return FileLinkUtils.getFileLink(fileModel.getFileUrl());
    }


    /**
     * 删除文件
     *
     * @param fileIds
     * @return
     * @author Forest
     * @date 2020/4/4 6:44 下午
     */
    @Override
    public void delete(List<String> fileIds) {
        // 1.删除OSS上的文件
        deleteFromOSS(fileIds);
        // 2.删除数据库关联记录
        deleteFromDB(fileIds);
    }

    /**
     * 文件查询
     *
     * @param
     * @return
     * @author Forest
     * @date 2020/7/10 11:39
     */
    @Override
    public List<CommonFileModel> query() {
        return mapper.selectList(new QueryWrapper<>());
    }

    /**
     * 删除OSS文件
     *
     * @param fileIds
     * @return
     * @author Forest
     * @date 2020/4/4 6:47 下午
     */
    private void deleteFromOSS(List<String> fileIds) {
//        DeleteObjectsResult result = ossClient.deleteObjects(new DeleteObjectsRequest(bucketName).withKeys(fileIds).withQuiet(true));
//        if (ObjectUtil.isNotEmpty(result.getDeletedObjects())) {
//            for (String fileName : result.getDeletedObjects()) {
//                log.warn("文件{}删除失败", fileName);
//            }
//        }
    }

    /**
     * 删除数据库文件
     *
     * @param fileIds
     * @return
     * @author Forest
     * @date 2020/4/4 6:47 下午
     */
    private void deleteFromDB(List<String> fileIds) {
        QueryWrapper<CommonFileModel> wrapper = new QueryWrapper<>();
        wrapper.in("file_id", fileIds);
        mapper.delete(wrapper);
    }

    /**
     * 保存文件信息到数据库
     *
     * @param fileModel
     * @return
     * @author Forest
     * @date 2020/4/18 4:40 下午
     */
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
        CommonFileModel model = BeanUtil.toBean(file, CommonFileModel.class);
        model.setFileId(fileId);
        model.setIp(file.getRequestIp());
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
//        ossClient.putObject(bucketName, fileId, new ByteArrayInputStream(fileBytes));
    }
}
