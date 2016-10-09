package cn.edu.nju.application.service;

import cn.edu.nju.application.presentation.model.User;

/**
 * Created by phoebegl on 2016/10/7.
 */

public interface LoginService {

    interface OnLoginListener{
        void onError();

        void onSucess(User user);
    }

    void login(String username,String password,OnLoginListener listener);
}
