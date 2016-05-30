package com.example.zhengshujuan.newsapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Toast;

import news.common.LogUtil;

/**
 * Created by zhengshujuan on 2016/5/30.
 */
public class MyBaseActivity extends Activity {
    protected int screen_w;
    protected int screen_h;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    screen_w=getWindowManager().getDefaultDisplay().getWidth();
        screen_h=getWindowManager().getDefaultDisplay().getHeight();
    }
    //生命周期的调试

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.d(LogUtil.TAG,getClass().getSimpleName()+"onStart()");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d(LogUtil.TAG,getClass().getSimpleName()+"onCreate()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.d(LogUtil.TAG,getClass().getSimpleName()+"onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.d(LogUtil.TAG,getClass().getSimpleName()+"onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.d(LogUtil.TAG,getClass().getSimpleName()+"onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.d(LogUtil.TAG,getClass().getSimpleName()+"onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.d(LogUtil.TAG,getClass().getSimpleName()+"onDetroy()");
    }

    public void openActivity(Class<?> pClass,Bundle bundle,Uri uri){
        Intent intent=new Intent(this, pClass);
        if(bundle!=null)
            intent.putExtras(bundle);
        if(uri!=null)
            intent.setData(uri);
        startActivity(intent);
    }
    //通过class名字进行界面跳转只带Bundle数据
    public void openActivity(Class<?> pClass,Bundle bundle) {
        openActivity(pClass, bundle, null);
    }
    //通过class名字进行界面跳转
    public void openActivity(Class<?> pClass){
        openActivity(pClass,null,null);
    }
   // 通过action字符串进行界面跳转
    public void openActivity(String action){
        openActivity(action);
    }
    //通过action字符串进行界面跳转,只带Bundle数据
    public void openActivity(String action,Bundle bundle) {
        openActivity(action, bundle);
    }
    public void openActivity(String action,Bundle bundle,Uri uri){
        Intent intent=new Intent(action);
        if (bundle!=null)
            intent.putExtras(bundle);
        if (uri!=null)
            intent.setData(uri);
        startActivity(intent);
        /*
        公共功能封装
        * */
    }
    private Toast toast;
    public void showToast(int resId){
        showToast(getString(resId));
    }

    private void showToast(String msg) {
        if (toast==null)
            toast=Toast.makeText(this,msg,Toast.LENGTH_SHORT);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setText(msg);
        toast.show();
    }

}
