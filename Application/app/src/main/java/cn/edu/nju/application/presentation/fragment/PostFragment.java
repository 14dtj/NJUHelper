package cn.edu.nju.application.presentation.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import cn.edu.nju.application.R;
import cn.edu.nju.application.presentation.activity.MainActivity;
import cn.edu.nju.application.presentation.presenter.HomeFragmentPresenter;
import cn.edu.nju.application.presentation.presenter.PostPresenter;
import cn.edu.nju.application.presentation.util.Constant;

/**
 * Created by phoebegl on 2016/10/10.
 */

public class PostFragment extends Fragment{

    private ListView postlist;
    private PostPresenter presenter;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        view = inflater.inflate(R.layout.myposts_layout, container, false);
        presenter = new PostPresenter(this);
        postlist = (ListView) view.findViewById(R.id.post_list);
        presenter.loadPost(MainActivity.getLoginUser());
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void setPostAdapter(ArrayList<HashMap<String, Object>> list) {
        String[] from = {"title", "content"};
        int[] to = {R.id.short_title, R.id.short_content};
        SimpleAdapter adapter = new SimpleAdapter(view.getContext(), list, R.layout.shortpost_layout, from, to);
        postlist.setAdapter(adapter);
    }
}
