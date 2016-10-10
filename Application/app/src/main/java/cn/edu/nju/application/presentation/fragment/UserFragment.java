package cn.edu.nju.application.presentation.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import cn.edu.nju.application.R;
import cn.edu.nju.application.presentation.activity.MainActivity;
import cn.edu.nju.application.presentation.model.User;
import cn.edu.nju.application.presentation.presenter.UserFragmentPresenter;
import cn.edu.nju.application.presentation.util.Constant;

/**
 * Created by phoebegl on 16/9/28.
 */

public class UserFragment extends BaseFragment{

    private UserFragmentPresenter presenter;

    private ImageButton edit;
    private ImageView avatar;
    private TextView name,follower,star,credit,posts,collections;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.userfrag_layout,container, false);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        edit = (ImageButton) view.findViewById(R.id.btn_edit);
        avatar = (ImageView) view.findViewById(R.id.avatar);
        name = (TextView) view.findViewById(R.id.info_username);
        follower = (TextView) view.findViewById(R.id.follower);
        star = (TextView) view.findViewById(R.id.star);
        posts = (TextView) view.findViewById(R.id.btn_posts);
        credit = (TextView) view.findViewById(R.id.credit);
        collections = (TextView) view.findViewById(R.id.btn_collections);

        presenter = new UserFragmentPresenter(this);
        presenter.setUserInfo();


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditInfoFragment frag = new EditInfoFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction tx = fm.beginTransaction();
                tx.replace(R.id.root_layout, frag, "TWO");
                tx.addToBackStack(null);
                tx.commit();
            }
        });
        posts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PostFragment frag = new PostFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction tx = fm.beginTransaction();
                tx.replace(R.id.root_layout, frag, "THREE");
                tx.addToBackStack(null);
                tx.commit();
            }
        });
        collections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CollectionFragment frag = new CollectionFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction tx = fm.beginTransaction();
                tx.replace(R.id.root_layout, frag, "FOUR");
                tx.addToBackStack(null);
                tx.commit();
            }
        });

        return view;
    }


    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        MainActivity.currentFrag = Constant.FRAGMENT_USER;
    }

    public ImageView getAvatar() {
        return avatar;
    }

    public void setAvatar(ImageView avatar) {
        this.avatar = avatar;
    }

    public TextView getName() {
        return name;
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public TextView getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower.setText(follower);
    }

    public TextView getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star.setText(star);
    }

    public TextView getCredit() {
        return credit;
    }

    public void setCredit(String star) {
        this.credit.setText(star);
    }
}
