package cn.edu.nju.application.data.retrofit;

import java.util.List;

import cn.edu.nju.application.data.response.InsertResponse;
import cn.edu.nju.application.presentation.model.Comment;
import cn.edu.nju.application.presentation.model.Post;
import cn.edu.nju.application.presentation.model.UserCollect;
import cn.edu.nju.application.presentation.model.UserStar;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
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

    /**
     * 编辑帖子
     * @param post
     * @return
     */
    @POST("updatePost")
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    Call<InsertResponse> updatePost(@Body Post post);

    /**
     * 展示帖子具体内容
     * @param id
     * @return
     */
    @GET("showPost/{id}")
    Call<Post> showPost(@Path("id") int id);

    /**
     * 根据类别展示帖子列表
     * @param category
     * @return
     */
    @GET("showPostByCategory/{category}")
    Call<List<Post>> showPostByCategory(@Path("category") String category);

    /**
     * 展示帖子评论
     * @param id
     * @return
     */
    @GET("showComment/{id}")
    Call<List<Comment>> showComment(@Path("id") int id);

    /**
     * 添加评论
     * @param comment
     * @return
     */
    @POST("addComment")
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    Call<InsertResponse> addComment(@Body Comment comment);

    /**
     * 收藏帖子
     * @param data
     * @return
     */
    @POST("collectPost")
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    Call<InsertResponse> collectPost(@Body UserCollect data);

    /**
     * 点赞帖子
     * @param data
     * @return
     */
    @POST("starPost")
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    Call<InsertResponse> starPost(@Body UserStar data);

    /**
     * 展示所有的帖子
     * @return
     */
    @GET("showAllPosts")
    Call<List<Post>> showAllPosts();

    @Multipart
    @POST("upload.php")
    Call<InsertResponse> uploadImage(@Part("id") int id,
                                     @Part MultipartBody.Part file);
}
