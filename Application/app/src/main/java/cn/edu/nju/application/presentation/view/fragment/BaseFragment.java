package cn.edu.nju.application.presentation.view.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.edu.nju.application.presentation.view.element.Constant;

/**
 * Created by phoebegl on 16/9/27.
 */

public class BaseFragment extends Fragment {

    private static final String TAG = "BaseFragment";
    protected FragmentManager mFragmentManager = null;
    protected FragmentTransaction mFragmentTransaction = null;

    @Override
    public void onAttach(Activity activity) {
        // TODO Auto-generated method stub
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        return 	super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
    }

    @Override
    public void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
    }

    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        // TODO Auto-generated method stub
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }

    public static BaseFragment newInstance(Context context, String tag){
        BaseFragment baseFragment =  null;
        if(TextUtils.equals(tag, Constant.FRAGMENT_HOME)){
            baseFragment = new HomeFragment();
        }else if(TextUtils.equals(tag, Constant.FRAGMENT_TOPIC)){
            baseFragment = new TopicFragment();
        }else if(TextUtils.equals(tag, Constant.FRAGMENT_STORE)){
            baseFragment = new StoreFragment();
        }else if(TextUtils.equals(tag, Constant.FRAGMENT_USER)){
            baseFragment = new UserFragment();
        }
        return baseFragment;

    }
}
