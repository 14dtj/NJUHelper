package cn.edu.nju.application.presentation.presenter;

import cn.edu.nju.application.presentation.model.User;

/**
 * Created by phoebegl on 2016/10/7.
 */

public interface SignUpPresenter {

    void signUp(User user);

    void onDestroy();
}
