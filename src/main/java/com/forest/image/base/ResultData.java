package com.forest.image.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 通用返回实体
 *
 * @author Forest
 * @date 2020年04月02日 10:45
 */
@ApiModel("ResultData")
@Data
public class ResultData<T> implements Serializable {
    private static final long serialVersionUID = -2575778567893676532L;

    public ResultData(Boolean succeed) {
        this.succeed = succeed;
    }

    public ResultData(Boolean succeed, String errorCode, String errorMsg) {
        this.succeed = succeed;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public ResultData(Boolean succeed, String errorCode, String errorMsg, T data) {
        this.succeed = succeed;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.data = data;
    }

    /**
     * 请求结果：成功/失败
     */
    @ApiModelProperty("请求结果：成功/失败")
    private boolean succeed;

    /**
     * 错误码
     */
    @ApiModelProperty("错误码")
    private String errorCode;

    /**
     * 错误信息
     */
    @ApiModelProperty("错误信息")
    private String errorMsg;

    /**
     * 返回数据
     */
    @ApiModelProperty("返回数据")
    private T data;
}
