package cn.edu.nju.application;

import org.junit.Test;

import cn.edu.nju.application.data.PostDaoImpl;
import cn.edu.nju.application.presentation.model.Post;

/**
 * Created by tjDu on 2016/9/27.
 */
public class PostUnitTest {
    @Test
    public void testAddPost() {
        PostDaoImpl dao = new PostDaoImpl();
        Post post = new Post("gl", "777", "gl666", null, true, "旅行");
        System.out.println(dao.addPost(post));
    }

    @Test
    public void testDeletePost() {
        PostDaoImpl dao = new PostDaoImpl();
        System.out.println(dao.deletePost(2));
    }
}
