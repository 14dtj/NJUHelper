package cn.edu.nju.application.presentation.view;

import cn.edu.nju.application.presentation.model.User;

/**
 * Created by phoebegl on 2016/10/9.
 */

public interface LoginView {

    void showLoading();

    void hideLoading();

    void showErrorMessage();

    void toMainActivity(User user);
}
