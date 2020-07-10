package com.forest.image.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.forest.image.dto.FileLinkDTO;
import com.forest.image.model.CommonFileModel;

/**
 * 文件服务
 *
 * @author Forest
 * @date 2020年03月21日 04:38
 */
public interface OSSFileService {
    /**
     * 文件上传
     *
     * @param file
     * @param requestIp
     * @return
     * @author Forest
     * @date 2020/3/21 4:51 上午
     */
    FileLinkDTO upload(MultipartFile file, String requestIp);

    /**
     * 删除文件
     *
     * @param map
     * @return
     * @author Forest
     * @date 2020/4/4 6:39 下午
     */
    void delete(Map map);

    /**
     * 文件查询
     *
     * @param
     * @return
     * @author Forest
     * @date 2020/7/10 11:39
     */
    List<CommonFileModel> query();
}
