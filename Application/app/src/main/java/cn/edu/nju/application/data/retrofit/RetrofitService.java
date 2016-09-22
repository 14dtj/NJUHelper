package cn.edu.nju.application.data.retrofit;

import retrofit2.Retrofit;

/**
 * Created by tjDu on 2016/9/22.
 */
public class RetrofitService {
    private RetrofitInterface service;
    public RetrofitService(){
        Retrofit retrofit = new Retrofit.Builder()  //01:获取Retrofit对象
                .baseUrl("https://115.28.181.96") //02采用链式结构绑定Base url
                .build();//03执行操作
        service = (RetrofitInterface) retrofit.create(RetrofitService.class);//04获取API接口的实现类的实例对象
    }
    public RetrofitInterface getService(){
        return service;
    }
}
