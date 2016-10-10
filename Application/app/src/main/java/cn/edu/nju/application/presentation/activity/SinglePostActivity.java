package cn.edu.nju.application.presentation.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cn.edu.nju.application.R;
import cn.edu.nju.application.data.DataFactory;
import cn.edu.nju.application.data.IPostDao;
import cn.edu.nju.application.presentation.model.Post;
import cn.edu.nju.application.presentation.util.Constant;

/**
 * Created by tjDu on 2016/10/10.
 */

public class SinglePostActivity extends Activity {
    private int postId;
    private IPostDao dao;
    private TextView textView;
    private ImageView imageView;
    private TextView authorText;
    private TextView starText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_post);
        Bundle bundle = getIntent().getExtras();
        postId = Integer.parseInt(bundle.get("id") + "");
        textView = (TextView) findViewById(R.id.single_post_text);
        authorText = (TextView) findViewById(R.id.author_text);
        starText = (TextView) findViewById(R.id.star_num_text);
        imageView = (ImageView) findViewById(R.id.single_post_img);
        dao = DataFactory.getPostDao();
        Post post = dao.showPost(postId + 1);
        textView.setText(post.getContent());
        starText.setText("赞："+post.getStar_num());
        authorText.setText(post.getAuthorName()+"分享");
        imageView.setImageResource(Constant.postImages[postId]);
    }

}
