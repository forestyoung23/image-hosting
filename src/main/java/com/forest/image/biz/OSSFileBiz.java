package com.forest.image.biz;

import com.forest.image.dto.OriginalFileDTO;

import java.util.List;

/**
 * OSS文件处理Biz
 *
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

    /**
     * 删除文件
     *
     * @param fileIds
     * @return
     * @author Forest
     * @date 2020/4/4 6:44 下午
     */
    void delete(List<String> fileIds);
}
