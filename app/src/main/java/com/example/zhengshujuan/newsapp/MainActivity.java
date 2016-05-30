package com.example.zhengshujuan.newsapp;

import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.zhengshujuan.newsapp.adapter.LeadImgAdapter;
import com.example.zhengshujuan.newsapp.ui.MyBaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends MyBaseActivity {
    public static final String TAG="MainActivity";
    private ViewPager viewPager;
    private ImageView[] points = new ImageView[4];
    private LeadImgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        //设置每一个具体界面的样式\
        SharedPreferences pre=getSharedPreferences("runconfig",MODE_PRIVATE);
        boolean isFirst = pre.getBoolean("isFirstRun", true);
        //如果不是第一次打开，则直接跳转到Logo界面
        if(!isFirst){
            openActivity(ActivityLogo.class);
            finish();
            return;
        }
        List<View> viewList = new ArrayList<>();
        viewList.add(getLayoutInflater().inflate(R.layout.lead1, null));
        viewList.add(getLayoutInflater().inflate(R.layout.lead2, null));
        viewList.add(getLayoutInflater().inflate(R.layout.lead3, null));
        viewList.add(getLayoutInflater().inflate(R.layout.lead4, null));
        adapter=new LeadImgAdapter(viewList);
        //设置适配器
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(listner);
        Log.d(TAG, "onCreate: "+viewList);
        points[0] = (ImageView) findViewById(R.id.iv_p1);
        points[1] = (ImageView) findViewById(R.id.iv_p2);
        points[2] = (ImageView) findViewById(R.id.iv_p3);
        points[3] = (ImageView) findViewById(R.id.iv_p4);
        setPoint(0);
    }


    private void setPoint(int index) {
        for (int i = 0; i < points.length; i++) {
            if (i == index) {
                points[i].setAlpha(255);
            } else {
                points[i].setAlpha(100);
            }
            Log.d(TAG, "setPoint: "+points);
        }
    }

    //界面切换后调用
    private ViewPager.OnPageChangeListener listner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            setPoint(position);
            if (position>=3){
           openActivity(ActivityLogo.class);
                finish();
                SharedPreferences pre=getSharedPreferences("runconfig",MODE_PRIVATE);
                SharedPreferences.Editor editor=pre.edit();
                editor.putBoolean("isFristRun",false);
                editor.commit();
                Log.d(TAG, "onPageSelected: "+editor);
                Log.d(TAG, "onPageSelected: 我在这里");
            }
        }
//滑动状态变化时调用
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
