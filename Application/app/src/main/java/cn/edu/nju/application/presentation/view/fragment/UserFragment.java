package cn.edu.nju.application.presentation.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.edu.nju.application.R;
import cn.edu.nju.application.presentation.view.activity.MainActivity;
import cn.edu.nju.application.presentation.view.element.Constant;

/**
 * Created by phoebegl on 16/9/28.
 */

public class UserFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View settingLayout = inflater.inflate(R.layout.userfrag_layout,
                container, false);
        return settingLayout;
    }


    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();

        MainActivity.currentFrag = Constant.FRAGMENT_USER;

    }
}
