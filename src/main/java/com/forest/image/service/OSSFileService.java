package com.forest.image.service;

import com.forest.image.base.ResultData;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

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
     * @param file,requestIp
     * @return
     * @author Forest
     * @date 2020/3/21 4:51 上午
     */
    ResultData upload(MultipartFile file, String requestIp);

    /**
     * 删除文件
     *
     * @param map
     * @return
     * @author Forest
     * @date 2020/4/4 6:39 下午
     */
    ResultData delete(Map map);

    ResultData query();
}
