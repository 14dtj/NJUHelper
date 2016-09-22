package cn.edu.nju.application.data.impl;

import java.util.List;

import cn.edu.nju.application.data.IUserDao;
import cn.edu.nju.application.data.retrofit.RetrofitInterface;
import cn.edu.nju.application.data.retrofit.RetrofitService;
import cn.edu.nju.application.presentation.model.Post;
import cn.edu.nju.application.presentation.model.User;
import cn.edu.nju.application.presentation.model.UserCollect;
import cn.edu.nju.application.presentation.model.UserFollower;

/**
 * Created by tjDu on 2016/9/22.
 */
public class UserDaoImpl implements IUserDao {
    private RetrofitInterface service;
    public UserDaoImpl(){
        RetrofitService helper = new RetrofitService();
        service = helper.getService();
    }
    @Override
    public int signUp(User user) {
        return 0;
    }

    @Override
    public User showUserInfo(String username, String password) {
       service.login();
        return null;
    }

    @Override
    public int updateUserInfo(User user) {
        return 0;
    }

    @Override
    public List<UserFollower> showFollowers(String username) {
        return null;
    }

    @Override
    public List<UserCollect> showCollections(String username) {
        return null;
    }

    @Override
    public List<Post> showPosts(String username) {
        return null;
    }
}
