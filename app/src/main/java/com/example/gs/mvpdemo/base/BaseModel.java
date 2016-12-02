package com.example.gs.mvpdemo.base;

import com.example.gs.mvpdemo.http.Http;
import com.example.gs.mvpdemo.http.HttpService;
import com.example.gs.mvpdemo.mvp.IModel;

/**
 * Created by gaosheng on 2016/12/1.
 * 23:13
 * com.example.gs.mvpdemo.base
 */

public class BaseModel implements IModel {
    protected static HttpService httpService;

    //初始化httpService
    static {
        httpService = Http.getHttpService();
    }

}
