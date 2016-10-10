package cn.edu.nju.application.data.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tjDu on 2016/10/10.
 */

public class CollectionResponse {
    @SerializedName("post_Id")
    private int post_Id;

    public CollectionResponse(int post_Id) {
        this.post_Id = post_Id;
    }

    public int getPost_Id() {
        return post_Id;
    }

    public void setPost_Id(int post_Id) {
        this.post_Id = post_Id;
    }
}
