package com.forest.image.biz;

import com.forest.image.dto.OriginalFileDTO;

/**
 * @author Forest
 * @date 2020年04月02日 16:31
 */
public interface OSSFileBiz {
    /**
     * 文件上传
     *
     * @param file
     * @return
     * @author Forest
     * @date 2020/4/2 4:41 下午
     */
    void upload(OriginalFileDTO file) throws Exception;
}
