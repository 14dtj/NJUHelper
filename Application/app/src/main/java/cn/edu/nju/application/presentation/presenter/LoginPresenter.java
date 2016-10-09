package cn.edu.nju.application.presentation.presenter;

/**
 * Created by phoebegl on 2016/10/9.
 */

public interface LoginPresenter {

    void login(String username,String password);

    void onDestroy();
}
