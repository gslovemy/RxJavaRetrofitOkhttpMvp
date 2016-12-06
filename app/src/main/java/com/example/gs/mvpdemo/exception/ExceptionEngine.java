package com.example.gs.mvpdemo.exception;

import android.net.ParseException;

import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import retrofit2.adapter.rxjava.HttpException;

/**
 * Created by gaosheng on 2016/11/6.
 * 22:15
 * com.example.gaosheng.myapplication.exception
 */

public class ExceptionEngine {
    //对应HTTP的状态码
    private static final int FAIL = 0;
    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int BAD_GATEWAY = 502;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int GATEWAY_TIMEOUT = 504;

    public static ApiException handleException(Throwable e) {
        ApiException ex;
        if (e instanceof ServerException) {             //HTTP错误
            ServerException httpException = (ServerException) e;
            ex = new ApiException(e, ErrorType.HTTP_ERROR);
            switch (httpException.code) {
                case FAIL:
                    ex.message = "userName or passWord is error!";
                    break;
                case UNAUTHORIZED:
                    ex.message = "当前请求需要用户验证";
                    break;
                case FORBIDDEN:
                    ex.message = "服务器已经理解请求，但是拒绝执行它";
                    break;
                case NOT_FOUND:
                    ex.message = "服务器异常，请稍后再试";
                    break;
                case REQUEST_TIMEOUT:
                    ex.message = "请求超时";
                    break;
                case GATEWAY_TIMEOUT:
                    ex.message = "作为网关或者代理工作的服务器尝试执行请求时，未能及时从上游服务器（URI标识出的服务器，例如HTTP、FTP、LDAP" +
                            "）或者辅助服务器（例如DNS）收到响应";
                    break;
                case INTERNAL_SERVER_ERROR:
                    ex.message = "服务器遇到了一个未曾预料的状况，导致了它无法完成对请求的处理";
                    break;
                case BAD_GATEWAY:
                    ex.message = "作为网关或者代理工作的服务器尝试执行请求时，从上游服务器接收到无效的响应";
                    break;
                case SERVICE_UNAVAILABLE:
                    ex.message = "由于临时的服务器维护或者过载，服务器当前无法处理请求";
                    break;
                default:
                    ex.message = "网络错误";  //其它均视为网络错误
                    break;
            }
            return ex;
        } else if (e instanceof ServerException) {    //服务器返回的错误
            ServerException resultException = (ServerException) e;
            ex = new ApiException(resultException, resultException.code);
            ex.message = resultException.message;
            return ex;
        } else if (e instanceof JSONException
                || e instanceof ParseException) {
            ex = new ApiException(e, ErrorType.PARSE_ERROR);
            ex.message = "解析错误";            //均视为解析错误
            return ex;
        } else if (e instanceof ConnectException || e instanceof SocketTimeoutException || e
                instanceof ConnectTimeoutException) {
            ex = new ApiException(e, ErrorType.NETWORK_ERROR);
            ex.message = "连接失败";  //均视为网络错误
            return ex;
        } else if (e instanceof HttpException) {
            if ("HTTP 404 Not Found".equals(e.getMessage())) {
                ex = new ApiException(e, ErrorType.NETWORK_ERROR);
                ex.message = "没有连接服务器";
            } else {
                ex = new ApiException(e, ErrorType.NETWORK_ERROR);
                ex.message = "其他连接服务器错误";
            }
            return ex;

        } else {
            ex = new ApiException(e, ErrorType.UNKONW);
            ex.message = "未知错误";          //未知错误
            return ex;
        }
    }

}

