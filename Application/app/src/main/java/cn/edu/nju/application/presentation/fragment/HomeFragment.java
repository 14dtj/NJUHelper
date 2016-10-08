package cn.edu.nju.application.presentation.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import cn.edu.nju.application.R;
import cn.edu.nju.application.presentation.activity.MainActivity;
import cn.edu.nju.application.presentation.util.Constant;

/**
 * Created by phoebegl on 16/9/28.
 */

public class HomeFragment extends BaseFragment{
    private ListView postList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homefrag_layout,
                container, false);
        postList = (ListView) view.findViewById(R.id.list);
        String[] from={"name","id"};              //这里是ListView显示内容每一列的列名
        int[] to = {R.id.title_text,R.id.content_text};

        String[] userName={"zhangsan","lisi","wangwu","zhaoliu"}; //这里第一列所要显示的人名
        String[] userId={"1001","1002","1003","1004"};  //这里是人名对应的ID

        ArrayList<HashMap<String,String>> list=null;
        HashMap<String,String> map=null;
        //创建ArrayList对象；
        list=new ArrayList<HashMap<String,String>>();
        //将数据存放进ArrayList对象中，数据安排的结构是，ListView的一行数据对应一个HashMap对象，
        //HashMap对象，以列名作为键，以该列的值作为Value，将各列信息添加进map中，然后再把每一列对应
        //的map对象添加到ArrayList中

        for(int i=0; i<4; i++){
            map=new HashMap<String,String>();       //为避免产生空指针异常，有几列就创建几个map对象
            map.put("id", userId[i]);
            map.put("name", userName[i]);
            list.add(map);
        }

        //创建一个SimpleAdapter对象
        SimpleAdapter adapter=new SimpleAdapter(view.getContext(),list,R.layout.simplepost_layout,from,to);
        //调用ListActivity的setListAdapter方法，为ListView设置适配器
        postList.setAdapter(adapter);
        return view;
    }


    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();

        MainActivity.currentFrag = Constant.FRAGMENT_HOME;

    }


}
