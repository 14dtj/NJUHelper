package cn.edu.nju.application.presentation.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import cn.edu.nju.application.R;
import cn.edu.nju.application.data.DataFactory;
import cn.edu.nju.application.data.IPostDao;
import cn.edu.nju.application.data.PostDaoImpl;
import cn.edu.nju.application.presentation.model.Post;

/**
 * Created by tjDu on 2016/10/10.
 */

public class AddPostActivity extends Activity {
    private TextView titleText;
    private TextView contentText;
    private Button publishButton;
    private IPostDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dao = DataFactory.getPostDao();
        setContentView(R.layout.add_post);
        titleText = (TextView) findViewById(R.id.title_text);
        contentText = (TextView) findViewById(R.id.content_text);
        publishButton = (Button) findViewById(R.id.publish_button);
        addListener();
    }

    public void addListener() {
        publishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = MainActivity.getLoginUser().getUsername();
                Post post = new Post(username, contentText.getText().toString(), titleText.getText().toString(), true, "旅行");
                dao.addPost(post);
                return2Main();
            }
        });
    }

    public void return2Main() {
        Toast.makeText(this, "发表成功", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
