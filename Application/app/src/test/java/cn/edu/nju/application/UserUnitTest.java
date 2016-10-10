package cn.edu.nju.application;

import org.junit.Test;

import cn.edu.nju.application.data.UserDaoImpl;
import cn.edu.nju.application.presentation.model.User;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class UserUnitTest {
    @Test
    public void testLogin() throws Exception {
        UserDaoImpl dao = new UserDaoImpl();
        System.out.println(dao.showUserInfo("tj", "123456").getEmail());
    }

    @Test
    public void testSignUp() {
        UserDaoImpl dao = new UserDaoImpl();
        User user = new User("gl", "123456", "female", "Nanjing", "gl@qq.com");
        System.out.println(dao.signUp(user));
    }

    @Test
    public void testUpdate() {
        UserDaoImpl dao = new UserDaoImpl();
        User user = new User("daye", "123456", "female", "Xuzhou", "daye@qq.com");
        System.out.println(dao.updateUserInfo(user));
    }

    @Test
    public void testFollowers() {
        UserDaoImpl dao = new UserDaoImpl();
        System.out.println(dao.showFollowers("gl").size());
    }

    @Test
    public void testStar() {
        UserDaoImpl dao = new UserDaoImpl();
        System.out.println(dao.showstars("gl"));
    }

    @Test
    public void testCollect() {
        UserDaoImpl dao = new UserDaoImpl();
        System.out.println(dao.showCollections("tj").get(1).getPost_Id());
    }

    @Test
    public void testHistory() {
        UserDaoImpl dao = new UserDaoImpl();
        System.out.println(dao.showPosts("tj").get(0).getCatelog());
    }
}