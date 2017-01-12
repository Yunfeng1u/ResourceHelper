package com.luyunfeng.resourcehelper;

import android.app.Application;

/**
 * Created by luyunfeng on 2017/1/10.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ResourceHelper.init(getApplicationContext());
    }
}
