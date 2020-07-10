package com.forest.image.util;

import com.forest.image.dto.FileLinkDTO;

/**
 * 文件链接工具类
 *
 * @author Forest
 * @date 2020年04月18日 16:03
 */
public class FileLinkUtils {

    private FileLinkUtils(){}

    /**
     * Markdown格式
     */
    private static final String MARKDOWN = "![](%s)";

    /**
     * HTML格式
     */
    private static final String HTML = "<img src='%s'/>";

    public static FileLinkDTO getFileLink(String fileUrl) {
        FileLinkDTO dto = new FileLinkDTO();
        dto.setMarkdown(String.format(MARKDOWN, fileUrl));
        dto.setHtml(String.format(HTML, fileUrl));
        dto.setUrl(fileUrl);
        return dto;
    }

}
