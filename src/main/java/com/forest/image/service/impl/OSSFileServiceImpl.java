package com.forest.image.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.forest.image.base.ResultData;
import com.forest.image.biz.OSSFileBiz;
import com.forest.image.service.OSSFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件服务实现
 *
 * @author Forest
 * @date 2020年03月21日 04:39
 */
@Slf4j
@Service
public class OSSFileServiceImpl implements OSSFileService {
    @Autowired
    private OSSFileBiz ossFileBiz;

    /**
     * 文件上传
     *
     * @param file
     * @return
     * @author Forest
     * @date 2020/3/21 4:52 上午
     */
    @Override
    public ResultData upload(MultipartFile file) {
        if (ObjectUtil.isEmpty(file)) {
            log.warn("上传失败，文件为空！");
            return new ResultData(false, "1001", "请选择需要上传的文件");
        }
        try {
            ossFileBiz.upload(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultData(true);
    }
}
