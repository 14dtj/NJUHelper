package cn.edu.nju.application.presentation.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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
    private ImageSwitcher switcher;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        view = inflater.inflate(R.layout.homefrag_layout,
                container, false);
        presenter = new HomeFragmentPresenter(this);
        postList = (ListView) view.findViewById(R.id.list);
        switcher = (ImageSwitcher) view.findViewById(R.id.theme_switcher);
        presenter.loadPosts();

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        MainActivity.currentFrag = Constant.FRAGMENT_HOME;
    }

    public void setPostAdapter(ArrayList<HashMap<String, Object>> list) {
        String[] from = {"title", "content", "image"};
        int[] to = {R.id.title_text, R.id.content_text, R.id.post_img};
        SimpleAdapter adapter = new SimpleAdapter(view.getContext(), list, R.layout.simplepost_layout, from, to);
        postList.setAdapter(adapter);
    }

}
