package com.example.gs.mvpdemo.activity;

import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.example.gs.mvpdemo.R;
import com.example.gs.mvpdemo.base.BaseActivity;
import com.example.gs.mvpdemo.contract.LoginContract;
import com.example.gs.mvpdemo.presenter.LoginPresenter;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.LoginView {

    @InjectView(R.id.input_email)   //账号
            EditText inputEmail;
    @InjectView(R.id.input_password) //密码
            EditText inputPassword;
    @InjectView(R.id.btn_login)
    AppCompatButton btnLogin;

    @Override
    protected LoginPresenter loadPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        btnLogin.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        ButterKnife.inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void otherViewClick(View view) {
        mPresenter.login(getUserName(), getPwd());
    }

    @Override
    public String getUserName() {
        return inputEmail.getText().toString().trim();
    }

    @Override
    public String getPwd() {
        return inputPassword.getText().toString().trim();
    }

    @Override
    public void loginSuccess(String str) {
        toast(str);
    }

    @Override
    public void loginFail(String failMsg) {
        toast(failMsg);
    }


    public boolean checkNull() {
        boolean isNull = false;
        if (TextUtils.isEmpty(getUserName())) {
            inputEmail.setError("账号不能为空");
            isNull = true;
        } else if (TextUtils.isEmpty(getPwd())) {
            inputPassword.setError("密码不能为空");
            isNull = true;
        }
        return isNull;
    }

}
