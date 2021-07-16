package com.forest.image.exception;

import lombok.Data;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<String> list = new ArrayList<>(Arrays.asList("1", "2", "3"));
        for (String o : list) {
            if ("2" == o) {
                list.remove(o);
            }
        }
        System.out.println(list);
    }
}
