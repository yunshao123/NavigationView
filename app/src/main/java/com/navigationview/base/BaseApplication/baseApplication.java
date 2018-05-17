package com.navigationview.base.BaseApplication;

import android.app.Application;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;

/**
 * @Auth Mr.lc(兰超)
 * @Date 2018/5/11
 * @Time 10:31
 */
public class baseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(getApplicationContext());
        SDKInitializer.setCoordType(CoordType.BD09LL);
    }
}
