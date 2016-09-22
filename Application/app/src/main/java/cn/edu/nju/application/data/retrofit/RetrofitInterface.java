package cn.edu.nju.application.data.retrofit;

import retrofit2.http.GET;

/**
 * Created by tjDu on 2016/9/22.
 */
public interface RetrofitInterface {
    @GET("/addUser.php")
    boolean login();
}
