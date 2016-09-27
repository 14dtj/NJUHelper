package cn.edu.nju.application.presentation.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by phoebegl on 16/9/21.
 * 用户收藏列表
 */
public class UserCollect {
    @SerializedName("username")
    private String username;
    @SerializedName("title")
    private String title;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UserCollect(String username, String title) {
        this.username = username;
        this.title = title;
    }
}
