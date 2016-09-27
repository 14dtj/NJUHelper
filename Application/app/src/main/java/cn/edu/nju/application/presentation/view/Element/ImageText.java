package cn.edu.nju.application.presentation.view.element;

import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.edu.nju.application.R;

/**
 * Created by phoebegl on 16/9/27.
 * 该类封装了底部每个tab的类
 */

public class ImageText extends LinearLayout{

    private Context context = null;
    private ImageView imageView = null;
    private TextView textView = null;

    private final static int DEFAULT_IMAGE_WIDTH = 64;
    private final static int DEFAULT_IMAGE_HEIGHT = 64;
    private int SELECT_COLOR = Color.rgb(29,118,199);
    private int UNSELECT_COLOR = Color.GRAY;

    public ImageText(Context c) {
        super(c);
        // TODO Auto-generated constructor stub
        context = c;
    }
//    public ImageText(Context c, AttributeSet attrs) {
//        super(c, attrs);
//        // TODO Auto-generated constructor stub
//        context = c;
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View parentView = inflater.inflate(R.layout.image_text_layout, this, true);
//        mImageView = (ImageView)findViewById(R.id.image_iamge_text);
//        mTextView = (TextView)findViewById(R.id.text_iamge_text);
//    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        // TODO Auto-generated method stub
        return true;
    }

    public void setImageSize(int w,int h) {
        if(imageView != null) {
            ViewGroup.LayoutParams params = imageView.getLayoutParams();
            params.width = w;
            params.height = h;
            imageView.setLayoutParams(params);
        }
    }

    public void setImage(int id) {
        if(imageView != null) {
            imageView.setImageResource(id);
            setImageSize(DEFAULT_IMAGE_WIDTH,DEFAULT_IMAGE_HEIGHT);
        }
    }

    public void setText(String s) {
        if(textView != null) {
            textView.setText(s);
            textView.setTextColor(UNSELECT_COLOR);
        }
    }

    public void setSelected(int itemID) {
        if(textView != null)
            textView.setTextColor(SELECT_COLOR);

        int selectID = 0;
        switch (itemID) {
            case Constant.BTN_HOME:
                selectID = R.mipmap.home_select;
                break;
            case Constant.BTN_TOPIC:
                selectID = R.mipmap.topic_select;
                break;
            case Constant.BTN_STORE:
                selectID = R.mipmap.store_select;
                break;
            case Constant.BTN_USER:
                selectID = R.mipmap.user_select;
                break;
            default:
                break;
        }

        if(imageView != null){
            imageView.setImageResource(selectID);
        }
    }






}
