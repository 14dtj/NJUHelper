package cn.edu.nju.application.presentation.presenter;

import android.widget.Toast;

import cn.edu.nju.application.data.IUserDao;
import cn.edu.nju.application.data.UserDaoImpl;
import cn.edu.nju.application.presentation.activity.MainActivity;
import cn.edu.nju.application.presentation.fragment.EditInfoFragment;
import cn.edu.nju.application.presentation.fragment.UserFragment;
import cn.edu.nju.application.presentation.model.User;

/**
 * Created by phoebegl on 2016/10/9.
 */

public class EditInfoPresenter {
    private IUserDao dao;
    private EditInfoFragment view;

    public EditInfoPresenter(EditInfoFragment view) {
        this.dao = new UserDaoImpl();
        this.view = view;
    }

    public void showCurrentInfo() {
        User temp = MainActivity.getLoginUser();
        User user = dao.showUserInfo(temp.getUsername(),temp.getPassword());
        view.setName(user.getUsername());
        view.setPassword(user.getPassword());
        view.setEmail(user.getEmail());
        view.setAddress(user.getAddress());
    }

    public void updateInfo() {
        User user = new User(view.getName(),view.getPassword(),MainActivity.getLoginUser().getGender(),view.getAddress(),view.getEmail());
        int result = dao.updateUserInfo(user);

        if(result > 0) {
            Toast.makeText(view.getActivity().getApplicationContext(),"修改成功!",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(view.getActivity().getApplicationContext(),"修改失败!",Toast.LENGTH_SHORT).show();
        }
    }

}
