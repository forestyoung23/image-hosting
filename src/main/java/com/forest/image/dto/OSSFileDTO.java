package com.forest.image.dto;

import lombok.Data;

/**
 * OSS文件实体
 *
 * @author dongyang
 * @date 2020年04月02日 16:45
 */
@Data
public class OSSFileDTO {
    /**
     * 文件Name
     */
    private String fileName;

    /**
     * 文件字节数组
     */
    private byte[] fileBytes;
}
