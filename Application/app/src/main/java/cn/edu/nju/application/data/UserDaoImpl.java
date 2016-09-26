package cn.edu.nju.application.data;

import android.util.Log;

import java.io.IOException;
import java.util.List;

import cn.edu.nju.application.data.retrofit.RetrofitServiceFactory;
import cn.edu.nju.application.data.retrofit.RetrofitUserInterface;
import cn.edu.nju.application.presentation.model.Post;
import cn.edu.nju.application.presentation.model.User;
import cn.edu.nju.application.presentation.model.UserCollect;
import cn.edu.nju.application.presentation.model.UserFollower;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tjDu on 2016/9/23.
 */
public class UserDaoImpl implements IUserDao {
    private RetrofitUserInterface service;
    public UserDaoImpl(){ service = RetrofitServiceFactory.getService();}

    @Override
    public int signUp(User user) {
        return 0;
    }

    @Override
    public User showUserInfo(String username, String password) {
        Call<User> value = service.authenticate(username,password);
        User result = null;
        try {
            Response<User> test = value.execute();
            result = test.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
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
