package com.example.gs.mvpdemo.exception;

/**
 * Created by gaosheng on 2016/11/6.
 * 21:58
 * com.example.gaosheng.myapplication.exception
 * 自定义的异常,处理解析网络时的错误
 */

public class ApiException extends RuntimeException {

    public int code;
    public String message;

    public ApiException(Throwable throwable, int code) {
        super(throwable);
        this.code = code;
    }
}
