package cn.edu.nju.application.data;

/**
 * Created by tjDu on 2016/10/8.
 */

public class DataFactory {
    private static IUserDao userDao;
    private static IPostDao postDao;

    public static IUserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoImpl();
        }
        return userDao;
    }

    public static IPostDao getPostDao() {
        if (postDao == null) {
            postDao = new PostDaoImpl();
        }
        return postDao;
    }
}
