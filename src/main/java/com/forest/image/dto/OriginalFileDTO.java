package com.forest.image.dto;

import lombok.Data;

/**
 * @author Forest
 * @date 2020年04月03日 11:17
 */
@Data
public class OriginalFileDTO {

    /**
     * 请求IP
     */
    private String requestIp;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 文件字节流
     */
    private byte[] fileBytes;
}
