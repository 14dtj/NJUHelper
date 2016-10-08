package cn.edu.nju.application.presentation.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by phoebegl on 16/9/21.
 * 用户点赞的帖子列表
 */
public class UserStar {
    @SerializedName("username")
    private String username;
    @SerializedName("post_Id")
    private int post_Id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPost_Id() {
        return post_Id;
    }

    public void setPost_Id(int post_Id) {
        this.post_Id = post_Id;
    }

    public UserStar(String username, int post_Id) {
        this.username = username;
        this.post_Id = post_Id;
    }
}
