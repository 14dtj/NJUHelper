package cn.edu.nju.application.data;

import java.util.List;

import cn.edu.nju.application.presentation.model.Post;
import cn.edu.nju.application.presentation.model.User;
import cn.edu.nju.application.presentation.model.UserCollect;
import cn.edu.nju.application.presentation.model.UserFollower;
import cn.edu.nju.application.presentation.model.UserStar;

/**
 * Created by phoebegl on 16/9/21.
 */
public interface IUserDao {

    /**
     * 用户注册
     * @param user
     * @return
     */
    int signUp(User user);

    /**
     * 根据登录情况获得用户信息
     * @param username
     * @param password
     * @return
     */
    User showUserInfo(String username,String password);

    /**
     * 修改个人信息
     * @param user
     * @return
     */
    int updateUserInfo(User user);

    /**
     * 显示用户粉丝
     * @param username
     * @return
     */
    List<UserFollower> showFollowers(String username);

    /**
     * 显示用户点赞情况
     * @param username
     * @return
     */
    List<UserStar> showstars(String username);

    /**
     * 显示用户收藏帖子情况
     * @param username
     * @return
     */
    List<UserCollect> showCollections(String username);

    /**
     * 显示自己所有帖子
     * @param username
     * @return
     */
    List<Post> showPosts(String username);
}
