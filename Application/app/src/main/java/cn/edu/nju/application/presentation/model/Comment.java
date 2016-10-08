package cn.edu.nju.application.presentation.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by phoebegl on 16/9/21.
 * 对帖子的评论留言对应的model
 */
public class Comment {
    @SerializedName("username")
    private String username;
    @SerializedName("post_Id")
    private int post_Id;
    @SerializedName("content")
    private String content;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Comment(String username, int post_Id, String content) {
        this.username = username;
        this.post_Id = post_Id;
        this.content = content;
    }
}
