package cn.edu.nju.application.presentation.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.text.TextUtils;

import cn.edu.nju.application.R;
import cn.edu.nju.application.presentation.util.HeadPanel;
import cn.edu.nju.application.presentation.util.Constant;
import cn.edu.nju.application.presentation.util.BottomPanel;
import cn.edu.nju.application.presentation.fragment.BaseFragment;

public class MainActivity extends Activity implements BottomPanel.BottomPanelCall{

    private BottomPanel bottomPanel = null;
    private HeadPanel headPanel = null;
    private FragmentManager fragmentManager = null;
    private FragmentTransaction fragmentTransaction = null;

    public static String currentFrag = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        fragmentManager = getFragmentManager();
        setDefaultFirstFragment(Constant.FRAGMENT_HOME);
    }

    private void initUI(){
        bottomPanel = (BottomPanel)findViewById(R.id.bottom_layout);
        if(bottomPanel != null){
            bottomPanel.init();
            bottomPanel.setBottomCall(this);
        }

        headPanel = (HeadPanel)findViewById(R.id.head_layout);
        if(headPanel != null) {
            headPanel.init();
        }
    }


    @Override
    public void BottomPanelClick(int itemID) {
        String tag = "";
        if((itemID & Constant.BTN_HOME) != 0){
            tag = Constant.FRAGMENT_HOME;
        }else if((itemID & Constant.BTN_TOPIC) != 0){
            tag = Constant.FRAGMENT_TOPIC;
        }else if((itemID & Constant.BTN_STORE) != 0){
            tag = Constant.FRAGMENT_STORE;
        }else if((itemID & Constant.BTN_USER) != 0){
            tag = Constant.FRAGMENT_USER;
        }
        setTabSelection(tag); //切换Fragment
        headPanel.setMiddleTitle(tag);
    }

    /**切换fragment
     * @param tag
     */
    private  void switchFragment(String tag){
        if(TextUtils.equals(tag, currentFrag)){
            return;
        }
        //把上一个fragment detach掉
        if(currentFrag != null && !currentFrag.equals("")){
            detachFragment(getFragment(currentFrag));
        }
        attachFragment(R.id.fragment_content, getFragment(tag), tag);
        commitTransactions( tag);
    }

    /**设置选中的Tag
     * @param tag
     */
    public  void setTabSelection(String tag) {
        // 开启一个Fragment事务
        fragmentTransaction = fragmentManager.beginTransaction();
        switchFragment(tag);

    }

    private Fragment getFragment(String tag){

        Fragment f = fragmentManager.findFragmentByTag(tag);

        if(f == null){
            f = BaseFragment.newInstance(getApplicationContext(), tag);
        }
        return f;

    }

    private void commitTransactions(String tag){
        if (fragmentTransaction != null && !fragmentTransaction.isEmpty()) {
            fragmentTransaction.commit();
            currentFrag = tag;
            fragmentTransaction = null;
        }
    }

    private FragmentTransaction ensureTransaction( ){
        if(fragmentTransaction == null){
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        }
        return fragmentTransaction;
    }

    private void attachFragment(int layout, Fragment f, String tag){
        if(f != null){
            if(f.isDetached()){
                ensureTransaction();
                fragmentTransaction.attach(f);

            }else if(!f.isAdded()){
                ensureTransaction();
                fragmentTransaction.add(layout, f, tag);
            }
        }
    }

    private void detachFragment(Fragment f){

        if(f != null && !f.isDetached()){
            ensureTransaction();
            fragmentTransaction.detach(f);
        }
    }

    private void setDefaultFirstFragment(String tag) {
        setTabSelection(tag);
        bottomPanel.setDefaultSelect();
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        currentFrag = "";
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // TODO Auto-generated method stub
    }
}
