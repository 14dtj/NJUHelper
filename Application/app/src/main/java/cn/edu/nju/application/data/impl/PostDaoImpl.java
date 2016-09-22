package cn.edu.nju.application.data.Impl;

import java.util.List;

import cn.edu.nju.application.data.IPostDao;
import cn.edu.nju.application.presentation.model.Comment;
import cn.edu.nju.application.presentation.model.Post;
import cn.edu.nju.application.presentation.model.UserCollect;
import cn.edu.nju.application.presentation.model.UserStar;

/**
 * Created by tjDu on 2016/9/22.
 */
public class PostDaoImpl implements IPostDao {
    @Override
    public int addPost(Post post) {
        return 0;
    }

    @Override
    public int deletePost(String id) {
        return 0;
    }

    @Override
    public int updatePost(Post post) {
        return 0;
    }

    @Override
    public Post showPost(String id) {
        return null;
    }

    @Override
    public List<Post> showPostList(String catelog) {
        return null;
    }

    @Override
    public List<Comment> showComments(String id) {
        return null;
    }

    @Override
    public int addComment(Comment comment) {
        return 0;
    }

    @Override
    public int collectPost(UserCollect collect) {
        return 0;
    }

    @Override
    public int starPost(UserStar star) {
        return 0;
    }
}
