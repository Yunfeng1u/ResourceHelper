package com.luyunfeng.resourcehelper;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.ArrayRes;
import android.support.annotation.StringRes;

/**
 * Created by luyunfeng on 2017/1/10.
 */

public class MyApplication extends Application {

    // 屏幕分辨率
    public static int mScreenWidth;
    public static int mScreenHeight;

    // 状态栏高度
    public static int mStatusBarHeight;

    // 密度
    public static float mScaledDensity;
    public static float mDensity;

    // dip
    public static int mScreenDip;

    private volatile static MyApplication instance;

    public static MyApplication getInstance() {
        return instance;
    }

    public static Context getContext() {
        return instance.getApplicationContext();
    }


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        resources = instance.getResources();
    }
}
