package cn.edu.nju.application.service;

import cn.edu.nju.application.presentation.model.User;
import cn.edu.nju.application.presentation.presenter.SignUpPresenter;

/**
 * Created by phoebegl on 2016/10/7.
 */

public interface SignUpService {

    interface OnSignUpFinishedListener {
//        void OnUsernameError();
//
//        void OnEmailError();

        void onFail();

        void onSuccess(User user);
    }

    void signUp(User user, OnSignUpFinishedListener listener);
}
