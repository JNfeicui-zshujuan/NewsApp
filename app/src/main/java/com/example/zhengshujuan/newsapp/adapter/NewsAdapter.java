package com.example.zhengshujuan.newsapp.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.zhengshujuan.newsapp.R;
import com.example.zhengshujuan.newsapp.entity.News;

/**
 * Created by zhengshujuan on 2016/6/1.
 */
public class NewsAdapter extends MyBaseAdapter<News>{
    //加载图片之前默认图片
    private Bitmap defaultBitmap;
    private ListView listView;

    public NewsAdapter(Context context,ListView lv) {
        super(context);
        defaultBitmap= BitmapFactory.decodeResource(context.getResources(),
                R.drawable.defaultpic);
        listView=lv;
    }



    //返回每一个字条目的视图
    @Override
    public View getMyView(int position, View convertView, ViewGroup parent) {
        HoldView holdView=null;
        if (convertView==null){
            convertView=inflater.inflate(R.layout.mainlist_detail,null);
            holdView=new HoldView(convertView);
            convertView.setTag(holdView);
        }else {
            holdView= (HoldView) convertView.getTag();
        }
        News news=list.get(position);
        holdView.tv_main_title.setText(news.getTitle());
        holdView.tv_main_text.setText(news.getSummary());
        holdView.iv_main.setImageBitmap(defaultBitmap);//默认图片
        return convertView;
    }

    private class HoldView {
        public ImageView iv_main;
        public TextView tv_main_title;
        public TextView tv_main_text;
        public HoldView(View convertView) {
            this.iv_main= (ImageView) convertView.findViewById(R.id.imageView1);
            this.tv_main_title= (TextView) convertView.findViewById(R.id.textView1);
            this.tv_main_text= (TextView) convertView.findViewById(R.id.textView2);
        }
    }
}
