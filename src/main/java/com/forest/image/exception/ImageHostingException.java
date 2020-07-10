package com.forest.image.exception;

import lombok.Data;

/**
 * 公共异常类
 *
 * @author dongyang
 * @date 2020年07月10日 11:42
 */
@Data
public class ImageHostingException extends RuntimeException {

    /**
     * 异常信息
     */
    private String message;

    /**
     * 异常编码
     */
    private String code;

    public ImageHostingException() {
        super();
    }

    public ImageHostingException(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public ImageHostingException(String code, String message, Throwable throwable) {
        super(throwable);
        this.code = code;
        this.message = message;
    }
}
