package cn.edu.nju.application.presentation.presenter.impl;

import cn.edu.nju.application.presentation.model.User;
import cn.edu.nju.application.presentation.presenter.LoginPresenter;
import cn.edu.nju.application.presentation.view.LoginView;
import cn.edu.nju.application.service.LoginService;
import cn.edu.nju.application.service.impl.LoginServiceImpl;

/**
 * Created by phoebegl on 2016/10/9.
 */

public class LoginPresenterImpl implements LoginPresenter,LoginService.OnLoginListener{

    private LoginService service;
    private LoginView view;

    public LoginPresenterImpl(LoginView view) {
        this.service = new LoginServiceImpl();
        this.view = view;
    }

    @Override
    public void login(String username, String password) {
        service.login(username,password,this);
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void onError() {
        if(view != null) {
            view.showErrorMessage();
        }
    }

    @Override
    public void onSucess(User user) {
        if(view != null) {
            view.toMainActivity(user);
        }
    }
}
