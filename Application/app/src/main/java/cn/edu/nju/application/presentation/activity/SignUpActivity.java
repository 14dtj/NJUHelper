package cn.edu.nju.application.presentation.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import cn.edu.nju.application.R;
import cn.edu.nju.application.presentation.model.User;
import cn.edu.nju.application.presentation.presenter.SignUpPresenter;
import cn.edu.nju.application.presentation.presenter.impl.SignUpPresenterImpl;
import cn.edu.nju.application.presentation.view.SignUpView;

/**
 * Created by phoebegl on 2016/10/7.
 */

public class SignUpActivity extends Activity implements SignUpView,View.OnClickListener{

    private Button button;
    private ProgressBar progress;
    private EditText username,password,email;
    private RadioGroup rg;

    private SignUpPresenter presenter;
    private String sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        progress = (ProgressBar)findViewById(R.id.progressBar);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        email = (EditText)findViewById(R.id.email);
        button = (Button) findViewById(R.id.btn_signup);
        rg = (RadioGroup) findViewById(R.id.rg);

        presenter = new SignUpPresenterImpl(this);
        button.setOnClickListener(this);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton btn = (RadioButton)findViewById(checkedId);
                sex = String.valueOf(btn.getText());
            }
        });
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showLoading() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this,"该用户名已存在!",Toast.LENGTH_SHORT);
    }

    @Override
    public void toMainActivity(User user) {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onClick(View v) {
        User user = new User(username.getText().toString(),password.getText().toString(),sex,email.getText().toString());
        presenter.signUp(user);
    }
}
