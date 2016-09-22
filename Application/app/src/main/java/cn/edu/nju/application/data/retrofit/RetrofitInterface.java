package cn.edu.nju.application.data.retrofit;

import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by tjDu on 2016/9/22.
 */
public interface RetrofitInterface {
    @POST("/user.php")
    boolean login(@Query("username") String username,
                  @Query("password") String password);
}
