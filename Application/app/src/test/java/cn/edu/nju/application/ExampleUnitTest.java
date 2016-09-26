package cn.edu.nju.application;

import org.junit.Test;

import cn.edu.nju.application.data.UserDaoImpl;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        UserDaoImpl  dao = new UserDaoImpl();
        System.out.println(dao.showUserInfo("tj","123456").getEmail());
    }
}