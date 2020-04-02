package com.forest.image.biz;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author dongyang
 * @date 2020年04月02日 16:31
 */
public interface OSSFileBiz {
    /**
     * 文件上传
     *
     * @param file
     * @return
     * @author dongyang
     * @date 2020/4/2 4:41 下午
     */
    void upload(MultipartFile file) throws Exception;
}
