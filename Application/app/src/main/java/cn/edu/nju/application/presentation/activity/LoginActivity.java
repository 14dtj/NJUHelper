package cn.edu.nju.application.presentation.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import cn.edu.nju.application.R;
import cn.edu.nju.application.presentation.model.User;
import cn.edu.nju.application.presentation.presenter.LoginPresenter;
import cn.edu.nju.application.presentation.presenter.impl.LoginPresenterImpl;
import cn.edu.nju.application.presentation.presenter.impl.SignUpPresenterImpl;
import cn.edu.nju.application.presentation.view.LoginView;

import static cn.edu.nju.application.R.id.login_username;
import static cn.edu.nju.application.R.id.rg;

/**
 * Created by phoebegl on 2016/10/6.
 */

public class LoginActivity extends Activity implements LoginView, View.OnClickListener{

    private Button button,tosign;
    private EditText username,password;
    private ProgressBar progress;

    public LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        progress = (ProgressBar)findViewById(R.id.progress);
        username = (EditText)findViewById(R.id.login_username);
        password = (EditText)findViewById(R.id.login_password);
        button = (Button) findViewById(R.id.btn_login);
        tosign = (Button) findViewById(R.id.btn_tosignup) ;

        presenter = new LoginPresenterImpl(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login(username.getText().toString(),password.getText().toString());
            }
        });
        tosign.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this,"用户名或密码错误",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
        MainActivity.setLoginUser(user);
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this,SignUpActivity.class));
    }
}
