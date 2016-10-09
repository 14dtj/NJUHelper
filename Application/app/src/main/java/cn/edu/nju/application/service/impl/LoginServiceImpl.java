package cn.edu.nju.application.service.impl;

import cn.edu.nju.application.data.IUserDao;
import cn.edu.nju.application.data.UserDaoImpl;
import cn.edu.nju.application.presentation.model.User;
import cn.edu.nju.application.service.LoginService;

/**
 * Created by phoebegl on 2016/10/7.
 */

public class LoginServiceImpl implements LoginService {

    private IUserDao dao;

    public LoginServiceImpl() {
        dao = new UserDaoImpl();
    }

    @Override
    public void login(String username, String password, OnLoginListener listener) {
        User user = dao.showUserInfo(username,password);

        if(user == null) {
            listener.onError();
        } else {
            listener.onSucess(user);
        }

    }
}
