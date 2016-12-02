package com.example.gs.mvpdemo.http;


import com.example.gs.mvpdemo.base.BaseHttpResult;
import com.example.gs.mvpdemo.bean.LoginBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by GaoSheng on 2016/9/13.
 * 网络请求的接口都在这里
 */

public interface HttpService {
    //登录接口
    @FormUrlEncoded
    @POST("demo/login")
    Observable<BaseHttpResult<LoginBean>> login(@Field("userName") String username, @Field
            ("passWord") String pwd);
}
