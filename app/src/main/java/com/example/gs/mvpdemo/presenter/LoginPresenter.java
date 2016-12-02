package com.example.gs.mvpdemo.presenter;

import com.example.gs.mvpdemo.activity.LoginActivity;
import com.example.gs.mvpdemo.base.BasePresenter;
import com.example.gs.mvpdemo.contract.LoginContract;
import com.example.gs.mvpdemo.model.LoginModel;
import com.example.gs.mvpdemo.utils.LogUtils;

/**
 * Created by GaoSheng on 2016/11/26.
 * 20:51
 *
 * @VERSION V1.4
 * com.example.gs.mvpdemo.presenter
 */

public class LoginPresenter extends BasePresenter<LoginModel, LoginActivity> implements
        LoginContract.LoginPresenter {

    @Override
    public void login(String name, String pwd) {
        if (!getIView().checkNull()) {
            getiModel().login(name, pwd, new LoginModel.InfoHint() {
                @Override
                public void successInfo(String str) {
                    getIView().loginSuccess(str);  //成功
                }

                @Override
                public void failInfo(String str) {
                    LogUtils.e("LoginPresenter.failInfo",str);

                    getIView().loginFail(str);  //失败
                }
            });
        }
    }

    @Override
    public LoginModel loadModel() {
        return new LoginModel();
    }
}
