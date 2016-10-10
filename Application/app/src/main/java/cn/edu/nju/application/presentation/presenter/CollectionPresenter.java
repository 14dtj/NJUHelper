package cn.edu.nju.application.presentation.presenter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import cn.edu.nju.application.data.IPostDao;
import cn.edu.nju.application.data.IUserDao;
import cn.edu.nju.application.data.PostDaoImpl;
import cn.edu.nju.application.data.UserDaoImpl;
import cn.edu.nju.application.presentation.fragment.CollectionFragment;
import cn.edu.nju.application.presentation.fragment.PostFragment;
import cn.edu.nju.application.presentation.model.Post;
import cn.edu.nju.application.presentation.model.User;
import cn.edu.nju.application.presentation.model.UserCollect;

/**
 * Created by phoebegl on 2016/10/10.
 */

public class CollectionPresenter {

    private IUserDao dao;
    private IPostDao postDao;
    private CollectionFragment fragment;

    public CollectionPresenter(CollectionFragment frag) {
        this.dao = new UserDaoImpl();
        this.postDao = new PostDaoImpl();
        this.fragment = frag;
    }

    public void loadCollection(User user) {
        List<UserCollect> list = dao.showCollections(user.getUsername());
        ArrayList<HashMap<String, Object>> data = new ArrayList<>();
        for (UserCollect post : list) {
            HashMap<String, Object> map = new HashMap<>();
            Post temp = postDao.showPost(post.getPost_Id());
            map.put("title", temp.getTitle());
            map.put("content", temp.getContent());
            data.add(map);
        }
        fragment.setPostAdapter(data);
    }
}
