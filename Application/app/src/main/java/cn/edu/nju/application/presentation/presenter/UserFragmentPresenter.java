package cn.edu.nju.application.presentation.presenter;

import android.os.AsyncTask;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cn.edu.nju.application.data.IUserDao;
import cn.edu.nju.application.data.UserDaoImpl;
import cn.edu.nju.application.presentation.activity.MainActivity;
import cn.edu.nju.application.presentation.fragment.UserFragment;
import cn.edu.nju.application.presentation.model.User;
import cn.edu.nju.application.presentation.model.UserFollower;

/**
 * Created by phoebegl on 2016/10/9.
 */

public class UserFragmentPresenter{

    private IUserDao dao;
    private UserFragment view;

    public UserFragmentPresenter(UserFragment view) {
        this.dao = new UserDaoImpl();
        this.view = view;
    }

    public void setUserInfo() {

        User temp = MainActivity.getLoginUser();
        int followers = dao.showFollowers(temp.getUsername()).size();
        int stars = dao.showstars(temp.getUsername());

        view.setName(temp.getUsername());
        view.setFollower(String.valueOf(followers));
        view.setStar(String.valueOf(stars));
        view.setCredit(String.valueOf(temp.getCredit()));
    }

}
