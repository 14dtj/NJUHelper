package cn.edu.nju.application.presentation.util;

/**
 * Created by tjDu on 2016/9/27.
 */
public enum PostCatelog {
    TRAVEL("旅行"),DIGIT("数码"),FOOD("美食");

    private String value;

    private PostCatelog(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
