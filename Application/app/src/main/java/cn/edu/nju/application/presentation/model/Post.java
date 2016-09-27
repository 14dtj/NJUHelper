package cn.edu.nju.application.presentation.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by phoebegl on 16/9/21.
 * 帖子的对应model
 */
public class Post {
    @SerializedName("id")
    private int id;
    @SerializedName("username")
    private String authorName;
    @SerializedName("content")
    private String content;
    @SerializedName("title")
    private String title;
    @SerializedName("image")
    private Byte[] image;
    @SerializedName("state")
    private boolean state;
    @SerializedName("star_num")
    private int star_num;
    @SerializedName("collect_num")
    private int collect_num;
    @SerializedName("catelog")
    private String catelog;

    public int getCollect_num() {
        return collect_num;
    }

    public void setCollect_num(int collect_num) {
        this.collect_num = collect_num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getStar_num() {
        return star_num;
    }

    public void setStar_num(int star_num) {
        this.star_num = star_num;
    }

    public String getCatelog() {
        return catelog;
    }

    public void setCatelog(String catelog) {
        this.catelog = catelog;
    }

    public Post(String authorName, String content, String title, Byte[] image, boolean state,String catelog) {
        this.authorName = authorName;
        this.content = content;
        this.title = title;
        this.image = image;
        this.state = state;
        this.star_num = 0;
        this.collect_num = 0;
        this.catelog = catelog;
    }
}
