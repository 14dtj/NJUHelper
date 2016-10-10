package cn.edu.nju.application.presentation.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.HashMap;

import cn.edu.nju.application.R;
import cn.edu.nju.application.presentation.activity.MainActivity;
import cn.edu.nju.application.presentation.activity.SinglePostActivity;
import cn.edu.nju.application.presentation.presenter.HomeFragmentPresenter;
import cn.edu.nju.application.presentation.util.Constant;

/**
 * Created by phoebegl on 16/9/28.
 */

public class HomeFragment extends BaseFragment implements ViewSwitcher.ViewFactory, View.OnTouchListener {
    private ListView postList;
    private View view;
    private HomeFragmentPresenter presenter;
    private ImageSwitcher switcher;
    private LinearLayout linearLayout;
    private int[] themeImgIds;
    private ImageView[] tips;
    private int currentPosition;
    private float downX;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        view = inflater.inflate(R.layout.homefrag_layout,
                container, false);
        presenter = new HomeFragmentPresenter(this);
        postList = (ListView) view.findViewById(R.id.list);
        postList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), SinglePostActivity.class);
                intent.putExtra("id", position);
                startActivity(intent);
            }
        });
        switcher = (ImageSwitcher) view.findViewById(R.id.theme_switcher);
        linearLayout = (LinearLayout) view.findViewById(R.id.viewGroup);
        presenter.loadPosts();
        initSwitcher();
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        MainActivity.currentFrag = Constant.FRAGMENT_HOME;
    }

    public void setPostAdapter(ArrayList<HashMap<String, Object>> list) {
        String[] from = {"title", "content", "image"};
        int[] to = {R.id.title_text, R.id.content_text, R.id.post_img};
        SimpleAdapter adapter = new SimpleAdapter(view.getContext(), list, R.layout.simplepost_layout, from, to);
        postList.setAdapter(adapter);
    }

    public void initSwitcher() {
        themeImgIds = new int[]{R.drawable.item01, R.drawable.item02, R.drawable.item03, R.drawable.item04};
        switcher.setFactory(this);
        switcher.setOnTouchListener(this);
        tips = new ImageView[themeImgIds.length];
        for (int i = 0; i < themeImgIds.length; i++) {
            ImageView mImageView = new ImageView(this.getActivity());
            tips[i] = mImageView;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            layoutParams.rightMargin = 3;
            layoutParams.leftMargin = 3;

            mImageView.setBackgroundResource(R.drawable.page_indicator_unfocused);
            linearLayout.addView(mImageView, layoutParams);
        }
        switcher.setImageResource(themeImgIds[currentPosition]);

        setImageBackground(currentPosition);
    }

    private void setImageBackground(int selectItems) {
        for (int i = 0; i < tips.length; i++) {
            if (i == selectItems) {
                tips[i].setBackgroundResource(R.drawable.page_indicator_focused);
            } else {
                tips[i].setBackgroundResource(R.drawable.page_indicator_unfocused);
            }
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                downX = event.getX();
                break;
            }
            case MotionEvent.ACTION_UP: {
                float lastX = event.getX();
                if (lastX > downX) {
                    if (currentPosition > 0) {
                        switcher.setInAnimation(AnimationUtils.loadAnimation(getActivity().getApplication(), R.anim.left_in));
                        switcher.setOutAnimation(AnimationUtils.loadAnimation(getActivity().getApplication(), R.anim.right_out));
                        currentPosition--;
                        switcher.setImageResource(themeImgIds[currentPosition % themeImgIds.length]);
                        setImageBackground(currentPosition);
                    }
                }

                if (lastX < downX) {
                    if (currentPosition < themeImgIds.length - 1) {
                        switcher.setInAnimation(AnimationUtils.loadAnimation(getActivity().getApplication(), R.anim.right_in));
                        switcher.setOutAnimation(AnimationUtils.loadAnimation(getActivity().getApplication(), R.anim.lift_out));
                        currentPosition++;
                        switcher.setImageResource(themeImgIds[currentPosition]);
                        setImageBackground(currentPosition);
                    }
                }
            }

            break;
        }

        return true;
    }

    @Override
    public View makeView() {
        final ImageView i = new ImageView(this.getActivity());
        i.setBackgroundColor(0xff000000);
        i.setScaleType(ImageView.ScaleType.CENTER_CROP);
        i.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
        return i;
    }

    public void myFinish() {
        this.getActivity().finish();
    }
}
