package com.forest.image.util;

import com.forest.image.base.ResultData;
import lombok.Data;

/**
 * 通用返回实体工具类
 *
 * @author Forest
 * @date 2020年04月28日 14:21
 */
@Data
public class ResultDataUtils {
    private ResultDataUtils() {}

    public static ResultData getSuccessResult() {
        return new ResultData(true);
    }

    public static ResultData getSuccessResult(Object data) {
        return new ResultData(true, null, null, data);
    }

    public static ResultData getErrorResult() {
        return new ResultData(false);
    }

    public static ResultData getErrorResult(String errorCode, String errorMsg) {
        return new ResultData(false, errorCode, errorMsg);
    }
}
