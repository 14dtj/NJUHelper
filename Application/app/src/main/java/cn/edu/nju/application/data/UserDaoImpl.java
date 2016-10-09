package cn.edu.nju.application.data;

import java.io.IOException;
import java.util.List;

import cn.edu.nju.application.data.response.InsertResponse;
import cn.edu.nju.application.data.retrofit.RetrofitServiceFactory;
import cn.edu.nju.application.data.retrofit.RetrofitUserInterface;
import cn.edu.nju.application.presentation.model.Post;
import cn.edu.nju.application.presentation.model.User;
import cn.edu.nju.application.presentation.model.UserCollect;
import cn.edu.nju.application.presentation.model.UserFollower;
import cn.edu.nju.application.presentation.model.UserStar;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by tjDu on 2016/9/23.
 */
public class UserDaoImpl implements IUserDao {
    private RetrofitUserInterface service;

    public UserDaoImpl() {
        service = RetrofitServiceFactory.getUserService();
    }

    @Override
    public int signUp(User user) {
        Call<InsertResponse> value = service.register(user);
        int result = 0;
        try {
            Response<InsertResponse> response = value.execute();
            result = response.body().isSuccess();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public User showUserInfo(String username, String password) {
        Call<User> value = service.authenticate(username, password);
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
        Call<InsertResponse> value = service.updateUser(user);
        int result = 0;
        try {
            Response<InsertResponse> response = value.execute();
            result = response.body().isSuccess();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<UserFollower> showFollowers(String username) {
        Call<List<UserFollower>> value = service.getFollowers(username);
        List<UserFollower> result = null;
        try {
            Response<List<UserFollower>> response = value.execute();
            result = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int showstars(String username) {
        Call<InsertResponse> call = service.getStars(username);
        int count = 0;
        try {
            count = call.execute().body().isSuccess();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<UserCollect> showCollections(String username) {
        Call<List<UserCollect>> value = service.getCollections(username);
        List<UserCollect> result = null;
        try {
            Response<List<UserCollect>> response = value.execute();
            result = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Post> showPosts(String username) {
        Call<List<Post>> value = service.getPosts(username);
        List<Post> result = null;
        try {
            Response<List<Post>> response = value.execute();
            result = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
