package com.forest.image.dto;

import lombok.Data;

/**
 * 数据库文件实体
 *
 * @author Forest
 * @date 2020年03月21日 04:48
 */
@Data
public class FileDTO {

    /**
     * 上传主机ip
     */
    private String ip;

    /**
     * 文件id
     */
    private String fileId;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 文件url
     */
    private String fileUrl;
}
