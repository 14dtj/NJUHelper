package cn.edu.nju.application.presentation.util;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import cn.edu.nju.application.R;
import cn.edu.nju.application.presentation.util.Constant;
import cn.edu.nju.application.presentation.util.ImageText;

/**
 * Created by phoebegl on 16/9/27.
 */

public class BottomPanel extends RelativeLayout implements View.OnClickListener{

    private Context context;
    private ImageText btn_home = null;
    private ImageText btn_topic = null;
    private ImageText btn_store = null;
    private ImageText btn_user = null;
    private int DEFALUT_BACKGROUND_COLOR = Color.rgb(243, 243, 243);
    private BottomPanelCall call = null;
    private List<ImageText> list = new ArrayList<ImageText>();

    public interface BottomPanelCall {
        public void BottomPanelClick(int itemID);
    }
    public void setBottomCall(BottomPanelCall bottomCall) {
        call = bottomCall;
    }

    @Override
    /**
     * 实例化元素
     */
    protected void onFinishInflate() {
        // TODO Auto-generated method stub
        btn_home = (ImageText)findViewById(R.id.btn_home);
        btn_topic = (ImageText)findViewById(R.id.btn_topic);
        btn_store = (ImageText)findViewById(R.id.btn_store);
        btn_user = (ImageText)findViewById(R.id.btn_user);
        setBackgroundColor(DEFALUT_BACKGROUND_COLOR);
        list.add(btn_home);
        list.add(btn_topic);
        list.add(btn_store);
        list.add(btn_user);
    }

    /**
     * 设置每个元素的图片、文字与监听
     */
    public void init() {
        if(btn_home != null) {
            btn_home.setImage(R.mipmap.home);
            btn_home.setText(Constant.FRAGMENT_HOME);
        }
        if(btn_topic != null) {
            btn_topic.setImage(R.mipmap.topic);
            btn_topic.setText(Constant.FRAGMENT_TOPIC);
        }
        if(btn_store != null) {
            btn_store.setImage(R.mipmap.store);
            btn_store.setText(Constant.FRAGMENT_STORE);
        }
        if(btn_user != null) {
            btn_user.setImage(R.mipmap.user);
            btn_user.setText(Constant.FRAGMENT_USER);
        }
        setBtnListener();
    }

    @Override
    public void onClick(View v) {
        init();
        int index = -1;
        switch (v.getId()) {
            case R.id.btn_home:
                index = Constant.BTN_HOME;
                btn_home.setSelected(Constant.BTN_HOME);
                break;
            case R.id.btn_topic:
                index = Constant.BTN_TOPIC;
                btn_topic.setSelected(Constant.BTN_TOPIC);
                break;
            case R.id.btn_store:
                index = Constant.BTN_STORE;
                btn_store.setSelected(Constant.BTN_STORE);
                break;
            case R.id.btn_user:
                index = Constant.BTN_USER;
                btn_user.setSelected(Constant.BTN_USER);
                break;
            default:
                break;
        }

        if(call != null){
            call.BottomPanelClick(index);
        }
    }

    public void setDefaultSelect() {
        if(btn_home != null)
            btn_home.setSelected(Constant.BTN_HOME);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        // TODO Auto-generated method stub
        super.onLayout(changed, left, top, right, bottom);
        layoutItems(left, top, right, bottom);
    }

    /*
     *最左边和最右边的view由母布局的padding进行控制位置。这里需对第2、3个view的位置重新设置
     */
    private void layoutItems(int left, int top, int right, int bottom){
        int n = getChildCount();
        if(n == 0){
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int width = right - left;
        int height = bottom - top;
        int allViewWidth = 0;
        for(int i = 0; i< n; i++){
            View v = getChildAt(i);
            allViewWidth += v.getWidth();
        }
        int blankWidth = (width - allViewWidth - paddingLeft - paddingRight) / (n - 1);

        LayoutParams params1 = (LayoutParams) list.get(1).getLayoutParams();
        params1.leftMargin = blankWidth;
        list.get(1).setLayoutParams(params1);

        LayoutParams params2 = (LayoutParams) list.get(2).getLayoutParams();
        params2.leftMargin = blankWidth;
        list.get(2).setLayoutParams(params2);
    }

    private void setBtnListener(){
        int num = this.getChildCount();
        for(int i = 0; i < num; i++){
            View v = getChildAt(i);
            if(v != null){
                v.setOnClickListener(this);
            }
        }
    }

    public BottomPanel(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

}
