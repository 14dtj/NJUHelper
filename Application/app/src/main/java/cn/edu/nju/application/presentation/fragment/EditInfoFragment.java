package cn.edu.nju.application.presentation.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import cn.edu.nju.application.R;
import cn.edu.nju.application.presentation.activity.MainActivity;
import cn.edu.nju.application.presentation.presenter.EditInfoPresenter;
import cn.edu.nju.application.presentation.util.Constant;

/**
 * Created by phoebegl on 2016/10/9.
 */

public class EditInfoFragment extends Fragment{

    private EditInfoPresenter presenter;

    private ImageView avatar;
    private TextView name;
    private EditText password,email,address;
    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View settingLayout = inflater.inflate(R.layout.edit_info_layout,
                container, false);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        avatar = (ImageView)settingLayout.findViewById(R.id.eavatar);
        name = (TextView) settingLayout.findViewById(R.id.eusername);
        password = (EditText)settingLayout.findViewById(R.id.epassword);
        email = (EditText)settingLayout.findViewById(R.id.eemail);
        address = (EditText)settingLayout.findViewById(R.id.address);
        button = (Button)settingLayout.findViewById(R.id.btn_update);

        presenter = new EditInfoPresenter(this);
        presenter.showCurrentInfo();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.updateInfo();
            }
        });

        return settingLayout;
    }


    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
    }

    public ImageView getAvatar() {
        return avatar;
    }

    public void setAvatar(ImageView avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name.getText().toString();
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public String getPassword() {
        return password.getText().toString();
    }

    public void setPassword(String password) {
        this.password.setText(password);
    }

    public String getEmail() {
        return email.getText().toString();
    }

    public void setEmail(String email) {
        this.email.setText(email);
    }

    public String getAddress() {
        return address.getText().toString();
    }

    public void setAddress(String address) {
        this.address.setText(address);
    }

}
