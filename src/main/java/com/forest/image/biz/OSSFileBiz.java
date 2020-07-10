package com.forest.image.biz;

import java.util.List;

import com.forest.image.dto.FileLinkDTO;
import com.forest.image.dto.OriginalFileDTO;
import com.forest.image.model.CommonFileModel;

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
    FileLinkDTO upload(OriginalFileDTO file) throws Exception;

    /**
     * 删除文件
     *
     * @param fileIds
     * @return
     * @author Forest
     * @date 2020/4/4 6:44 下午
     */
    void delete(List<String> fileIds);

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
