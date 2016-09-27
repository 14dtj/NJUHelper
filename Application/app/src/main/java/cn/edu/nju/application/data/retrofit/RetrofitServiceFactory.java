package cn.edu.nju.application.data.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tjDu on 2016/9/23.
 */
public class RetrofitServiceFactory {
    public static final String BASE_URL = "http://115.28.181.96/";
    private static RetrofitUserInterface retrofitUserInterface;
    private static RetrofitPostInterface retrofitPostInterface;
    public static RetrofitUserInterface getUserService(){
        if(retrofitUserInterface ==null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            retrofitUserInterface = retrofit.create(RetrofitUserInterface.class);
        }
        return retrofitUserInterface;
    }
    public static RetrofitPostInterface getPostService(){
        if(retrofitPostInterface ==null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            retrofitPostInterface = retrofit.create(RetrofitPostInterface.class);
        }
        return retrofitPostInterface;
    }
}
