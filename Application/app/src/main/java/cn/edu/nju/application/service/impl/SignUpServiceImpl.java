package cn.edu.nju.application.service.impl;

import cn.edu.nju.application.data.IUserDao;
import cn.edu.nju.application.data.UserDaoImpl;
import cn.edu.nju.application.presentation.model.User;
import cn.edu.nju.application.presentation.presenter.SignUpPresenter;
import cn.edu.nju.application.service.SignUpService;

/**
 * Created by phoebegl on 2016/10/7.
 */

public class SignUpServiceImpl implements SignUpService {

    private IUserDao userDao;

    public SignUpServiceImpl() {
        userDao = new UserDaoImpl();
    }

    @Override
    public void signUp(User user, OnSignUpFinishedListener listener) {
        int result = userDao.signUp(user);
        if(result > 0) {
            listener.onSuccess(user);
        } else {
            listener.onFail();
        }
    }
}
