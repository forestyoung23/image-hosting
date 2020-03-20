package com.forest.image.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.forest.image.dto.FileDTO;
import com.forest.image.mapper.CommonFileMapper;
import com.forest.image.model.CommonFileModel;
import com.forest.image.service.CommonFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 文件服务实现
 *
 * @author Forest
 * @date 2020年03月21日 04:39
 */
@Service
public class CommonFileServiceImpl implements CommonFileService {
    @Autowired
    private CommonFileMapper mapper;

    /**
     * 文件上传
     *
     * @param file
     * @return
     * @author Forest
     * @date 2020/3/21 4:52 上午
     */
    @Override
    public Object upload(FileDTO file) {
        CommonFileModel model = BeanUtil.toBean(file, CommonFileModel.class);
        return mapper.insert(model);
    }
}
