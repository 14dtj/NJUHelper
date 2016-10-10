package cn.edu.nju.application.presentation.presenter;

import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.edu.nju.application.data.IUserDao;
import cn.edu.nju.application.data.UserDaoImpl;
import cn.edu.nju.application.presentation.fragment.PostFragment;
import cn.edu.nju.application.presentation.model.Post;
import cn.edu.nju.application.presentation.model.User;

/**
 * Created by phoebegl on 2016/10/10.
 */

public class PostPresenter {

    private IUserDao dao;
    private PostFragment fragment;

    public PostPresenter(PostFragment frag) {
        this.dao = new UserDaoImpl();
        this.fragment = frag;
    }

    public void loadPost(User user) {
        List<Post> list = dao.showPosts(user.getUsername());
        ArrayList<HashMap<String, Object>> data = new ArrayList<>();
        for (Post post : list) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("title", post.getTitle());
            map.put("content", post.getContent());
            data.add(map);
        }
        fragment.setPostAdapter(data);
    }
}
