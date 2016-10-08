package cn.edu.nju.application.presentation.presenter.impl;

import android.os.Handler;

import cn.edu.nju.application.presentation.model.User;
import cn.edu.nju.application.presentation.presenter.SignUpPresenter;
import cn.edu.nju.application.presentation.view.SignUpView;
import cn.edu.nju.application.service.SignUpService;
import cn.edu.nju.application.service.impl.SignUpServiceImpl;

/**
 * Created by phoebegl on 2016/10/7.
 */

public class SignUpPresenterImpl implements SignUpPresenter,SignUpService.OnSignUpFinishedListener{

    private SignUpView view;
    private SignUpService service;
    private Handler handler;

    public SignUpPresenterImpl(SignUpView view) {
        this.view = view;
        this.service = new SignUpServiceImpl();
        this.handler = new Handler();
    }

    @Override
    public void signUp(User user) {
        if(view != null)
            view.showLoading();

        service.signUp(user, this);
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void onFail() {
        if(view != null) {
            view.showErrorMessage();
            view.hideLoading();
        }
    }

    @Override
    public void onSuccess(User user) {
        if(view != null)
            view.toMainActivity(user);
    }
}
