package com.yujia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseInfo<T> implements Serializable {

    public interface StatusCode {
        /**
         * 请求成功
         */
        String SUCCESS = "0";
        /**
         * 请求失败
         */
        String FAILURE = "1";
        /**
         * 会话关闭
         */
        String CLOSED = "2";

        /**
         * 请求格式错误/非法参数
         */
        String PARAM_ERROR = "-1";
        /**
         * 非法token
         */
        String INVALID_TOKEN = "-2";
        /**
         * 调用业务,有异常抛出
         */
        String EXCEPTION = "-3";
    }

    private String code;

    private String msg;

    private T data;

    public boolean isSuccess() {
        return StatusCode.SUCCESS.equals(code);
    }

    public static <T> ResponseInfo<T> success(T data) {
        return new ResponseInfo<>(StatusCode.SUCCESS,"success",data);
    }

    public static <T> ResponseInfo<T> success() {
        return new ResponseInfo<>(StatusCode.SUCCESS,"success",null);
    }

    public static <T> ResponseInfo<T> paramError(String msg) {
        return new ResponseInfo<>(StatusCode.PARAM_ERROR,msg,null);
    }

    public static <T> ResponseInfo<T> paramError() {
        return new ResponseInfo<>(StatusCode.PARAM_ERROR,"参数错误",null);
    }

    public static <T> ResponseInfo<T> systemError(String msg) {
        return new ResponseInfo<>(StatusCode.EXCEPTION,msg,null);
    }

    public static <T> ResponseInfo<T> systemError() {
        return new ResponseInfo<>(StatusCode.EXCEPTION,"系统错误",null);
    }

    public static <T> ResponseInfo<T> build(String code, String msg, T data) {
        return new ResponseInfo<>(code,msg,data);
    }
}
