package cn.edu.nju.application.data.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by tjDu on 2016/9/23.
 */
public interface RetrofitUserInterface {
    @GET("user/{username}/{pwd}")
    Call<String> authenticate(@Path("username") String username, @Path("pwd") String password);
}
