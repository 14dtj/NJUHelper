package cn.edu.nju.application.presentation.model;

/**
 * Created by phoebegl on 16/9/21.
 * 帖子的对应model
 */
public class Post {

    private int id;
    private String authorName;
    private String content;
    private String title;
    private Byte[] image;
    private boolean state;
    private int star_num;
    private int collect_num;
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
}
