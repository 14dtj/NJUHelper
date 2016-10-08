package cn.edu.nju.application.presentation.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import cn.edu.nju.application.R;
import cn.edu.nju.application.presentation.activity.MainActivity;
import cn.edu.nju.application.presentation.presenter.HomeFragmentPresenter;
import cn.edu.nju.application.presentation.util.Constant;

/**
 * Created by phoebegl on 16/9/28.
 */

public class HomeFragment extends BaseFragment {
    private ListView postList;
    private View view;
    private HomeFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.homefrag_layout,
                container, false);
        presenter = new HomeFragmentPresenter(this);
        postList = (ListView) view.findViewById(R.id.list);
        presenter.loadPosts();
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

        MainActivity.currentFrag = Constant.FRAGMENT_HOME;

    }

    public void setPostAdapter(ArrayList<HashMap<String, String>> list) {
        String[] from = {"title", "content"};
        int[] to = {R.id.title_text, R.id.content_text};
        SimpleAdapter adapter = new SimpleAdapter(view.getContext(), list, R.layout.simplepost_layout, from, to);
        postList.setAdapter(adapter);
    }


}
