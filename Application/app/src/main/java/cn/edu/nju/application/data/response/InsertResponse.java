package cn.edu.nju.application.data.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tjDu on 2016/9/27.
 */
public class InsertResponse {
    @SerializedName("success")
    public int success;

    public InsertResponse(int success) {
        this.success = success;
    }

    public int isSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }
}
