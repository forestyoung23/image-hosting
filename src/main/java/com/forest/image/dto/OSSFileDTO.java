package com.forest.image.dto;

import com.google.common.hash.BloomFilter;
import lombok.Data;

/**
 * OSS文件实体
 *
 * @author Forest
 * @date 2020年04月02日 16:45
 */
@Data
public class OSSFileDTO {
    /**
     * 文件id
     */
    private String fileId;

    /**
     * 文件字节数组
     */
    private byte[] fileBytes;

    public static void main(String[] args) {
        BloomFilter
    }
}
