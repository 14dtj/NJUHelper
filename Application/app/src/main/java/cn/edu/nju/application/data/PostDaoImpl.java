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

    public PostDaoImpl() {
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
        Call<InsertResponse> value = service.updatePost(post);
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
    public Post showPost(int id) {
        Call<Post> value = service.showPost(id);
        Post result = null;
        try {
            Response<Post> response = value.execute();
            result = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Post> showPostList(String catelog) {
        Call<List<Post>> value = service.showPostByCategory(catelog);
        List<Post> result = null;
        try {
            Response<List<Post>> response = value.execute();
            result = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Comment> showComments(int id) {
        Call<List<Comment>> value = service.showComment(id);
        List<Comment> result = null;
        try {
            Response<List<Comment>> response = value.execute();
            result = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int addComment(Comment comment) {
        Call<InsertResponse> value = service.addComment(comment);
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
    public int collectPost(UserCollect collect) {
        Call<InsertResponse> value = service.collectPost(collect);
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
    public int starPost(UserStar star) {
        Call<InsertResponse> value = service.starPost(star);
        int result = 0;
        try {
            Response<InsertResponse> response = value.execute();
            result = response.body().isSuccess();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
