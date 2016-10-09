package cn.edu.nju.application.presentation.presenter;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.edu.nju.application.data.DataFactory;
import cn.edu.nju.application.data.IPostDao;
import cn.edu.nju.application.presentation.fragment.HomeFragment;
import cn.edu.nju.application.presentation.model.Post;

/**
 * Created by tjDu on 2016/10/8.
 */

public class HomeFragmentPresenter extends AsyncTask{
    private IPostDao dao;
    private HomeFragment view;

    public HomeFragmentPresenter(HomeFragment view) {
        dao = DataFactory.getPostDao();
        this.view = view;
    }

    public void loadPosts() {
        List<Post> list = dao.showAllPosts();
        ArrayList<HashMap<String, String>> data = new ArrayList<>();
        for (Post post : list) {
            HashMap<String, String> map = new HashMap<>();
            map.put("title", post.getTitle());
            map.put("content", post.getContent());
            data.add(map);
        }
        view.setPostAdapter(data);
    }

    @Override
    protected Object doInBackground(Object[] params) {
        loadPosts();
        return null;
    }
}
