package cn.edu.nju.application.data.retrofit;

import android.provider.SyncStateContract;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;
import rx.Subscriber;
/**
 * Created by tjDu on 2016/9/22.
 */
public class RetrofitService {
    private static RetrofitService retrofitService = new RetrofitService();
    private RetrofitInterface retrofitInterface;
    private String methodName;



    public static RetrofitService getInstance(){
        if(retrofitService == null){
            retrofitService = new RetrofitService();
        }
        return retrofitService;
    }


}
