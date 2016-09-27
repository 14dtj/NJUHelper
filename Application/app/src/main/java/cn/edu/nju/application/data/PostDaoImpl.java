package cn.edu.nju.application.data;

import java.io.IOException;
import java.util.List;

import cn.edu.nju.application.data.response.InsertResponse;
import cn.edu.nju.application.data.retrofit.RetrofitPostInterface;
import cn.edu.nju.application.data.retrofit.RetrofitServiceFactory;
import cn.edu.nju.application.presentation.model.Comment;
import cn.edu.nju.application.presentation.model.Post;
import cn.edu.nju.application.presentation.model.UserCollect;
import cn.edu.nju.application.presentation.model.UserStar;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by tjDu on 2016/9/27.
 */
public class PostDaoImpl implements IPostDao {
    private RetrofitPostInterface service;
    public PostDaoImpl(){
        service = RetrofitServiceFactory.getPostService();
    }
    @Override
    public int addPost(Post post) {
        Call<InsertResponse> value = service.addPost(post);
        int result = 0;
        try {
            Response<InsertResponse> response = value.execute();
            result = response.body().isSuccess();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deletePost(int id) {
        Call<InsertResponse> value = service.deletePost(id);
        int result = 0;
        try {
            Response<InsertResponse> response = value.execute();
            result = response.body().isSuccess();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
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
