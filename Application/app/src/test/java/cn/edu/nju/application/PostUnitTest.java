package cn.edu.nju.application;

import org.junit.Test;

import java.util.List;

import cn.edu.nju.application.data.PostDaoImpl;
import cn.edu.nju.application.presentation.model.Comment;
import cn.edu.nju.application.presentation.model.Post;
import cn.edu.nju.application.presentation.model.UserCollect;
import cn.edu.nju.application.presentation.model.UserStar;

/**
 * Created by tjDu on 2016/9/27.
 */
public class PostUnitTest {
    @Test
    public void testAddPost() {
        PostDaoImpl dao = new PostDaoImpl();
        Post post = new Post("tj", "traveller", "gl666", true, "travel");
        System.out.println(dao.addPost(post));
    }

    @Test
    public void testDeletePost() {
        PostDaoImpl dao = new PostDaoImpl();
        System.out.println(dao.deletePost(1));
    }

    @Test
    public void testUpdatePost() {
        PostDaoImpl dao = new PostDaoImpl();
        Post post = new Post("tj", "666", "gl666", true, "travel");
        post.setId(2);
        System.out.println(dao.updatePost(post));
    }

    @Test
    public void testShowPost() {
        PostDaoImpl dao = new PostDaoImpl();
        System.out.println(dao.showPost(2).getTitle());
    }

    @Test
    public void testShowPostList() {
        PostDaoImpl dao = new PostDaoImpl();
        List<Post> result = dao.showPostList("旅行");
        System.out.println(result.get(0).getTitle());
    }

    @Test
    public void testShowComments() {
        PostDaoImpl dao = new PostDaoImpl();
        System.out.println(dao.showComments(1).size());
    }

    @Test
    public void testAddComment() {
        PostDaoImpl dao = new PostDaoImpl();
        Comment comment = new Comment("tj", 2, "good");
        System.out.println(dao.addComment(comment));
    }

    @Test
    public void testCollectPost() {
        PostDaoImpl dao = new PostDaoImpl();
        UserCollect collect = new UserCollect("gl", 2);
        System.out.println(dao.collectPost(collect));
    }

    @Test
    public void testStarPost() {
        PostDaoImpl dao = new PostDaoImpl();
        UserStar collect = new UserStar("gl", 2);
        System.out.println(dao.starPost(collect));
    }

    @Test
    public void testUploadImage() {
        PostDaoImpl dao = new PostDaoImpl();
        System.out.println(dao.uploadImage(2));
    }

    @Test
    public void testGetImage() {
        PostDaoImpl dao = new PostDaoImpl();
        dao.getPostImage(2);
    }
}
