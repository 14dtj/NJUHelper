package cn.edu.nju.application.presentation.model;

/**
 * Created by phoebegl on 16/9/21.
 * 对帖子的评论留言对应的model
 */
public class Comment {

    private String username;
    private int postId;
    private String content;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
