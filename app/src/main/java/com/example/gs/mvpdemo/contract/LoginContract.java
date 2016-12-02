package com.example.gs.mvpdemo.contract;

/**
 * Created by GaoSheng on 2016/11/26.
 * 18:28
 *
 * @VERSION V1.4
 * com.example.gs.mvpdemo.contract
 * 契约类,定义登录用到的一些接口方法
 */

public class LoginContract {

    public interface LoginView {
        String getUserName();

        String getPwd();

        void loginSuccess(String str);

        void loginFail(String failMsg);
    }


    public interface LoginPresenter {
        void login(String name, String pwd);
    }
}
