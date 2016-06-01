package com.example.zhengshujuan.newsapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.zhengshujuan.newsapp.entity.News;
import com.example.zhengshujuan.newsapp.ui.MyBaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengshujuan on 2016/6/1.
 */
public class MyBaseAdapter extends BaseAdapter {
    protected LayoutInflater inflater;
    protected Context context;
    protected List<News> myList=new ArrayList<>();
    protected ArrayList<News> list=new ArrayList<>();
    //定义构造方法,并初始化context,inflater

    public MyBaseAdapter(Context context){
            this.context=context;
        inflater=LayoutInflater.from(context);
    }
    //清除所有数据
    public void clear(){
        myList.clear();
    }
    //查找所有数据
    public List<News> get
    @Override
    public int getCount() {
        if (list == null) {
            return 0;
        } else {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
