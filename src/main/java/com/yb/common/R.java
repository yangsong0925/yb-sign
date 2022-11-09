package com.yb.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yangsong
 * @version 1.0
 * @date 2022/11/1 11:49
 */
@Data
public class R<T> implements Serializable {

    private boolean success;
    private T data;
    private String message;

    public R(Boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public static <T> R<T> success(T data) {
        return new R(Boolean.TRUE, data);
    }

    public static <T> R<T> error(String message) {
        return new R(Boolean.FALSE, message);
    }

}
