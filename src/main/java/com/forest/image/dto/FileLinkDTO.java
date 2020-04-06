package com.forest.image.dto;

import lombok.Data;

/**
 * 文件地址链接
 *
 * @author Forest
 * @date 2020年04月05日 13:44
 */
@Data
public class FileLinkDTO {
    /**
     * Markdown格式
     */
    private String markdown;

    /**
     * HTML格式
     */
    private String html;

    /**
     * URL格式
     */
    private String url;
}
