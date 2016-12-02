package com.example.gs.mvpdemo.exception;

/**
 * Created by gaosheng on 2016/11/6.
 * 21:50
 * com.example.gaosheng.myapplication.exception
 */

public interface ErrorType {

    /**
     * 请求成功
     */
    int SUCCESS = 1;
    /**
     * 未知错误
     */
    int UNKONW = 1000;

    /**
     * 解析错误
     */
    int PARSE_ERROR = 1001;
    /**
     * 网络错误
     */
    int NETWORK_ERROR = 1002;

    /**
     * 解析对象为空
     */
    int EMPTY_BEAN = 1004;


    /**
     *
     */
    int HTTP_ERROR = 1003;
}
