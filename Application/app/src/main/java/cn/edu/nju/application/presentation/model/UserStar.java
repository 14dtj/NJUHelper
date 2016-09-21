package cn.edu.nju.application.presentation.model;

/**
 * Created by phoebegl on 16/9/21.
 * 用户点赞的帖子列表
 */
public class UserStar {

    private String username;
    private int postId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}
