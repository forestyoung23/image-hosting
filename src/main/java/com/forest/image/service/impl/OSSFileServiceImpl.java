package com.forest.image.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.forest.image.base.ResultData;
import com.forest.image.biz.OSSFileBiz;
import com.forest.image.dto.OriginalFileDTO;
import com.forest.image.service.OSSFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
            ossFileBiz.upload(convertOriginalFileDTO(file));
        } catch (Exception e) {
            log.error("上传文件失败，错误信息：{}", e.getMessage());
            return new ResultData(false, "1001", "系统内部发生错误");
        }
        return new ResultData(true);
    }

    /**
     * 转换文件实体
     *
     * @param file
     * @return
     * @author Forest
     * @date 2020/4/4 6:10 下午
     */
    private OriginalFileDTO convertOriginalFileDTO(MultipartFile file) throws IOException {
        OriginalFileDTO dto = new OriginalFileDTO();
        dto.setFileName(file.getOriginalFilename());
        dto.setFileType(file.getContentType());
        dto.setFileBytes(file.getBytes());
        return dto;
    }


}
