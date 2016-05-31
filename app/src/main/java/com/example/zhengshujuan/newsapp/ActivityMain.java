package com.example.zhengshujuan.newsapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * Created by zhengshujuan on 2016/5/31.
 */
public class ActivityMain extends Activity {
    private static final String TAG = "A1";
   WebView mWebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1_activity);
        getUrl();
        SlidingMenu menu = new SlidingMenu(this);
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

    }
//加载网页
    public void getUrl() {
        String url = "http://www.baidu.com";
        mWebView=new WebView(this);
        mWebView.getSettings().getJavaScriptEnabled();
        mWebView.loadUrl(url);
        mWebView.setWebViewClient(new WebViewClient());
        setContentView(mWebView);
    }
//
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if ((keyCode==KeyEvent.KEYCODE_BACK)&&mWebView.canGoBack()){
//            mWebView.goBack();
//            Log.d(TAG, "onKeyDown: ......该方法开始执行了...");
//            return true;
//        }
//        return false;
//    }
}
