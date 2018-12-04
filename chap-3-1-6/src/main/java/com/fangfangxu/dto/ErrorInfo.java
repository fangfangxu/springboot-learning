package com.fangfangxu.dto;

import lombok.Data;

/**
 * JSON异常返回对象
 * @param <T>
 */
@Data
public class ErrorInfo<T> {
    public static final Integer OK=0;
    public static final Integer ERROR=100;
    private Integer code;
    private String message;
    private String url;
    private T data;
}
