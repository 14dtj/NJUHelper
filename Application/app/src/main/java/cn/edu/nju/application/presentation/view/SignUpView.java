package cn.edu.nju.application.presentation.view;

import cn.edu.nju.application.presentation.model.User;

/**
 * Created by phoebegl on 2016/10/7.
 */

public interface SignUpView {

    void showErrorMessage();

    void toMainActivity(User user);

}
