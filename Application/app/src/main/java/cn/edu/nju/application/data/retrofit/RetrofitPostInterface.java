package cn.edu.nju.application.data.retrofit;

import cn.edu.nju.application.data.response.InsertResponse;
import cn.edu.nju.application.presentation.model.Post;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by tjDu on 2016/9/27.
 */
public interface RetrofitPostInterface {
    /**
     * 发帖子
     *
     * @param post
     * @return
     */
    @POST("addPost")
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    Call<InsertResponse> addPost(@Body Post post);

    /**
     * 删帖子
     */
    @GET("deletePost/{id}")
    Call<InsertResponse> deletePost(@Path("id") int id);
}
