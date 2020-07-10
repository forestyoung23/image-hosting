package com.forest.image.exception.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.forest.image.base.ResultData;
import com.forest.image.exception.ImageHostingException;
import com.forest.image.util.ResultDataUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 统一异常处理
 *
 * @author dongyang
 * @date 2020年07月10日 13:43
 */
@Slf4j
@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResultData handleException(Exception e) {
        log.error("exception", e);
        if (e instanceof ImageHostingException) {
            return ResultDataUtils.getErrorResult((ImageHostingException) e);
        }
        return ResultDataUtils.getErrorResult("500", "系统异常");
    }
}
