package com.example.zhengshujuan.newsapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.zhengshujuan.newsapp.ui.MyBaseActivity;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * Created by zhengshujuan on 2016/5/31.
 */
public class ActivityMain extends MyBaseActivity implements View.OnClickListener {

    WebView mWebView;
    //初始化侧拉菜单界面控件
    RelativeLayout viewNews;
    RelativeLayout viewLocal;
    RelativeLayout viewComment;
    RelativeLayout viewRead;
    RelativeLayout viewPic;
    SlidingMenu menu;
    //初始化主界面布局控件
    ImageView im_set;
    ImageView im_share;
    TextView tv_title;
    RelativeLayout layoutContent;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1_activity);
        //主界面的控件
//        getUrl();
        menu = new SlidingMenu(this);
        //设置侧滑菜单在左边
        menu.setMode(SlidingMenu.LEFT_RIGHT);
        //menu.setMode(SlidingMenu.RIGHT);
        //是否可以打开滑动手势
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        //设置可拉的阴影面积
        //  menu.setShadowDrawable(R.drawable.shadow);
        //滑动菜单背后宽度
        menu.setBehindWidthRes(R.dimen.show_width);
        //设置滑动菜单试图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        //设置渐入渐出效果值
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.sliding_menu);
        menu.setSecondaryMenu(R.layout.lead2);

        //侧拉菜单
        viewNews = (RelativeLayout) findViewById(R.id.menu_news);
        viewRead = (RelativeLayout) findViewById(R.id.menu_read);
        viewLocal = (RelativeLayout) findViewById(R.id.menu_local);
        viewComment = (RelativeLayout) findViewById(R.id.meun_comment);
        viewPic = (RelativeLayout) findViewById(R.id.menu_pic);
        viewNews.setOnClickListener(this);
        viewLocal.setOnClickListener(this);
        viewComment.setOnClickListener(this);
        viewRead.setOnClickListener(this);
        viewPic.setOnClickListener(this);

    }

    //加载网页
//    public void getUrl() {
//        String url = "http://www.baidu.com";
//        mWebView = new WebView(this);
//        mWebView.getSettings().getJavaScriptEnabled();
//        mWebView.loadUrl(url);
//        mWebView.setWebViewClient(new WebViewClient());
//        setContentView(mWebView);
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu_news:
                Toast.makeText(ActivityMain.this, "你点击了news", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_read:
                break;
            case R.id.menu_local:
                break;
            case R.id.meun_comment:
                break;
            case R.id.menu_pic:
                break;
        }
    }

    //初始化标题栏文本
    private void Title(String title) {
        tv_title = (TextView) findViewById(R.id.tv_main_title);
        tv_title.setText(title);
    }

    @Override
    public void onBackPressed() {
//        if (mWebView.canGoBack()) {
//            mWebView.goBack();
//        }
        //如果当前菜单栏显示.则返回主界面
        if (menu.isMenuShowing()) {
            menu.showContent();
        } else {
            //按两次退出
            exitTwice();
        }
        // super.onBackPressed();
    }

    private boolean isFristExit = true;

    //按两次退出
    private void exitTwice() {
        if (isFristExit) {
            Toast.makeText(ActivityMain.this, "再按一次退出", Toast.LENGTH_SHORT).show();
            isFristExit = false;
            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                        isFristExit = true;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }.start();
        } else {
            finish();
        }
    }



}
