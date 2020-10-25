package com.forest.image.exception.advice;

import cn.hutool.core.thread.ThreadUtil;
import com.forest.image.base.ResultData;
import com.forest.image.exception.ImageHostingException;
import com.forest.image.util.MailUtils;
import com.forest.image.util.ResultDataUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理
 *
 * @author dongyang
 * @date 2020年07月10日 13:43
 */
@Slf4j
@AllArgsConstructor
@RestControllerAdvice
public class ControllerAdvice {
    private MailUtils mailUtils;

    @ExceptionHandler(Exception.class)
    public ResultData handleException(Exception e) {
        log.error("exception", e);
        if (e instanceof ImageHostingException) {
            return ResultDataUtils.getErrorResult((ImageHostingException) e);
        }
        // 异步发送邮件
        ThreadUtil.execute(() -> {
            mailUtils.sendMail();
        });
        return ResultDataUtils.getErrorResult("500", "系统异常");
    }
}
