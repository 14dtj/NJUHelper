package cn.edu.nju.application.presentation.util;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.edu.nju.application.R;
import cn.edu.nju.application.presentation.util.Constant;

/**
 * Created by phoebegl on 16/10/3.
 */

public class HeadPanel extends RelativeLayout {

    private Context context;
    private TextView middleTitle;
    private TextView rightTitle;
    private static final float middle_title_size = 20f;
    private static final float right_title_size = 17f;
    private static final int default_background_color = Color.rgb(21, 126, 203);

    public HeadPanel(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        // TODO Auto-generated method stub
        middleTitle = (TextView)findViewById(R.id.middle_title);
        rightTitle = (TextView)findViewById(R.id.right_title);
        setBackgroundColor(default_background_color);
    }

    public void init(){
        if(middleTitle != null){
            setMiddleTitle(Constant.FRAGMENT_HOME);
        }
    }
    public void setMiddleTitle(String s){
        middleTitle.setText(s);
        middleTitle.setTextSize(middle_title_size);
    }

}
