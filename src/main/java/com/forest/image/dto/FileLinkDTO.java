package com.forest.image.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 文件地址链接
 *
 * @author Forest
 * @date 2020年04月05日 13:44
 */
@Data
@ApiModel("FileLinkDTO")
public class FileLinkDTO {
    /**
     * Markdown格式
     */
    @ApiModelProperty("Markdown格式")
    private String markdown;

    /**
     * HTML格式
     */
    @ApiModelProperty("HTML格式")
    private String html;

    /**
     * URL格式
     */
    @ApiModelProperty("URL格式")
    private String url;
}
