package cn.edu.nju.application.data.retrofit;

import java.util.List;

import cn.edu.nju.application.data.response.InsertResponse;
import cn.edu.nju.application.presentation.model.Post;
import cn.edu.nju.application.presentation.model.User;
import cn.edu.nju.application.presentation.model.UserCollect;
import cn.edu.nju.application.presentation.model.UserFollower;
import cn.edu.nju.application.presentation.model.UserStar;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by tjDu on 2016/9/23.
 */
public interface RetrofitUserInterface {
    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    @GET("login/{username}/{pwd}")
    Call<User> authenticate(@Path("username") String username, @Path("pwd") String password);

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @POST("register")
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    Call<InsertResponse> register(@Body User user);

    /**
     * 更新
     *
     * @param user
     * @return
     */
    @POST("update")
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    Call<InsertResponse> updateUser(@Body User user);

    /**
     * 展示粉丝
     *
     * @param username
     * @return
     */
    @GET("follower/{username}")
    Call<List<UserFollower>> getFollowers(@Path("username") String username);

    /**
     * 展示收藏
     */
    @GET("collection/{username}")
    Call<List<UserCollect>> getCollections(@Path("username") String username);

    /**
     * 展示用户发表过的帖子
     */
    @GET("history/{username}")
    Call<List<Post>> getPosts(@Path("username") String username);

    /**
     * 得到用户收获的赞数
     * @param username
     * @return
     */
    @GET("stars/{username}")
    Call<InsertResponse> getStars(@Path("username") String username);
}
